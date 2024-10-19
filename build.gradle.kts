// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.51") // Adding Hilt plugin
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    id("com.android.library") version "7.3.1" apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

// Using the 'extra' object for shared properties
extra["compose_ui_version"] = "1.5.1"
