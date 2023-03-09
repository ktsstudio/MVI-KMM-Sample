plugins {
    id("multiplatform-common-setup")
}

kotlin {

    sourceSets {
        commonMain {
            apis(
                project(":shared:common"),
            )
        }
    }
}
