package com.drawiin.funfit.buildSrc

object Versions {
    const val androidxCore=  "1.7.0"
    const val appCompat =  "1.3.1"
    const val material =  "1.4.0"

    const val platformFirebaseBom =  "28.4.1"

    const val viewModelCompose =  "2.4.0-rc01"
    const val navCompose =  "2.4.0-alpha10"

    const val lifecycleRuntime =  "2.3.1"
    const val activityCompose =  "1.3.1"
    const val compose = "1.0.5"

    const val gradle = "7.0.2"
    const val kotlinVersion = "1.5.31"
    const val googleServices = "4.3.10"

    const val coroutinesCore = "1.5.0"
    const val hilt = "2.40.1"
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
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}

object Libs {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"

    const val hilt  = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    const val platformFirebaseBom =  "com.google.firebase:firebase-bom:${Versions.platformFirebaseBom}"
    const val firebaseDatabase =  "com.google.firebase:firebase-database-ktx"
    const val firebaseAuth =  "com.google.firebase:firebase-auth-ktx"

    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"

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
