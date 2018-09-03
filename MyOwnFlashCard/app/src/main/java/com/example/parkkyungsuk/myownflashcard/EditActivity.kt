package com.example.parkkyungsuk.myownflashcard

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    lateinit private var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val bundle = intent.extras
        val status = bundle.getString(getString(R.string.intent_key_status))

        textViewForEdit.text = status

        constraintLayoutForEdit.setBackgroundResource(intBackgroundColor)

        buttonRegist.setOnClickListener {

            if (status == getString(R.string.status_add)) {
                addNewWord()
            } else {
                changeWord()
            }
        }

        buttonBackEdit.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()

        //Realmのインスタンス取得
        //RealmはSingltonオブジェクトである
        realm = Realm.getDefaultInstance()
    }


    override fun onPause() {
        super.onPause()
        realm.close()
    }

    private fun addNewWord() {

        //keyを設定して
        val id = 1
        //initしたインスタンスをとってきて、トランザクションで書き込

        realm.beginTransaction()
//
        val wordDB = realm.createObject(WordDB::class.java)
        wordDB.strQuestion = questionForEditText.text.toString()
        wordDB.strAnswer = answerForEditText.text.toString()

        realm.commitTransaction()

//      //DBに保存後、textViewにテキストを削除
        questionForEditText.setText("")
        answerForEditText.setText("")

        //登録完了メッセージを表示
        Toast.makeText(this@EditActivity, "登録が完了しました", Toast.LENGTH_SHORT).show()
    }

    private fun changeWord() {

    }



}
