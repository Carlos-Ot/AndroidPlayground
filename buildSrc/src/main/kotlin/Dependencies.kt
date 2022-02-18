import Versions.AndroidJetpack
import Versions.DI
import Versions.Testing
import Versions.coroutines
import Versions.kotlinVersion
import kotlin.reflect.full.memberProperties

object Dependencies {

    object Module {
        const val core_domain = ":core-domain"
        const val core_local_storage = ":core-local-storage"
        const val core_data = ":core-data"
        const val shared = ":shared"
        const val feature_restaurant = ":feature-restaurant"
    }

    val modules: List<String> by lazy {
        Module::class.memberProperties.map {
            it.name.replace("_", "-")
        }
    }

    object Kotlin {
        const val core = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        const val coreJDK7 =
            "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
    }

    object Coroutines {
        const val core =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines"
        const val android =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines"
        const val testing =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines"
    }

    object Koin {
        const val core = "io.insert-koin:koin-core:${DI.koin}"
        const val android = "io.insert-koin:koin-android:${DI.koin}"
        const val androidViewModel = "io.insert-koin:koin-android-viewmodel:${DI.koin}"
        const val test = "io.insert-koin:koin-test-junit4:${DI.koin}"
    }

    object AndroidUI {
        const val appCompat = "androidx.appcompat:appcompat:${AndroidJetpack.appcompat}"
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${AndroidJetpack.constraintLayout}"
        const val material =
            "com.google.android.material:material:${AndroidJetpack.material}"
        const val fragment =
            "androidx.fragment:fragment-ktx:${Versions.AndroidKTX.fragment}"
        const val recyclerView =
            "androidx.recyclerview:recyclerview:${AndroidJetpack.recyclerView}"
        const val cardView = "androidx.cardview:cardview:${AndroidJetpack.cardView}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${AndroidJetpack.compose}"
        const val material = "androidx.compose.material:material:${AndroidJetpack.compose}"
        const val uiToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${AndroidJetpack.compose}"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:${AndroidJetpack.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${AndroidJetpack.compose}"
        const val activity = "androidx.activity:activity-compose:${AndroidJetpack.activityCompose}"
    }

    object Navigation {
        const val fragment =
            "androidx.navigation:navigation-fragment-ktx:${AndroidJetpack.navigation}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${AndroidJetpack.navigation}"
        const val testing = "androidx.navigation:navigation-testing:${AndroidJetpack.navigation}"
    }

    object Android {
        const val core = "androidx.core:core-ktx:${Versions.AndroidKTX.core}"
        const val annotation =
            "androidx.annotation:annotation:${AndroidJetpack.annotation}"

        operator fun invoke() = arrayOf(core, annotation)
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${AndroidJetpack.room}"
        const val ktx = "androidx.room:room-ktx:${AndroidJetpack.room}"
        const val compiler = "androidx.room:room-compiler:${AndroidJetpack.room}"
        const val testing = "androidx.room:room-testing:${AndroidJetpack.room}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
        const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
        const val adapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"

        operator fun invoke() = arrayOf(moshi, codeGen, adapters)
    }

    object AndroidLifecycle {
        const val livedata =
            "androidx.lifecycle:lifecycle-livedata-ktx:${AndroidJetpack.lifecycle}"
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${AndroidJetpack.lifecycle}"
        const val compiler =
            "androidx.lifecycle:lifecycle-compiler:${AndroidJetpack.lifecycle}"
        const val testing = "androidx.arch.core:core-testing:${AndroidJetpack.arch_core}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${AndroidJetpack.lifecycle}"
    }

    object Lint {
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val ktLint = "org.jlleitschuh.gradle.ktlint"
    }

    object Test {

        // Unit Testing
        const val jUnit = "junit:junit:${Testing.junit}"
        const val archCore =
            "androidx.arch.core:core-testing:${AndroidJetpack.arch_core}"
        const val kotlinJUnit =
            "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion"
        const val mockk = "io.mockk:mockk:${Testing.mockk}"
        const val truth = "com.google.truth:truth:${Testing.truth}"

        // Android Testing
        const val androidTestCore = "androidx.test:core:${Testing.androidTestCore}"
        const val androidJUnit =
            "androidx.test.ext:junit-ktx:${Testing.androidTestJUnit}"
        const val testRunner = "androidx.test:runner:${Testing.androidTestCore}"
        const val testRules = "androidx.test:rules:${Testing.androidTestCore}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Testing.espresso}"

        operator fun invoke(type: Type) = when (type) {
            Type.UNIT -> arrayOf(jUnit, archCore, kotlinJUnit, mockk, truth)
            Type.ANDROID -> arrayOf(
                androidTestCore,
                archCore,
                androidJUnit,
                testRunner,
                testRules,
                truth
            )
        }

        enum class Type {
            UNIT,
            ANDROID
        }
    }
}
