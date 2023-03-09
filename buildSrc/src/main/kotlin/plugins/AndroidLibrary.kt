package plugins

import Versions
import android
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidLibrary : Plugin<Project> {

    override fun apply(project: Project) = project.androidLibrary()

    private fun Project.androidLibrary() {
        plugins.run {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")
        }

        android {
            compileSdk = Versions.Android.compileSdk

            defaultConfig {
                minSdk = Versions.Android.minSdk
                targetSdk = Versions.Android.targetSdk
                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                release {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }

        tasks.withType<KotlinCompile>()
            .configureEach {
                kotlinOptions {
                    freeCompilerArgs = freeCompilerArgs + listOf(
                        "-opt-in=kotlin.RequiresOptIn",
                        "-Xcontext-receivers",
                    )
                }
            }
    }
}
