object Dependencies {
    private val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}"


    val composeBom="androidx.compose:compose-bom:${Versions.composeBom}"
    private val activityCompose="androidx.activity:activity-compose:${Versions.activityCompose}"
    private val composeUi="androidx.compose.ui:ui"
    private val composeUiGraphics="androidx.compose.ui:ui-graphics"
    private val composeUiToolingPreview="androidx.compose.ui:ui-tooling-preview"
    private val composeMeterial3="androidx.compose.material3:material3"
    val composeUiJunitTest="androidx.compose.ui:ui-test-junit4"
    val composeUiToolingTest="androidx.compose.ui:ui-tooling"
    val composeUiTestManifest="androidx.compose.ui:ui-test-manifest"

    val junit="junit:junit:${Versions.junit}"
     val junitExt="androidx.test.ext:junit:${Versions.junitAndroid}"
     val espressoCore="androidx.test.espresso:espresso-core:${Versions.espressoCore}"


    val kolinBom="org.jetbrains.kotlin:kotlin-bom:${Versions.kolinBom}"

    private val navigationFragmentKtx="androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private val navigationUiKtx="androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    private val navigationFragment="androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"
    private val navigationCompose="androidx.navigation:navigation-compose:${Versions.navigation}"
    val navigationTest="androidx.navigation:navigation-testing:${Versions.navigation}"

    private val koinAndroid= "io.insert-koin:koin-android:${Versions.koin}"
    private val koinCompose="io.insert-koin:koin-androidx-compose:${Versions.koin}"

    val appBaseLibraries = listOf(
        coreKtx,
        lifecycleRuntimeKtx
    )

    val composeLibraries= listOf(
        activityCompose,
        composeUi,
        composeUiGraphics,
        composeUiToolingPreview,
        composeMeterial3
    )

    val navigationLibraries= listOf(
        navigationFragmentKtx,
        navigationUiKtx,
        navigationFragment,
        navigationCompose
    )

    val koinLibraries= listOf(
        koinAndroid,
        koinCompose
    )
}