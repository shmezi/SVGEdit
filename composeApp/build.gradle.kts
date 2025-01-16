import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
   alias(libs.plugins.kotlinMultiplatform)
   alias(libs.plugins.composeMultiplatform)
   alias(libs.plugins.composeCompiler)
}

kotlin {
   jvm("desktop")

   @OptIn(ExperimentalWasmDsl::class)
   wasmJs {
      moduleName = "composeApp"
      browser {
         val rootDirPath = project.rootDir.path
         val projectDirPath = project.projectDir.path
         commonWebpackConfig {
            outputFileName = "composeApp.js"
            devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
               static = (static ?: mutableListOf()).apply {
                  // Serve sources to debug inside browser
                  add(rootDirPath)
                  add(projectDirPath)
               }
            }
         }
      }
      binaries.executable()
   }

   sourceSets {
      val desktopMain by getting

      commonMain.dependencies {
         implementation(compose.runtime)
// https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib
         implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.0")
         implementation ("androidx.graphics:graphics-shapes:1.0.1")

//         implementation(libs.gestures)
         implementation(compose.foundation)
         implementation(compose.ui)

         implementation(compose.material3)
         implementation(compose.material3AdaptiveNavigationSuite)
         implementation(compose.ui)
         implementation(compose.components.resources)
         implementation(compose.components.uiToolingPreview)
         implementation(libs.androidx.lifecycle.viewmodel)
         implementation(libs.androidx.lifecycle.runtime.compose)

      }
      desktopMain.dependencies {
         implementation(compose.desktop.currentOs)
         implementation(libs.kotlinx.coroutines.swing)
      }
   }
}


compose.desktop {
   application {
      mainClass = "lol.ezra.svgedit.MainKt"

      nativeDistributions {
         targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
         packageName = "lol.ezra.svgedit"
         packageVersion = "1.0.0"
      }
   }
}
