// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    val kotlinVersion = "1.4.0"
    val kotlinCoroutines = "1.3.9"
    val navVersion = "2.3.0-alpha01"
    repositories {
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
        maven("https://dl.bintray.com/saniou/maven")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        // todo wait for fix
        //  classpath "com.novoda:bintray-release:0.9.2"

        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
        classpath("name.remal:gradle-plugins:1.0.211")
        // ./gradlew checkDependencyUpdates
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