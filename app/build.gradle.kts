import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.saniou.santieba"
        minSdkVersion(21)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
// To inline the bytecode built with JVM target 1.8 into
// bytecode that is being built with JVM target 1.6. (e.g. navArgs)
}


dependencies {
    val media2Version = "1.0.3"
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.2")

    implementation("androidx.navigation:navigation-fragment-ktx:2.3.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.3.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("com.google.android:flexbox:2.0.1")
    implementation("androidx.core:core-ktx:1.3.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${KotlinCompilerVersion.VERSION}")
    implementation("org.apache.commons:commons-text:1.8")
    // Interacting with MediaSessions
    implementation("androidx.media2:media2-session:$media2Version")
    // optional - UI widgets for VideoView and MediaControlView
    implementation("androidx.media2:media2-widget:$media2Version")
    implementation("androidx.media2:media2-player:$media2Version")

    implementation("org.litepal.android:java:3.0.0")

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation(project(mapOf("path" to ":support")))

}
