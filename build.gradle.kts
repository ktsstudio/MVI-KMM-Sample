buildscript {

    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }

    dependencies {
        classpath(Deps.Kotlin.gradlePlugin)
        classpath(Deps.Android.gradlePlugin)
        classpath(Deps.KmmResources.gradlePlugin)
        classpath(Deps.KmmImages.gradlePlugin)
    }
}

allprojects {

    repositories {
        mavenCentral()
        google()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
