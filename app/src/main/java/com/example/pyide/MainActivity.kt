package com.example.pyide

import android.content.ContentValues.TAG
import android.content.Intent
import android.icu.util.Output
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val codeout = findViewById<TextView>(R.id.codeout)
         //val output = findViewById<TextView>(R.id.output)
       val  CodeArea = findViewById<EditText>(R.id.codearea)
       val Run = findViewById<ImageView>(R.id.run)

        if (!Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }


        Run.setOnClickListener {
            val intent = Intent(this, code::class.java)
            val py = Python.getInstance()
            val pyObject = py.getModule("pyscript")
            val obj = pyObject.callAttr("main", CodeArea.getText().toString())
            //output.setText(obj.toString());
            intent.putExtra("codeoutput",obj.toString())
            startActivity(intent)
        }



    }
}