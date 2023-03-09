@file:Suppress("Filename")

import java.io.File
import org.gradle.api.Project

object Build {
    fun getVersionName(project: Project): String {
        return "1.0.${gitCommitCount(project)}"
    }

    fun getVersionCode(project: Project): Int = gitCommitCount(project)

    private fun gitCommitCount(project: Project): Int {
        return ("git rev-list --count HEAD".execute(project.rootDir, "1").toInt())
    }
}

private fun String?.letIfEmpty(fallback: String): String {
    return if (this == null || isEmpty()) {
        fallback
    } else {
        this
    }
}

private fun String?.execute(workingDir: File, fallback: String): String {
    Runtime.getRuntime().exec(this, null, workingDir).let {
        it.waitFor()
        return try {
            it.inputStream.reader().readText().trim().letIfEmpty(fallback)
        } catch (e: Exception) {
            fallback
        }
    }
}
