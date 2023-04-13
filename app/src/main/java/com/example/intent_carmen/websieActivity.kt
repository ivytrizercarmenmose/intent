package com.example.intent_carmen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class websieActivity : AppCompatActivity() {

    private lateinit var myweb:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_websie)

        myweb=findViewById(R.id.mWeb)

        val webSettings = myweb.settings
        webSettings.javaScriptEnabled = true
        myweb.loadUrl("https://google.com")
    }
}