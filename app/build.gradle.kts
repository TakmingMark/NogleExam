import BuildExtensions.implementationList

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.marker.nogle_exam"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.marker.nogle_exam"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }


    }

    buildTypes {
        release {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packaging {
        resources {
            excludes += "META-INF/*"
        }
    }
}

dependencies {
    implementation("com.google.firebase:firebase-appdistribution-gradle:3.0.1")
    implementation(platform(Dependencies.kolinBom))
    implementation(platform(Dependencies.composeBom))

    implementationList(Dependencies.appBaseLibraries)
    implementationList(Dependencies.composeLibraries)
    implementationList(Dependencies.navigationLibraries)
    implementationList(Dependencies.koinLibraries)
    implementationList(Dependencies.retrofitLibraries)

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitExt)
    androidTestImplementation(Dependencies.espressoCore)
    androidTestImplementation(platform(Dependencies.composeBom))
    androidTestImplementation(Dependencies.composeUiJunitTest)
    androidTestImplementation(Dependencies.navigationTest)
    debugImplementation(Dependencies.composeUiToolingTest)
    debugImplementation(Dependencies.composeUiTestManifest)
}