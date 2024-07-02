package com.example.card_legends

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

const val DEBUG = true


@HiltAndroidApp
class CardLegendsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if (DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
