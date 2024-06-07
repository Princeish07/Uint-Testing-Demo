plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.registerapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.registerapplication"
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
    buildFeatures{
        viewBinding=true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    testImplementation("junit:junit:4.13.2")
    testImplementation ("com.google.truth:truth:1.4.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("com.google.truth:truth:1.4.2")
    androidTestImplementation ("androidx.arch.core:core-testing:2.1.0")

    testImplementation ("androidx.arch.core:core-testing:2.1.0")
    val lifecycle_version = "2.2.0"
    implementation ("androidx.lifecycle:lifecycle-extensions:$lifecycle_version")


    val fragment_version = "1.3.2"

    // Java language implementation
    implementation ("androidx.fragment:fragment:$fragment_version")
    // Kotlin
    implementation ("androidx.fragment:fragment-ktx:$fragment_version")
    // Testing Fragments in Isolation
    debugImplementation ("androidx.fragment:fragment-testing:$fragment_version")
    debugImplementation ("androidx.fragment:fragment-testing:1.7.1")
    androidTestImplementation("org.mockito:mockito-android:5.12.0")
    // ByteBuddy for Mockito
    testImplementation ("net.bytebuddy:byte-buddy:1.14.15")
    testImplementation ("net.bytebuddy:byte-buddy-agent:1.14.15")
    testImplementation ("org.mockito:mockito-inline:4.0.0")

}