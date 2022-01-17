package com.example.pyide

import android.content.Intent
import android.icu.util.Output
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.chaquo.python.Python

class code : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)

       val codeout = findViewById<TextView>(R.id.codeout)


        val codeoutput = intent.getStringExtra("codeoutput")
        codeout.text = codeoutput


    }
}
