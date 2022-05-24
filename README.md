### Technologies
[![Generic badge](https://img.shields.io/badge/Made%20with%20-%20Kotlin-purple.svg)](https://shields.io/)

[![Generic badge](https://img.shields.io/badge/Made%20with%20-%20Jetpack%20Compose-purple.svg)](https://shields.io/)


### Features

- Forecast
	- Current weather information
	- 5 days forecast
	- Astronomy information
- Timezones 
- Compass
- Settings

### Screens
<center>
<h5> Screen 1 - Current weather information</h5>
<img src="https://i.imgur.com/q3Z8J3Y.jpg" alt="drawing" width="300"/>
<h5>
 Screen 2 - Current weather information</h5>
<img src="https://imgur.com/jz7KB6j.jpg" alt="drawing" width="300"/>
<h5>
 Screen 3 - Current weather information</h5>
<img src="https://imgur.com/Q4it4rz.jpg" alt="drawing" width="300"/>
<h5>
 Screen 4 - Astronomy information</h5>
<img src="https://imgur.com/jF6MfnG.jpg" alt="drawing" width="300"/>
</center>


### Dependencies
```kotlin
    implementation 'androidx.core:core-ktx:1.6.0'
    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'com.google.android.material:material:1.4.0'
    implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.compose.material:material:$compose_version"
    implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.3.1'
    implementation 'androidx.activity:activity-compose:1.3.1'
    
    // Compose dependencies
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
    implementation "androidx.navigation:navigation-compose:2.4.0-alpha08"
    implementation "com.google.accompanist:accompanist-flowlayout:0.17.0"

    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1'

    // Coroutine Lifecycle Scopes
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"

    //Dagger - Hilt
    implementation "com.google.dagger:hilt-android:2.38.1"
    kapt "com.google.dagger:hilt-android-compiler:2.37"
    implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    kapt "androidx.hilt:hilt-compiler:1.0.0"
    implementation 'androidx.hilt:hilt-navigation-compose:1.0.0-alpha03'

    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation "com.squareup.okhttp3:okhttp:5.0.0-alpha.2"
    implementation "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2"

    //Location
    implementation 'com.google.android.gms:play-services-location:19.0.1'

    //Permissions
    implementation 'com.google.accompanist:accompanist-permissions:0.21.1-beta'
	
    //SystemUiController
    implementation "com.google.accompanist:accompanist-systemuicontroller:0.17.0"
	
    //Image from URL
    implementation("io.coil-kt:coil-compose:1.3.1")
	
    //Androidx splashscreen
    implementation"androidx.core:core-splashscreen:1.0.0-beta01"
	
    //SwipeRefresh
    implementation 'com.google.accompanist:accompanist-swiperefresh:0.24.4-alpha'
	
    // Paging Compose
    implementation "com.google.accompanist:accompanist-pager:0.13.0"
    implementation "com.google.accompanist:accompanist-pager-indicators:0.13.0"
```
