import Versions.AndroidJetpack

object Config {

    const val applicationId = "com.ottoboni.androidplayground"
    const val compileSdk = 31
    const val minSdkVersion = 26
    const val targetSdkVersion = 31
    const val buildTools = "30.0.3"
    const val versionCode = 1
    const val versionName = "1.0.0"

    object AndroidClassPath {
        const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
        const val kotlinPlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        const val navigation =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${AndroidJetpack.navigation}"
    }

    object AndroidTestRunner {
        const val instrumentationTestRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
