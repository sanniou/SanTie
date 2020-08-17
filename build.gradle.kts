// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlin_version = "1.3.72"
    val kotlin_coroutines = "1.3.5"
    repositories {
        google()
        jcenter()
        maven("https://dl.bintray.com/saniou/maven")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        // todo wait for fix
        //  classpath "com.novoda:bintray-release:0.9.2"
        val nav_version = "2.3.0-alpha01"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")

    }

}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://dl.bintray.com/saniou/maven")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}