pluginManagement {
    repositories {
        google() // Репозиторий Google для Android плагинов
        mavenCentral() // Репозиторий Maven Central
        gradlePluginPortal() // Репозиторий плагинов Gradle
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google() // Репозиторий Google
        mavenCentral() // Репозиторий Maven Central
    }
}

rootProject.name = "MyApplication" // Убедитесь, что имя проекта соответствует
include(":app") // Включите модуль приложения
