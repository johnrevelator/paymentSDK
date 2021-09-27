package ru.alexanderklimov.webviewlibrary

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.alexanderklimov.library.PaymentSDK

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigate.setOnClickListener {
            openSdk()
        }
        browserCheckBox.setOnCheckedChangeListener { _, isChecked ->
            PaymentSDK.defaultBrowser = isChecked
        }
    }

    private fun openSdk() {
        try {
            PaymentSDK.openPayment(urlEditText.text.toString())
        } catch (t: Throwable) {
            Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
        }
    }
}