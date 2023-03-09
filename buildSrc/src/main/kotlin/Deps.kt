object Versions {
    object Android {
        const val compileSdk = 33
        const val targetSdk = compileSdk
        const val minSdk = 21
    }

    object Ios {
        const val podVersion = "1.0"

        const val deploymentTarget = "14.1"
    }

    const val kotlinVersion = "1.8.10"
}

object Deps {

    object Kotlin {

        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

        object Coroutines {
            private const val version = "1.6.4"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Android {

        const val gradlePlugin = "com.android.tools.build:gradle:7.4.2"
    }

    object AndroidX {

        object Compose {
            const val compilerVersion = "1.4.3"
            private const val version = "1.4.0-beta02"

            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val material = "androidx.compose.material:material:$version"
            const val ui = "androidx.compose.ui:ui:$version"

            const val activity = "androidx.activity:activity-compose:1.6.1"

            object Tooling {
                const val ui = "androidx.compose.ui:ui-tooling:$version"
                const val preview = "androidx.compose.ui:ui-tooling-preview:$version"
            }
        }
    }

    object Koin {
        private const val version = "3.1.5"

        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
    }

    object Logging {
        const val napier = "io.github.aakira:napier:1.5.0"
    }

    object MVI {
        private const val version = "3.0.2"
        const val core = "com.arkivanov.mvikotlin:mvikotlin:$version"
        const val main = "com.arkivanov.mvikotlin:mvikotlin-main:$version"
        const val logging = "com.arkivanov.mvikotlin:mvikotlin-logging:$version"
        const val coroutines = "com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:$version"
    }

    object KmmViewModel {
        private const val version = "0.15.0"

        const val core = "dev.icerock.moko:mvvm-core:$version"
        const val cFlow = "dev.icerock.moko:mvvm-flow:$version"
    }

    object KmmResources {
        private const val version = "0.20.1"
        const val core = "dev.icerock.moko:resources:$version"
        const val gradlePlugin = "dev.icerock.moko:resources-generator:$version"
        const val android = "dev.icerock.moko:resources-compose:$version"
    }

    object KmmColors {
        private const val version = "0.9.0"
        const val core = "dev.icerock.moko:graphics:$version"
    }

    object KmmImages {
        private const val version = "1.1.4"
        const val gradlePlugin = "io.github.skeptick.libres:gradle-plugin:$version"
        const val compose = "io.github.skeptick.libres:libres-compose:$version"
    }
}
