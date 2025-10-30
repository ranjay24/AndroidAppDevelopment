package com.android.mathgame

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    var correct_ans = 0
    var userScore = 0
    var userLife = 3

    var opration  = "add"

    lateinit var timer : CountDownTimer
    private val startTimerInMillis : Long = 20000
    var timeLeftInMillis : Long = startTimerInMillis
    lateinit var textScore : TextView
    lateinit var textLife : TextView
    lateinit var textTime : TextView

    lateinit var textQuestion : TextView
    lateinit var textAnswer : TextView

    lateinit var buttonOk : Button
    lateinit var buttonNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)
        textQuestion = findViewById(R.id.textViewQuestion)
        textAnswer = findViewById(R.id.editTextAnswer)
        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)

        opration = intent.getStringExtra("operationType")?: "add"

        gameContinue()
        buttonOk.setOnClickListener { view ->
            val input = textAnswer.text.toString()
            if (input==""){
                Toast.makeText(applicationContext,"Please write the answer !!", Toast.LENGTH_LONG).show()
            }
            else{
                pauseTimer()
                var userAnswer = input.toInt()
                if (userAnswer==correct_ans){
                    userScore+=10
                    textQuestion.text = "Congratualations, your answer is correct"
                    textScore.text = userScore.toString()
                }
                else{
                   userLife-=1
                    textQuestion.text  = "Sorry , your answer is wrong"
                    textLife.text = userLife.toString()
                }
            }
        }

        buttonNext.setOnClickListener { view ->
            pauseTimer()
            resetTimer()
//        gameContinue()
            textAnswer.setText("")
            if (userLife==0){
                Toast.makeText(applicationContext,"Game Over", Toast.LENGTH_LONG).show()
                val intent  = Intent(this@GameActivity, ResultActivity::class.java)
                intent.putExtra("score",userScore)
                startActivity(intent)
                finish()
            }
            else{
                gameContinue()
            }
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun gameContinue(){
        val number1 =  Random.nextInt(0,100)
        val number2 = Random.nextInt(0,100)

        when(opration){
            "add" ->{
                textQuestion.text = "$number1 + $number2"
                correct_ans = number1 +  number2
            }
            "sub"->{
                textQuestion.text = "$number1 - $number2"
                correct_ans = number1 -  number2
            }
            "mul"->{
                textQuestion.text = "$number1 * $number2"
                correct_ans = number1 *  number2
            }
        }
        startTimer()
    }

    fun startTimer(){
        timer = object : CountDownTimer(timeLeftInMillis,1000){
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateText()

            }

            override fun onFinish(){
                pauseTimer()
                resetTimer()
                updateText()
                userLife--
                textLife.text = userLife.toString()
                textQuestion.text = "Sorry , the time is up !"
            }



        }.start()
    }

    fun updateText(){
        val remainingTime : Int = (timeLeftInMillis/1000).toInt()
        textTime.text = String.format(Locale.getDefault(),"%02d",remainingTime)
    }
    fun pauseTimer(){
        timer.cancel()
    }
    fun resetTimer(){
        timeLeftInMillis = startTimerInMillis
        updateText()
    }

}