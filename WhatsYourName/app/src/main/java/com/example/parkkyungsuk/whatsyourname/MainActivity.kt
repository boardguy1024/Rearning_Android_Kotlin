package com.example.parkkyungsuk.whatsyourname

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val textView: TextView = findViewById(R.id.textView)
//        val editText: EditText = findViewById(R.id.editText)
//        val button = findViewById<Button>(R.id.button)
//        val imageView = findViewById<ImageView>(R.id.imageView)


        // 下記の方法を使うには
        // View.OnClickListener Interface宣言し、 fun onClick(p0: View?) を overrideすべき
        //As swift : button.onClickDelegate = self
       // button.setOnClickListener(this)

        // Swiftのくろーじゃーっぽいやつ
        //これだけで実行できる
        button.setOnClickListener {
            textView.text = "こんにちは " + editText.text.toString() + "さん"
            imageView.setImageResource(R.drawable.hello)
        }
    }

//    // As Swift : Action buttonTapped { sender in   }
//    override fun onClick(p0: View?) {
//
//        textView.text = "こんにちは " + editText.text.toString() + "さん"
//        imageView.setImageResource(R.drawable.hello)
//
//    }
}


