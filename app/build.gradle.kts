plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.kayevo.antifraudapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kayevo.antifraudapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
        viewBinding = true
        android.buildFeatures.buildConfig = true
    }
}

dependencies {
    val material_design_version = "1.7.0"
    val coroutines_version = "1.6.4"
    val lifecycle_version = "2.5.1"
    val android_arch_version = "2.1.0"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Material design
    implementation( "com.google.android.material:material:$material_design_version")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    // Testing coroutines
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_version")

    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    // Test helpers for LiveData
    testImplementation ("androidx.arch.core:core-testing:$android_arch_version")
    // Test helpers for Lifecycle runtime
    testImplementation ("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")
}