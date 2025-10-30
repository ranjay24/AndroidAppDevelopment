package com.android.calculator

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    var number : String? = null

    var firstNumber : Double = 0.0
    var lastNumber : Double = 0.0
    var status : String? = null
    var operator : Boolean = false

    val myFormatter = DecimalFormat("######.######")

    var history : String= ""
    var currResult : String = ""
    var dotContro : Boolean = true
    var buttonEqualsControl : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.textViewResult.text = "0"

        mainBinding.btnZero.setOnClickListener { view ->
            onNumberClick("0")
        }
        mainBinding.btnOne.setOnClickListener {
            onNumberClick("1")
        }

        mainBinding.btnTwo.setOnClickListener { view ->
            onNumberClick("2")
        }
        mainBinding.btnThree.setOnClickListener { view ->
            onNumberClick("3")
        }
        mainBinding.btnFour.setOnClickListener { view ->
            onNumberClick("4")
        }
        mainBinding.btnFive.setOnClickListener { view ->
            onNumberClick("5")
        }
        mainBinding.btnSix.setOnClickListener { view ->
            onNumberClick("6")
        }
        mainBinding.btnSeven.setOnClickListener { view ->
            onNumberClick("7")
        }
        mainBinding.btnEight.setOnClickListener { view ->
            onNumberClick("8")
        }
        mainBinding.btnNine.setOnClickListener { view ->
            onNumberClick("9")
        }

        mainBinding.btnAC.setOnClickListener { view ->
          onButtonAcClicked()
        }
        mainBinding.btnDel.setOnClickListener { view ->

            number?.let {
                if (it.length==1){
                    onButtonAcClicked()
                }
                else {
                    number = it.substring(0, it.length - 1)
                    mainBinding.textViewResult.text = number
                    dotContro = !number!!.contains(".")
                }
            }
        }
        mainBinding.btnDivide.setOnClickListener { view ->

            history = mainBinding.textViewHistory.text.toString()
            currResult  = mainBinding.textViewResult.text.toString()
            mainBinding.textViewHistory.text  = history.plus(currResult).plus("/")


            if (operator){
                when(status){
                    "multiplication" -> multiply()
                    "division" -> divide()
                    "substraction" -> minus()
                    "addition" -> plus()
                    else -> firstNumber = mainBinding.textViewResult.text.toString().toDouble()
                }
            }
            status = "division"
            operator = false
            number = null
            dotContro = true

        }
        mainBinding.btnMulti.setOnClickListener { view ->
            history = mainBinding.textViewHistory.text.toString()
            currResult  = mainBinding.textViewResult.text.toString()
            mainBinding.textViewHistory.text  = history.plus(currResult).plus("*")
            if (operator){
                when(status){
                    "multiplication" -> multiply()
                    "division" -> divide()
                    "substraction" -> minus()
                    "addition" -> plus()
                    else -> firstNumber = mainBinding.textViewResult.text.toString().toDouble()
                }
            }
            status = "multiplication"
            operator = false
            number = null
            dotContro = true

        }
        mainBinding.btnMinus.setOnClickListener { view ->
            history = mainBinding.textViewHistory.text.toString()
            currResult  = mainBinding.textViewResult.text.toString()
            mainBinding.textViewHistory.text  = history.plus(currResult).plus("-")
            if (operator){
                when(status){
                    "multiplication" -> multiply()
                    "division" -> divide()
                    "substraction" -> minus()
                    "addition" -> plus()
                    else -> firstNumber = mainBinding.textViewResult.text.toString().toDouble()
                }
            }
            status = "substraction"
            operator = false
            number = null
            dotContro = true
        }
        mainBinding.btnPlus.setOnClickListener { view ->
            history = mainBinding.textViewHistory.text.toString()
            currResult  = mainBinding.textViewResult.text.toString()
            mainBinding.textViewHistory.text  = history.plus(currResult).plus("+")

            if (operator){
                when(status){
                    "multiplication" -> multiply()
                    "division" -> divide()
                    "substraction" -> minus()
                    "addition" -> plus()
                    else -> firstNumber = mainBinding.textViewResult.text.toString().toDouble()
                }
            }
            status = "addition"
            operator = false
            number = null
            dotContro = true
        }
        mainBinding.btnEquals.setOnClickListener { view ->
            history = mainBinding.textViewHistory.text.toString()
            currResult  = mainBinding.textViewResult.text.toString()

            if (operator){
                when(status){
                    "multiplication" -> multiply()
                    "division" -> divide()
                    "substraction" -> minus()
                    "addition" -> plus()
                    else -> firstNumber = mainBinding.textViewResult.text.toString().toDouble()
                }
                mainBinding.textViewHistory.text  = history.plus(currResult).plus("=").plus(mainBinding.textViewResult.text.toString())
            }
            operator = false
            dotContro = true
            buttonEqualsControl = true
        }
        mainBinding.btnDot.setOnClickListener { view ->


            if (dotContro){
                number = if (number==null){
                    "0."
                }else if (buttonEqualsControl){
                    if (mainBinding.textViewResult.text.toString().contains(".")){
                        mainBinding.textViewResult.text.toString()
                    }else{
                        mainBinding.textViewResult.text.toString().plus(".")
                    }
                }
                else{
                    "$number."
                }
                mainBinding.textViewResult.text = number
            }

            dotContro= false


        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onButtonAcClicked(){
        number=null
        status=null
        mainBinding.textViewResult.text = "0"
        mainBinding.textViewHistory.text = ""
        firstNumber=0.0
        lastNumber = 0.0
        dotContro = true
        buttonEqualsControl = false

    }
    fun onNumberClick(clickedNumber : String){
        if (number==null){
            number = clickedNumber
        }
        else if(buttonEqualsControl){
          number =   if (dotContro){
                clickedNumber
            }else{
                mainBinding.textViewResult.text.toString().plus(clickedNumber)
            }
            firstNumber = number!!.toDouble()
            lastNumber = 0.0
            status = null
            mainBinding.textViewResult.text= ""
        }
        else{
            number+=clickedNumber
        }
        mainBinding.textViewResult.text = number

        operator = true
        buttonEqualsControl = false
    }

    fun plus(){
        lastNumber = mainBinding.textViewResult.text.toString().toDouble()
        firstNumber+=lastNumber
        mainBinding.textViewResult.text = myFormatter.format(firstNumber)
    }
    fun minus(){
        lastNumber = mainBinding.textViewResult.text.toString().toDouble()
        firstNumber-=lastNumber
        mainBinding.textViewResult.text = myFormatter.format(firstNumber)
    }
    fun multiply(){
        lastNumber = mainBinding.textViewResult.text.toString().toDouble()
        firstNumber*=lastNumber
        mainBinding.textViewResult.text = myFormatter.format(firstNumber)
    }
    fun divide(){
        lastNumber = mainBinding.textViewResult.text.toString().toDouble()
        if(lastNumber==0.0){
            Toast.makeText(applicationContext,"Divisor cannot be Zero", Toast.LENGTH_LONG).show()
        }
        else{
            firstNumber/=lastNumber
            mainBinding.textViewResult.text = myFormatter.format(firstNumber)
        }
    }

}