package com.example.parkkyungsuk.myownflashcard

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class WordDB :RealmObject() {

    //フィールドの作成
    //問題
    var strQuestion: String = ""
    //こたえ
    var strAnswer: String = ""
}