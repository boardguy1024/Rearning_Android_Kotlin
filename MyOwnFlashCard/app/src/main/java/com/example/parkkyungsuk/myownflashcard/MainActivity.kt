package com.example.parkkyungsuk.myownflashcard

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEdit.setOnClickListener {
            val intent = Intent(this@MainActivity, EditActivity::class.java)
            startActivity(intent)
        }
        buttonColor1.setOnClickListener {
            constraintLayout.setBackgroundResource(R.color.color1.toInt())
        }
        buttonColor2.setOnClickListener {
            constraintLayout.setBackgroundResource(R.color.color2.toInt())
        }
        buttonColor3.setOnClickListener {
            constraintLayout.setBackgroundResource(R.color.color3.toInt())
        }
        buttonColor4.setOnClickListener {
            constraintLayout.setBackgroundResource(R.color.color4.toInt())
        }
        buttonColor5.setOnClickListener {
            constraintLayout.setBackgroundResource(R.color.color5.toInt())
        }
        buttonColor6.setOnClickListener {
            constraintLayout.setBackgroundResource(R.color.color6.toInt())
        }

    }
}
