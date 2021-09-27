package ru.alexanderklimov.library

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Message
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.webview_main.*
import ru.alexanderklimov.library.PaymentSDK.CURRENT_URL

class PaymentSDKActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_main)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.settings.setSupportMultipleWindows(true)
        supportActionBar?.hide()

        intent.extras?.getString(CURRENT_URL)?.let { loadWebView(it) }
    }

    private fun loadWebView(url: String) {

        webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                webView.visibility = View.VISIBLE
                progress.visibility = View.GONE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onCreateWindow(
                view: WebView,
                dialog: Boolean,
                userGesture: Boolean,
                resultMsg: Message
            ): Boolean {
                val result = view.hitTestResult
                val data = result.extra
                val context = view.context
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(data))
                context.startActivity(browserIntent)
                return false
            }
        }
        webView.loadUrl(url)
    }
}