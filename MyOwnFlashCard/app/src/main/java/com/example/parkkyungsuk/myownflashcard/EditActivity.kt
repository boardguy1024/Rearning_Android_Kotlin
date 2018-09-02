package com.example.parkkyungsuk.myownflashcard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_word_list.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val bundle = intent.extras
        val status = bundle.getString(getString(R.string.intent_key_status))

        textViewForEdit.text = status

        constraintLayout.setBackgroundResource(intBackgroundColor)

        buttonRegist.setOnClickListener {


            if (status == getString(R.string.status_add)) {
                //Add時
                addNewWord()
            }
            else {
                //編集時
                changeWord()
            }
        }

        buttonBackEdit.setOnClickListener {
            finish()
        }
    }

    private fun addNewWord() {

    }

    private fun changeWord() {

    }



}
