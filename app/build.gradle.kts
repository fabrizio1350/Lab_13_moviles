plugins {
    id("com.android.application") version "9.3.3"
    id("org.jetbrains.kotlin.plugin.compose") version "2.2.10"
}
android {
    namespace = "com.example.lab13animaciones"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.example.lab13animaciones"
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
}