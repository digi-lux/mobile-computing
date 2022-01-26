package com.codemave.mobilecomputing

import android.app.Application

/**
 * This application class sets up our dependency [Graph] with a context
 */
class MobileComputingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}