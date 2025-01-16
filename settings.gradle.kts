rootProject.name = "SVGEdit"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
   repositories {
      google {
         mavenContent {
            includeGroupAndSubgroups("androidx")
            includeGroupAndSubgroups("com.android")
            includeGroupAndSubgroups("com.google")
         }
      }
      mavenCentral()
      gradlePluginPortal()
   }
}

dependencyResolutionManagement {
   repositories {
      google {
         mavenContent {
            includeGroupAndSubgroups("androidx")
            includeGroupAndSubgroups("com.android")
            includeGroupAndSubgroups("com.google")
         }
      }
      maven("https://jitpack.io")

      mavenCentral()
   }
}

include(":composeApp")