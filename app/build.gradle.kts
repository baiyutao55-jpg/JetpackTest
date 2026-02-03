plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.jetpacktest"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.jetpacktest"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(platform("androidx.room:room-runtime:2.1.0"))
    implementation("androidx.room:room-runtime")

    implementation(platform("androidx.work:work-runtime:2.2.0"))
    implementation("androidx.work:work-runtime")


    implementation(platform("androidx.room:room-compiler:2.1.0"))
    implementation("androidx.room:room-compiler")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}