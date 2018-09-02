package com.example.parkkyungsuk.myownflashcard

import io.realm.RealmObject

open class WordDB :RealmObject() {

    //フィールドの作成
    //問題
    var strQuestion: String = ""
    //こたえ
    var strAnswer: String = ""
}