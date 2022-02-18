dependencies {

    // Core
    implementation(Dependencies.Android.core)

    // Lifecycle
    implementation(Dependencies.AndroidLifecycle.runtime)

    // Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Compose.activity)
    debugImplementation(Dependencies.Compose.uiTooling)
    androidTestImplementation(Dependencies.Compose.uiTest)

    // Testing
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidJUnit)
    androidTestImplementation(Dependencies.Test.espressoCore)
}
