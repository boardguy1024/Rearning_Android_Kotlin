package com.example.parkkyungsuk.myownflashcard

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

var intBackgroundColor = 0

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonEdit.setOnClickListener {
            val intent = Intent(this@MainActivity, WordListActivity::class.java)
            startActivity(intent)
        }
        buttonColor1.setOnClickListener {
            intBackgroundColor = R.color.color1.toInt()
            constraintLayout.setBackgroundResource(intBackgroundColor)
        }
        buttonColor2.setOnClickListener {
            intBackgroundColor = R.color.color2.toInt()
            constraintLayout.setBackgroundResource(intBackgroundColor)
        }
        buttonColor3.setOnClickListener {
            intBackgroundColor = R.color.color3.toInt()
            constraintLayout.setBackgroundResource(intBackgroundColor)
        }
        buttonColor4.setOnClickListener {
            intBackgroundColor = R.color.color4.toInt()
            constraintLayout.setBackgroundResource(intBackgroundColor)
        }
        buttonColor5.setOnClickListener {
            intBackgroundColor = R.color.color5.toInt()
            constraintLayout.setBackgroundResource(intBackgroundColor)
        }
        buttonColor6.setOnClickListener {
            intBackgroundColor = R.color.color6.toInt()
            constraintLayout.setBackgroundResource(intBackgroundColor)
        }

    }
}
