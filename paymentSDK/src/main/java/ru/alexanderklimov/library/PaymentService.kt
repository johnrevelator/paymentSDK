package ru.alexanderklimov.library

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.webkit.URLUtil
import java.net.URL

object PaymentService {

    internal const val CURRENT_URL = "CURRENT_URL"
    private const val URL_KEY = "webSBPayLink"
    private const val HOST_URL = "web.sbpay.ru"
    private lateinit var applicationContext: Context

    var defaultBrowser: Boolean = false

    fun initialize(context: Context) {
        applicationContext = context
    }

    fun openPayment(payload: Map<String, Any>) {
        val url = payload[URL_KEY] as? String
        url?.let { openPayment(it) }
            ?: throw InvalidateUserInfoError(applicationContext.getString(R.string.incorrect_user_data))
    }

    fun openPayment(url: String) {
        validateUrl(url)

        if (defaultBrowser)
            navigateToBrowser(url)
        else
            navigateToWebView(url)
    }

    private fun validateUrl(url: String) {
        if (!URLUtil.isValidUrl(url) || URL(url).host != HOST_URL)
            throw InvalidateURLError(applicationContext.getString(R.string.incorrect_url))
    }

    private fun navigateToWebView(url: String) {
        applicationContext.startActivity(
            Intent(applicationContext, PaymentActivity::class.java).putExtra(
                CURRENT_URL,
                url
            ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }

    private fun navigateToBrowser(url: String) {
        applicationContext.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
            ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }
}