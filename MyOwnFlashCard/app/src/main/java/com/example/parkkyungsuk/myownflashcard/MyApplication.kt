package com.example.parkkyungsuk.myownflashcard

import android.app.Application
import io.realm.Realm

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //Realmの初期化
        Realm.init(this)

    }

}