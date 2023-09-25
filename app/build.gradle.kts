plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Moshi Kotlin Codegen
    id("com.google.devtools.ksp")
    // Kotlin Parcelize - Parcelable Data Class
    id("kotlin-parcelize")
}

android {
    namespace = "com.pall.pallpedia"
    compileSdkPreview = "UpsideDownCake"

    defaultConfig {
        applicationId = "com.pall.pallpedia"
        minSdk = 33
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Splash Screen Android 12
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Picasso - Image loader
    // Image downloader that allow developer break the pain cycle to display imagers
    implementation("com.squareup.picasso:picasso:2.8")

    // Moshi
    // JSON converter - serialize and deserialize object to and from JSON
    // 1 of libraries JSON converters for data serialization
    implementation("com.squareup.moshi:moshi:1.14.0")

    // kotlin Codegen
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

    // Retrofit - Request HTTP/HTTPS client
    // HTTP client - Retrofit with OkHTTP
    // to retrieve and upload JSON (or other structured data) via a REST based webservice
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
}