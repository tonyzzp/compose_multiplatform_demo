plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
}

group "me.izzp"
version "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.5.0")
    implementation("com.google.accompanist:accompanist-insets:0.24.13-rc")
    implementation("com.google.accompanist:accompanist-insets-ui:0.24.13-rc")
}

android {
    compileSdkVersion(33)
    defaultConfig {
        applicationId = "me.izzp.compose_demo"
        minSdkVersion(24)
        targetSdkVersion(33)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}