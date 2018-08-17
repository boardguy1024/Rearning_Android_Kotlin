package com.example.parkkyungsuk.soundtest

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // あとでinitする場合には lateinitをつけるといい (!) 代わりに ?(null可能性あり) もつけられる
    //var soundPool1: SoundPool? = null
    lateinit var soundPool: SoundPool

    var id1: Int = 0
    var id2: Int = 0
    var id3: Int = 0
    var id4: Int = 0
    var id5: Int = 0
    var id6: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_amai.setOnClickListener {
            soundPool.play(id1,1f,1f,0,0,1f)
        }
        btn_kyoteki.setOnClickListener {
            soundPool.play(id2,1f,1f,0,0,1f)
        }
        btn_kurae.setOnClickListener {
            soundPool.play(id3,1f,1f,0,0,1f)
        }
        btn_ikuzo.setOnClickListener {
            soundPool.play(id4,1f,1f,0,0,1f)
        }
        btn_to.setOnClickListener {
            soundPool.play(id5,1f,1f,0,0,1f)
        }
        btn_yorosiku.setOnClickListener {
            soundPool.play(id6,1f,1f,0,0,1f)
        }

    }

    override fun onResume() {
        super.onResume()

        // Build.Version.Sdk.Int この端末のSDKバージョンが Lollipop以上の場合
        soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            SoundPool.Builder().setAudioAttributes(AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build())
                    .setMaxStreams(1)
                    .build()
        } else {
            //以下は使われないかもしれないが、一応書いておく（バージョンが古いため、非推奨されている）
            SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        }

        id1 = soundPool.load(this, R.raw.amai, 1)
        id2 = soundPool.load(this, R.raw.koreha_kyoteki, 1)
        id3 = soundPool.load(this, R.raw.kurae, 1)
        id4 = soundPool.load(this, R.raw.sa_ikuzo, 1)
        id5 = soundPool.load(this, R.raw.to, 1)
        id6 = soundPool.load(this, R.raw.yorosiku_tanomu, 1)
    }

    override fun onPause() {
        super.onPause()
        soundPool.release()
    }
}
