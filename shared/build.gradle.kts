import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("io.github.skeptick.libres")
    id("dev.icerock.mobile.multiplatform-resources")
}

libres {
    generatedClassName = "KImages"
    generateNamedArguments = true
    baseLocaleLanguageCode = "ru"
}

multiplatformResources {
    multiplatformResourcesPackage = "ru.kts.mobile.sample"
    iosBaseLocalizationRegion = "ru"
    disableStaticFrameworkWarning = true
}

version = Versions.Ios.podVersion

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true) ::iosArm64 else ::iosX64

    iosTarget("ios") {}

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = Versions.Ios.deploymentTarget
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true

            export(Deps.KmmColors.core)
            export(Deps.KmmResources.core)
            export(Deps.KmmViewModel.cFlow)
            export(Deps.KmmViewModel.core)
        }
    }

    sourceSets {
        all { languageSettings.optIn("kotlin.RequiresOptIn") }

        commonMain {
            dependencies {
                api(Deps.KmmResources.core)
                api(Deps.KmmViewModel.core)
                api(Deps.KmmViewModel.cFlow)

                implementation(Deps.Koin.core)
                implementation(Deps.Kotlin.Coroutines.core)
                implementation(Deps.Logging.napier)
                implementation(Deps.MVI.core)
                implementation(Deps.MVI.coroutines)
                implementation(Deps.MVI.logging)
                implementation(Deps.MVI.main)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Deps.KmmResources.android)
            }
        }

        val iosMain by getting {}
    }
}
android {
    namespace = "ru.kts.mobile.sample"
    compileSdk = Versions.Android.compileSdk
    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")

        res.srcDirs(
            File(buildDir, "generated/moko/androidMain/res"),
            File(buildDir, "generated/libres/android/resources"),
        )
    }
    defaultConfig {
        minSdk = Versions.Android.minSdk
        targetSdk = Versions.Android.targetSdk
    }
}
