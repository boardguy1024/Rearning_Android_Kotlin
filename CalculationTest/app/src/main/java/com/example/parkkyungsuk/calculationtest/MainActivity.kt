package com.example.parkkyungsuk.calculationtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1引数：This, 2引数：ArrayResourceId, 3引数：Spinnerのitemのidを設定　（こうすることでSpinnerためのAdaptorとなる）
        val arrayAdaptor = ArrayAdapter.createFromResource(this, R.array.number_of_question, android.R.layout.simple_spinner_item)
        spinner.adapter = arrayAdaptor

        //スタートボタン
        button.setOnClickListener {
            val numberOfQuestion = spinner.selectedItem.toString().toInt()

            val intent = Intent(this@MainActivity, TestActivity::class.java)
            intent.putExtra("numberOfQuestion", numberOfQuestion)
            startActivity(intent)
        }
    }
}
