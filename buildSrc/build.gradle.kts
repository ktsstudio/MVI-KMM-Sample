plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
}

gradlePlugin {
    plugins {
        create("AndroidLibrary") {
            id = "androidLibrary"
            implementationClass = "plugins.AndroidLibrary"
        }
        create("AndroidCompose") {
            id = "androidCompose"
            implementationClass = "plugins.AndroidCompose"
        }
        create("AndroidFeature") {
            id = "androidFeature"
            implementationClass = "plugins.AndroidFeature"
        }
    }
}

kotlin {
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}
