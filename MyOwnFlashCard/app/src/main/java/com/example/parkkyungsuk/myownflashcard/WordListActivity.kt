package com.example.parkkyungsuk.myownflashcard

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_word_list.*

class WordListActivity : AppCompatActivity() {

    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_list)

        wordListConstraintLayout.setBackgroundResource(intBackgroundColor)

        buttonAddWords.setOnClickListener {
            val intent = Intent(this@WordListActivity, EditActivity::class.java)
            intent.putExtra(getString(R.string.intent_key_status), getString(R.string.status_add))
            startActivity(intent)
        }

        buttonBack.setOnClickListener {
            finish()
        }

    }

    override fun onResume() {
        super.onResume()
        realm = Realm.getDefaultInstance()

        val result: RealmResults<WordDB> = realm.where(WordDB::class.java)
                .findAll()
                .sort(getString(R.string.db_field_question))

        val words_list = ArrayList<String>()

        result.forEach { wordDB ->
            words_list.add(wordDB.strQuestion + " : " + wordDB.strAnswer)
        }

        val adaptor = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words_list)
        listView.adapter = adaptor
    }

    override fun onPause() {
        super.onPause()
        realm.close()
    }
}




