pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Vacancy search"
include(":app")
include(":core")
include(":core:theme")
include(":core:uiCommon")
include(":core:navigation")
include(":core:base:api")
include(":core:base:impl")
include(":feature")
include(":feature:auth")
include(":feature:auth:api")
include(":feature:auth:impl")
include(":feature:mainactivity")
include(":feature:mainactivity:api")
include(":feature:mainactivity:impl")
include(":feature:search")
include(":feature:search:api")
include(":feature:search:impl")
include(":feature:favourite")
include(":feature:favourite:api")
include(":feature:favourite:impl")
include(":feature:responses")
include(":feature:responses:api")
include(":feature:responses:impl")
include(":feature:mainscreen")
include(":feature:mainscreen:api")
include(":feature:mainscreen:impl")
