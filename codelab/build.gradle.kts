plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}
android {
    namespace = "com.example.android.codelab.animation"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.example.android.codelab.animation"
        minSdk = 24
        targetSdk = 35
    }
    buildFeatures { compose = true }
}
dependencies {
    implementation(platform("androidx.compose:compose-bom:2024.10.01"))
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation("androidx.compose.material3:material3:1.3.1")
    implementation("androidx.compose.animation:animation:1.7.5")
    implementation("androidx.compose.ui:ui-tooling-preview")
}
