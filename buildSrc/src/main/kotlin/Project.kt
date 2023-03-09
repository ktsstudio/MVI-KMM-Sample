import com.android.build.gradle.LibraryExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

fun DependencyHandler.implementation(vararg dependecies: Any) {
    dependecies.forEach { dependecy ->
        implementation(dependecy)
    }
}

fun DependencyHandler.composeDependency() {
    implementation(Deps.AndroidX.Compose.ui)
    implementation(Deps.AndroidX.Compose.Tooling.uiTooling)
    implementation(Deps.AndroidX.Compose.Tooling.uiToolingPreview)
    implementation(Deps.AndroidX.Compose.viewbinding)
    implementation(Deps.AndroidX.Compose.foundation)
    implementation(Deps.AndroidX.Compose.runtime)
    implementation(Deps.AndroidX.Compose.material)
    implementation(Deps.AndroidX.Compose.materialIconsCore)
    implementation(Deps.AndroidX.Compose.materialIconsExtended)
    implementation(Deps.AndroidX.Compose.constraintLayout)
    implementation(Deps.AndroidX.Compose.viewModel)
    implementation(Deps.AndroidX.Compose.navigationCompose)
    implementation(Deps.AndroidX.Compose.accompanistPager)
    implementation(Deps.AndroidX.Compose.accompanistPagerIndicators)
    implementation(Deps.AndroidX.Compose.accompanistSystemUiController)
    implementation(Deps.AndroidX.Compose.accompanistSwipeRefresh)
    implementation(Deps.AndroidX.Compose.accompanistWebView)
    implementation(Deps.AndroidX.Compose.accompanistFlowLayout)
    implementation(Deps.AndroidX.Compose.accompanistPermissions)
    implementation(Deps.AndroidX.Compose.shimmer)
    implementation(Deps.AndroidX.CustomView.core)
    implementation(Deps.AndroidX.CustomView.poolingContainer)
    implementation(Deps.AndroidX.Landscapist.glide)
    implementation(Deps.AndroidX.Landscapist.landscapistPlaceholder)
    implementation(Deps.AndroidX.Landscapist.landscapistAnimation)
    implementation(Deps.AndroidX.Landscapist.landscapistPalette)
    implementation(Deps.KmmImages.compose)
}

private fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

private fun DependencyHandler.implementation(
    dependencyNotation: String,
    dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
    this,
    "implementation",
    dependencyNotation,
    dependencyConfiguration
)

internal fun Project.android(configure: Action<LibraryExtension>): Unit =
    (this as ExtensionAware).extensions.configure("android", configure)

fun KotlinSourceSet.implementations(
    vararg dependecies: Any,
) = dependencies {
    dependecies.forEach(::implementation)
}

fun KotlinSourceSet.apis(
    vararg dependecies: Any,
) = dependencies {
    dependecies.forEach(::api)
}

enum class FeatureModuleType {
    API,
    IMPL,
    PRESENTATION;

    val actualName get() = name.toLowerCase()

    fun list() = values().map { it.name.toLowerCase() }
}

val Project.isApiModule
    get() = (name == FeatureModuleType.API.actualName)

val Project.isImplModule
    get() = (name == FeatureModuleType.IMPL.actualName)

val Project.isPresentationModule
    get() = (name == FeatureModuleType.PRESENTATION.actualName)
