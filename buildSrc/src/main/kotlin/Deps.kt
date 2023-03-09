object Versions {
    object Android {
        const val compileSdk = 33
        const val targetSdk = compileSdk
        const val minSdk = 26
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

        const val uuid = "com.benasher44:uuid:0.3.0"

        const val uuidKmm = "com.benasher44:uuid:0.4.0"

        const val immutalbeCollections = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5"

        object Detekt {
            const val version = "1.22.0"
            const val pluginName = "io.gitlab.arturbosch.detekt"
            const val formatting = "io.gitlab.arturbosch.detekt:detekt-formatting:$version"

            const val composeKodeRules = "ru.kode:detekt-rules-compose:1.2.1"
            const val composeTwitterRules = "com.twitter.compose.rules:detekt:0.0.17"
        }

        object Serialization {
            const val plugin = "plugin.serialization"
            const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1"
        }

        const val dateTime = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"

        const val kmmParcelize = "dev.icerock.moko:parcelize:0.7.1"

        object Coroutines {
            private const val version = "1.6.4"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }

    object Android {

        const val gradlePlugin = "com.android.tools.build:gradle:7.4.2"
        const val jdkDesugaring = "com.android.tools:desugar_jdk_libs:1.1.5"

        object Debug {
            const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.7"

            object Flipper {
                private const val version = "0.87.0"
                const val core = "com.facebook.flipper:flipper:$version"
                const val network = "com.facebook.flipper:flipper-network-plugin:$version"
                const val leakCanary = "com.facebook.flipper:flipper-leakcanary2-plugin:$version"
                const val soLoader = "com.facebook.soloader:soloader:0.10.1"
                const val noOp = "com.github.theGlenn:flipper-android-no-op:0.8.0"
            }
        }

        object Ui {
            const val material = "com.google.android.material:material:1.3.0"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
            const val viewBindingPropertyDelegate =
                "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.4.6"
            const val insetter = "dev.chrisbanes.insetter:insetter:0.6.0"
            const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
            const val adapterDelegate = "com.hannesdorfmann:adapterdelegates4:4.3.0"
            const val inputMask = "ru.tinkoff.decoro:decoro:1.5.0"
            const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

            object Glide {
                private const val version = "4.14.2"
                const val core = "com.github.bumptech.glide:glide:$version"
                const val annotations = "com.github.bumptech.glide:annotations:$version"
                const val compiler = "com.github.bumptech.glide:compiler:$version"
                const val okhttpIntegration = "com.github.bumptech.glide:okhttp3-integration:$version"
            }
        }

        object OkHttp {
            private const val version = "4.9.1"
            const val bom = "com.squareup.okhttp3:okhttp-bom:$version"
            const val core = "com.squareup.okhttp3:okhttp"
            const val logging = "com.squareup.okhttp3:logging-interceptor:$version"
        }

        object GooglePlayServices {
            const val plugin = "com.google.gms:google-services:4.3.8"
            const val crashlyticsPlugin = "com.google.firebase:firebase-crashlytics-gradle:2.7.1"
            const val appDistributionPlugin = "com.google.firebase:firebase-appdistribution-gradle:2.1.3"
            const val bom = "com.google.firebase:firebase-bom:28.2.0"
            const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
            const val analytics = "com.google.firebase:firebase-analytics-ktx"
        }

        object Validator {
            const val libphonenumber = "io.michaelrocks:libphonenumber-android:8.12.43"
        }
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.3.0"
        const val dataStore = "androidx.datastore:datastore-preferences:1.0.0-beta02"

        object Health {
            private const val version = "1.0.0-alpha11"
            const val healthConnect = "androidx.health.connect:connect-client:$version"
        }

        object SharedPreferences {
            private const val version = "1.2.0"
            const val preferenceKtx = "androidx.preference:preference-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.4.1"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val runtimeJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
        }

        object Navigation {
            private const val version = "2.5.0"

            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgsPlugin =
                "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Compose {
            const val compilerVersion = "1.4.3"
            private const val version = "1.4.0-beta02"
            private const val accompanistVersion = "0.29.1-alpha"

            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsCore = "androidx.compose.material:material-icons-core:$version"
            const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val material3 = "androidx.compose.material3:material3:1.1.0-alpha07"
            const val ui = "androidx.compose.ui:ui:$version"
            const val viewbinding = "androidx.compose.ui:ui-viewbinding:$version"

            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"

            const val navigationCompose = "androidx.navigation:navigation-compose:2.6.0-alpha06"

            const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.1"

            const val accompanistSystemUiController =
                "com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion"

            const val accompanistSwipeRefresh = "com.google.accompanist:accompanist-swiperefresh:$accompanistVersion"
            const val accompanistPager = "com.google.accompanist:accompanist-pager:$accompanistVersion"
            const val accompanistPagerIndicators =
                "com.google.accompanist:accompanist-pager-indicators:$accompanistVersion"
            const val accompanistWebView = "com.google.accompanist:accompanist-webview:$accompanistVersion"
            const val accompanistFlowLayout = "com.google.accompanist:accompanist-flowlayout:$accompanistVersion"
            const val accompanistPermissions = "com.google.accompanist:accompanist-permissions:$accompanistVersion"

            const val runtime = "androidx.lifecycle:lifecycle-runtime-compose:2.4.1"

            const val shimmer = "com.valentinilk.shimmer:compose-shimmer:1.0.3"

            const val htmlText = "de.charlex.compose:html-text:1.2.0"

            object Tooling {
                const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
                const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            }
        }

        object CustomView {
            const val core = "androidx.customview:customview:1.2.0-alpha01"
            const val poolingContainer = "androidx.customview:customview-poolingcontainer:1.0.0-beta01"
        }

        object Landscapist {
            private const val landscapistVersion = "2.1.1"

            const val glide = "com.github.skydoves:landscapist-glide:$landscapistVersion"
            const val landscapistPlaceholder = "com.github.skydoves:landscapist-placeholder:$landscapistVersion"
            const val landscapistAnimation = "com.github.skydoves:landscapist-animation:$landscapistVersion"
            const val landscapistPalette = "com.github.skydoves:landscapist-palette:$landscapistVersion"
        }
    }

    object Kts {
        const val kotlinUtils = "ru.ktsstudio.kotlin:kotlin-utils:0.1.7"
        const val coreNetworkOkHttp = "ru.ktsstudio.android:core-network-okhttp:0.0.3"

        object Auth {
            const val coreAuth = "ru.ktsstudio.kotlin:core-auth:0.0.4"
            const val coreAuthAndroid = "ru.ktsstudio.android:core-auth:0.0.3"
            const val featureAuthSms = "ru.ktsstudio.kotlin:feature-auth-sms:0.0.5"
            const val featureAuthSmsAndroid = "ru.ktsstudio.android:auth-sms:0.0.7"
        }

        object Utils {
            const val android = "ru.ktsstudio.android:utils:0.4.4@aar"
        }
    }

    object Apollo {
        private const val version = "3.7.3"
        const val gradlePlugin = "com.apollographql.apollo3:apollo-gradle-plugin:$version"
        const val runtime = "com.apollographql.apollo3:apollo-runtime:$version"
        const val adapters = "com.apollographql.apollo3:apollo-adapters:$version"
    }

    object Ktor {
        private const val version = "2.2.1"
        const val core = "io.ktor:ktor-client-core:$version"
        const val coreJvm = "io.ktor:ktor-client-core-jvm:$version"
        const val androidClient = "io.ktor:ktor-client-okhttp:$version"
        const val iosClient = "io.ktor:ktor-client-ios:$version"
        const val serialization = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val auth = "io.ktor:ktor-client-auth:$version"
        const val utils = "io.ktor:ktor-utils:$version"
    }

    object Koin {
        private const val version = "3.1.5"

        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
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

    object BuildKonfig {
        private const val version = "0.11.0"
        const val gradlePlugin = "com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:$version"
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
