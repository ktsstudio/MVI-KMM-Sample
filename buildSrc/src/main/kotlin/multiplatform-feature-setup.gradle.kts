plugins {
    id("multiplatform-setup")
}

kotlin {

    sourceSets {

        val otherFeatureProjects = when (project.isApiModule) {
            true -> null
            else -> project.parent?.childProjects?.values?.filter { it.isApiModule }
        }

        commonMain {
            implementations(
                project(":shared:core-domain"),
                project(":shared:core-network"),
                project(":shared:core-presentation"),
                *otherFeatureProjects?.toTypedArray().orEmpty(),
            )
        }
    }
}
