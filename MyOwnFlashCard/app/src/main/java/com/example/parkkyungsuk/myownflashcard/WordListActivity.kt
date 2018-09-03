package com.example.parkkyungsuk.myownflashcard

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import io.realm.Realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.activity_word_list.*

class WordListActivity : AppCompatActivity(), AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {


    lateinit var realm: Realm
    lateinit var result: RealmResults<WordDB>

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

        //listView.setOnItemLongClickListener(this) これを下のようにできる

        listView.onItemClickListener = this
        listView.onItemLongClickListener = this

    }

    override fun onResume() {
        super.onResume()
        realm = Realm.getDefaultInstance()

        result = realm.where(WordDB::class.java)
                .findAll()
                .sort(getString(R.string.db_field_question))

        val words_list = ArrayList<String>()

        result.forEach { wordDB ->
            words_list.add(wordDB.strQuestion + " : " + wordDB.strAnswer)
        }

        //iOSの $0のようなもの
//        result.forEach {
//            words_list.add(it.strQuestion + " : " + it.strAnswer)
//        }

        val adaptor = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words_list)
        listView.adapter = adaptor
    }

    override fun onPause() {
        super.onPause()
        realm.close()
    }

    //編集
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedDB = result[position]
        val question = selectedDB.strQuestion
        val answer = selectedDB.strAnswer

        val intent = Intent(this@WordListActivity, EditActivity::class.java)

        intent.putExtra(getString(R.string.intent_key_question), question)
        intent.putExtra(getString(R.string.intent_key_answer),answer)
        intent.putExtra(getString(R.string.intent_key_position), position)
        intent.putExtra(getString(R.string.intent_key_status),getString(R.string.status_change))
        startActivity(intent)
    }


    //削除
    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}




