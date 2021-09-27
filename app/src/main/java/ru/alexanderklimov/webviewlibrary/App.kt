package ru.alexanderklimov.webviewlibrary

import android.app.Application
import ru.alexanderklimov.library.PaymentService

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PaymentService.initialize(applicationContext)
    }
}