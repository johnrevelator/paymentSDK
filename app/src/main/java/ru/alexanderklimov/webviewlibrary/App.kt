package ru.alexanderklimov.webviewlibrary

import android.app.Application
import ru.alexanderklimov.library.PaymentSDK

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PaymentSDK.initialize(applicationContext)
    }
}