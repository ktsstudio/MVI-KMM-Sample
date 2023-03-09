package plugins

import Deps
import android
import composeDependency
import implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.project

class AndroidFeature : Plugin<Project> {

    override fun apply(project: Project) = project.androidFeature()

    private fun Project.androidFeature() {
        plugins.run {
            apply("androidCompose")
        }

        android {
            sourceSets["main"].apply {
                kotlin.srcDirs("src/main/kotlin/")
                res.srcDir("src/main/res/")
            }
        }

        dependencies {
            implementation(project(":android:common-ui"))
            implementation(project(":android:common-util"))
            implementation(project(":android:navigation"))
            implementation(project(":shared:main"))

            implementation(Deps.AndroidX.Navigation.fragment)
            implementation(Deps.Koin.core)
            implementation(Deps.Koin.compose)
            implementation(Deps.Koin.android)
            implementation(Deps.Kts.Utils.android)
            implementation(Deps.Kotlin.Coroutines.android)
            implementation(Deps.Kotlin.immutalbeCollections)
            implementation(Deps.MVI.main)
            implementation(Deps.MVI.core)
            implementation(Deps.MVI.coroutines)
            implementation(Deps.KmmViewModel.core)
            implementation(Deps.KmmViewModel.cFlow)
            implementation(Deps.Logging.napier)
            composeDependency()
        }
    }
}
