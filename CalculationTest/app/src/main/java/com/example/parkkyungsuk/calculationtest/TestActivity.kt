package com.example.parkkyungsuk.calculationtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_test.*
import java.util.*

class TestActivity : AppCompatActivity(), View.OnClickListener {

    var numberOfQestion: Int = 0
    var numberOfCorrect: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        commonInit()

        buttonAnswer.setOnClickListener {
            answerCheck()
        }

        button0.setOnClickListener(this)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonClear.setOnClickListener(this)

        //初期、１問目を標示する
        question()
    }

    private fun commonInit() {

        val bundle = intent.extras
        numberOfQestion = bundle.getInt("numberOfQuestion")
        textViewCount.text = numberOfQestion.toString()
    }

    //問題を出す処理
    private fun question() {

        buttonBack.isEnabled = false
        buttonAnswer.isEnabled = true
        button0.isEnabled = true
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        buttonMinus.isEnabled = true
        buttonClear.isEnabled = true

        //乱数を生成
        val random = Random()
        val numQuestionLeft: Int = random.nextInt(100) + 1
        val numQuestionRight: Int = random.nextInt(100) + 1

        textViewLeftNum.text = numQuestionLeft.toString()
        textViewRightNum.text = numQuestionRight.toString()

        when (random.nextInt(2) + 1) {
            1 -> textViewOperator.text = "+"
            2 -> textViewOperator.text = "-"
        }

        //imageViewを非表示
        imageViewResult.visibility = View.INVISIBLE

    }

    //答え合わせ処理
    private fun answerCheck() {
        buttonBack.isEnabled = false
        buttonAnswer.isEnabled = false
        button0.isEnabled = false
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
        buttonMinus.isEnabled = false
        buttonClear.isEnabled = false

        //残り問題数を１個減らす
        numberOfQestion -= 1
        textViewCount.text = numberOfQestion.toString()

        imageViewResult.visibility = View.VISIBLE


        //答えあわせ計算判定

        val inputNumFromUser: Int = textViewResultCal.text.toString().toInt()
        var correctCalculatedNum: Int = 0
        val leftNum: Int = textViewLeftNum.text.toString().toInt()
        val rightNum: Int = textViewRightNum.text.toString().toInt()
        if (textViewOperator.text.toString() == "+") {
            correctCalculatedNum = leftNum + rightNum
        }
        else correctCalculatedNum = leftNum - rightNum

        if (inputNumFromUser == correctCalculatedNum) {
            imageViewResult.setImageResource(R.drawable.pic_correct)
            //正解数を反映
            numberOfCorrect += 1
            textViewCorrect.text = numberOfCorrect.toString()
            //正解率を反映
        }
        else {
            imageViewResult.setImageResource(R.drawable.pic_incorrect)
        }


    }


    override fun onClick(p0: View?) {

        val button: Button = p0 as Button

        when(p0?.id) {
            R.id.buttonClear
            -> textViewResultCal.text = ""

            // - ボタンタップ処理
            R.id.buttonMinus
            -> if (textViewResultCal.text.toString() == "") {
                textViewResultCal.text = "-"
            }

            // 0ボタンがタップされた場合
            R.id.button0
            -> if (textViewResultCal.text.toString() != "0" && textViewResultCal.text.toString() != "-") {
                textViewResultCal.append(button.text)
            }
            else
            -> if (textViewResultCal.text.toString() == "0")
                textViewResultCal.text = button.text
            else textViewResultCal.append(button.text)
        }
    }

}
