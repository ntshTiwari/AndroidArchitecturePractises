package com.example.androidarchitecturepractises

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/// NOTE: In case of creation the Activity's lifecycle methods are called first, eg: onCreate, onPause
/// In case of destroying or pausing, the Observer's lifecycle methods are called first, eg: onDestroy, onStop

class Observer: LifecycleObserver {

    /// with this annotation we tell Android to call this methods when
    /// the create method of the Activity which we are observing to is called
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.e("OBSERVER:", "onCreate called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.e("OBSERVER:", "onPause called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.e("OBSERVER:", "onDestroy called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.e("OBSERVER:", "onStop called")
    }
}