package com.example.pyide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(this@splashscreen, MainActivity::class.java))
            finish()
        }, 2000)
    }
}