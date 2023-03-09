package plugins

import Deps
import android
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidCompose : Plugin<Project> {

    override fun apply(project: Project) = project.androidCompose()

    private fun Project.androidCompose() {
        plugins.run {
            apply("androidLibrary")
        }

        android {
            defaultConfig {
                vectorDrawables.useSupportLibrary = true
            }
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = Deps.AndroidX.Compose.compilerVersion
            }
        }
    }
}
