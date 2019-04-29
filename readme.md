# GetAway

## Concept

The concept of this app is to make it easier to explore, by giving the user ability to point on a map and have the nearest airport with an price estimate showing up.

## Architecture

### Fragment structure / Navigation graph

The app screens is made using only Fragments utilizing the Navigation Component for handling the navigation between screens. Most of the Fragments also utilizes DataBinding.

Navigation Component is mainly used to not have to use FragmentTransactions which is very error-prone, and it gives an easy way to define screens and the transactions between each of the screens. It also provides a type-safe way of accepting arguments when transitioning. 

![Navigation graph](puml/nav_graph.png)

### Custom Widget

The widget showing the chosen airport and for searching for airports, is a custom View. Which encapsulates the behaviour of enabling and disabling the EditText, and the fact that if you start searching the labels for IATA code and city name is hidden and visible. 

## Dependencies

The application is made utilizing most of the latest best practises provided in [Android Architecture Components](https://developer.android.com/topic/libraries/architecture). The app is also using additional third-party libraries.

### Architecture Components

The architecture components used is [Room](https://developer.android.com/topic/libraries/architecture/room), [Navigation Component](https://developer.android.com/guide/navigation), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [DataBinding](https://developer.android.com/topic/libraries/data-binding), and [ViewModels](https://developer.android.com/topic/libraries/architecture/viewmodel).

#### Room

Room is a persistence library made by Google as a part of it's Architecture components, and provides a abstraction layer on top of SQLite which is the Database driver that comes with android.

In this project I use it to store the data about the different airports, this is mainly to keep the app from having to keep all of that information in memory when running the app.

#### Navigation component

Navigation component gives an much better developer experience compared to handing FragmentTransitions and Intents manually. It allows you to define a navigation graph, and the possible transitions between different activities or fragments. It also gives a type-safe way to send arguments between fragments or activities.

#### LiveData

LiveData gives some of the same benefits as other reactive streaming libraries (ie. RxJava), with the advantage of being lifecycle-aware. This means that a LiveData object will only call your observer callback when the associated lifecycle-owner(activity or fragment) is active.

#### DataBinding

DataBinding allows you to offset some of the work associated with updating values displayed or passed to a View, and together with LiveData can allow you to not have to reference any views in your code.

There is also the possibility of two-way data binding, this allows you to interface with a data object instead of interfacing with the view. This allows for very clean and decoupled code.

![Two-way data binding](puml/two_way_databinding.png)

#### ViewModels

ViewModels does not do much in itself, but the concept is that it holds the data in the application. And the main reason to use it, is that it will survive across lifecycle changes such as when the phone rotates. And the ViewModels can be shared across fragments, so it could store common information needed throughout the application.

### Third-party libraries

In modern programming you will rarely not use any third-party libraries, and Android development is no exception. In this project I might be using more advanced libraries than necessary for an app of this scope. However of the libraries most enables certain features not present in any utilities provided by Google.

In this project I'm using [RxKotlin](https://github.com/ReactiveX/RxKotlin), [RxRecyclerAdapted](https://github.com/ahmedrizwan/RxRecyclerAdapter), [Insert-Koin](https://insert-koin.io/), [Gson](https://github.com/google/gson), [Picasso](http://square.github.io/picasso/), [Retrofit](https://square.github.io/retrofit/), and [Anko](https://github.com/Kotlin/anko).

#### RxJava/RxKotlin

RxKotlin is just a wrapper library around RxJava, which adds some of the kotlin specific features to the library. RxJava is a library which makes asynchronous programming easier by building it on observable streams.

I use this library just to ease the handling of asynchronous observable data that doesn't play nice with the constraint of being bound to a lifecycle-owner found in LiveData. In addition to RxJava/RxKotlin being industry-standard when developing Android apps.

#### RxRecyclerAdapter

RxRecyclerAdapter is again a fairly simple library, it uses RxKotlin and DataBinding to make the creation of a RecyclerViewAdapter and ViewHolder much easier. And since it's based on RxKotlin everything is asynchronous and observer-driven.

#### Insert-Koin 

Insert-Koin is a dependency-injection library made for Kotlin, it manages dependencies across modules as every other dependency-injection library. This is usually not used in so small and simple apps, but I really like the way it takes care of ViewModels by injecting it into Fragments that needs them.

#### Anko

Anko is a small utility library for developing android apps in Kotlin, and is made by the creators of Kotlin, JetBrains. In this app I'm only using it to run code off the main thread by using `doAsync { /* code */ }`.

## Screenshots

### Start screen

![Start screen]()

<div class="page-break"></div>