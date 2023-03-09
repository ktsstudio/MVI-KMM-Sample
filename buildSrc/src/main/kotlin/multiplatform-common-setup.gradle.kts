import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-parcelize")
}

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true) ::iosArm64 else ::iosX64

    iosTarget("ios") {}

    sourceSets {
        all { languageSettings.optIn("kotlin.RequiresOptIn") }

        commonMain {
            apis(
                Deps.KmmResources.core,
            )
            implementations(
                Deps.MVI.core,
                Deps.MVI.main,
                Deps.MVI.logging,
                Deps.MVI.coroutines,
                Deps.Koin.core,
                Deps.Kotlin.kmmParcelize,
                Deps.Kotlin.Coroutines.core,
                Deps.Kotlin.dateTime,
                Deps.Kotlin.immutalbeCollections,
                Deps.Logging.napier,
                Deps.Kts.kotlinUtils,
            )
        }

        val androidMain by getting {
            implementations(
                Deps.Koin.android,
                Deps.Kotlin.Coroutines.android,
                Deps.KmmResources.android,
            )
        }

        val iosMain by getting {
            implementations(
                Deps.Kotlin.Coroutines.core,
            )
        }
    }
}

android {
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
