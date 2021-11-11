package com.drawiin.funfit.buildSrc

object Versions {
    const val androidxCore=  "1.6.0"
    const val appCompat =  "1.3.1"
    const val material =  "1.4.0"

    const val platformFirebaseBom =  "28.4.1"

    const val viewModelCompose =  "2.4.0-rc01"
    const val navCompose =  "2.4.0-alpha10"

    const val lifecycleRuntime =  "2.3.1"
    const val activityCompose =  "1.3.1"
    const val compose = "1.0.1"

    const val gradle = "7.0.2"
    const val kotlinGradlePlugin = "1.5.21"
    const val googleServices = "4.3.10"
}

object Configs {
    const val applicationId =  "com.drawiin.funfit"
    const val minSdk =  23
    const val targetSdk =  31
    const val versionCode =  1
    const val versionName =  "1.0"
}

object Classpath {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"
}

object Libs {
    const val platformFirebaseBom =  "com.google.firebase:firebase-bom:${Versions.platformFirebaseBom}"
    const val firebaseDatabase =  "com.google.firebase:firebase-database-ktx"


    const val androidxCore =  "androidx.core:core-ktx:${Versions.androidxCore}"
    const val appCompat =  "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material =  "com.google.android.material:material:${Versions.material}"

    const val composeUi=  "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial =  "androidx.compose.material:material:${Versions.compose}"
    const val composePreview =  "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"

    const val viewModelCompose =  "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.viewModelCompose}"
    const val navCompose =  "androidx.navigation:navigation-compose:${Versions.navCompose}"


    const val lifecycleRuntime =  "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
    const val activityCompose =  "androidx.activity:activity-compose:${Versions.activityCompose}"
}

object TestLibs {
    const val junit = "junit:junit:4.+"
}

object AndroidTestLibs {
    const val junit = "androidx.test.ext:junit:1.1.3"
    const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    const val composeUiTest = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
}

object DebugLibs {
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
}
