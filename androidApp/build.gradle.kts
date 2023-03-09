plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "ru.kts.mobile.sample.android"
    compileSdk = Versions.Android.compileSdk
    defaultConfig {
        applicationId = "ru.kts.mobile.sample"
        minSdk =  Versions.Android.minSdk
        targetSdk =  Versions.Android.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.AndroidX.Compose.compilerVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))

    implementation(Deps.AndroidX.Compose.activity)
    implementation(Deps.AndroidX.Compose.foundation)
    implementation(Deps.AndroidX.Compose.material)
    implementation(Deps.AndroidX.Compose.ui)
    implementation(Deps.AndroidX.Compose.Tooling.preview)
    implementation(Deps.AndroidX.Compose.Tooling.ui)
    implementation(Deps.AndroidX.Compose.Tooling.ui)
    implementation(Deps.Koin.android)
}
