# Weather-App-With-Compose

In this repository I made Weather app with using `Jetpack Compose`. Data is fetching from Internet. You can look in [here][1].

Libraries Used
--------------
* [Architecture][10] - Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
  * [Navigation][14] - Handle everything needed for in-app navigation.
  * [Repository][18] - Repository modules handle data operations.
  * [ViewModel][17] - Easily schedule asynchronous tasks for optimal execution.
* [UI][30] - Details on why and how to use UI Components in your apps - together or separate
  * [Jetpack Compose][34] - A basic unit of composable UI.
* Third party and miscellaneous libraries
  * [Retrofit][90] for turns your HTTP API into a Java interface
  * [Gson][91] for convert Java Objects into their JSON representation
  * [Coil][92] for image loading
  * [Dagger-Hilt][93] Hilt is the recommended solution for dependency injection in Android apps, and works seamlessly with Compose.
  
  
  
App GIF
--------------
<p align="center">
  <img src="https://user-images.githubusercontent.com/58858983/133434113-a4cce83f-a532-4666-be18-953a9002ab43.gif" alt="GIF" />
</p>


[1]: https://openweathermap.org/api
[10]: https://developer.android.com/jetpack/compose/architecture
[12]: https://developer.android.com/jetpack/compose/lifecycle
[14]: https://developer.android.com/jetpack/compose/navigation
[17]: https://developer.android.com/jetpack/compose/state#viewmodel-state
[18]: https://developer.android.com/jetpack/guide#fetch-data
[30]: https://developer.android.com/jetpack/compose/tutorial
[34]: https://developer.android.com/jetpack/compose
[90]: https://square.github.io/retrofit/
[91]: https://github.com/google/gson
[92]: https://coil-kt.github.io/coil/compose/
[93]: https://developer.android.com/jetpack/compose/libraries#hilt
