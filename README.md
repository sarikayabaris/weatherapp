# Weather App
5 days Forecast App using OpenWeatherMap 5 day weather forecast API. It’s an open API. 

The app structure is designed to be re-usable and component based, some parts has generic modules (such as caller, presenter, BaseActivity, etc), could be better and more but in 4 hours not possible to do that. Also app uses MVP pattern to make separate all views, presenters and models. it’s also easy to write unit tests for presenters. 

# Setup
 - First clone or download the repository
 - Open it in Android Studio
 - Make sure your emulator or device is connected
 - Make sure your device Android SDK level is min 19 (Android Kitkat)
 - Run the app on your selected device

# Better UX/UI
 - Now it has a horizontal clickable list with 3 hours forecast 
 - Each forecast clicks updates the top part of the screen
 - Would be nice to have high quality images for all weather types (rain, snow, clear, etc)
 - Animations while moving between days/hours
 - Allow user to refresh (swipe or clicking a button)

# Used technology
 - Android Studio as an IDE
 - RxJava / RxAndroid 
 - Retrofit 2.0
 - Butterknife
 - Glide
 - Gson
 - Recycleview and Cardview
 - Retrolambda

# Might implement with more time
 - Might use dependency injections, integrating a framework for it such as dagger or shank 
 - Might get user's location automatically and call API with latitude, longitude  
 - Write UI tests with Espresso framework
 - Unit tests on Presenters for test coverage 
 - More features like multiple city selection
 - Feature auto location detect from users phone and ask user to navigate to this city
 - Adding runtime permissions for Android 6.x+ devices
 - Http error handling and error mapping to show proper messages 
 - Optimized and cached http responses 
 - Push notifications for weather alerts (rain or snow, etc)
