import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("multiplatform") version "1.8.0"
    id("org.jetbrains.compose") version "1.3.0"
}

group = "com.andrewtg"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    jvm {
        jvmToolchain(19)
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("com.sksamuel.scrimage:scrimage-core:4.0.33")
                implementation("com.sksamuel.scrimage:scrimage-formats-extra:4.0.33")
                implementation("com.sksamuel.scrimage:scrimage-webp:4.0.33")
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Msi)
            packageName = "ImageConverterKotlin"
            packageVersion = "1.0.0"
        }
    }
}
