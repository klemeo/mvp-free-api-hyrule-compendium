plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "ru.android.hyrulecompendiummvp"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.android.hyrulecompendiummvp"
        minSdk = 26
        targetSdk = 35
        versionCode = 2
        versionName = "1.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isDebuggable = true
            applicationIdSuffix = ".dev"
        }
        release {
            isMinifyEnabled = false
            isDebuggable = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.kotlin.stdlib)
    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)

    implementation(libs.koin.android)
    implementation(libs.koin.core)

    implementation(libs.rxjava)
    implementation(libs.rxandroid)

    implementation(libs.library)

    implementation(libs.glide)
    implementation(libs.okhttp3.integration)
    implementation(libs.glide.transformations)
    ksp(libs.ksp)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.adapter.rxjava2)
    implementation(libs.okhttpprofiler)

    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)

}