package com.android.checkbox

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.checkbox.R.id.resolved

class MainActivity : AppCompatActivity() , AdapterView.OnItemSelectedListener  {

    lateinit var spinner: Spinner
    lateinit var result : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



    spinner = findViewById(R.id.spinnerCountry)
    result = findViewById(resolved)
    spinner.onItemSelectedListener = this
    var arrayAdapter = ArrayAdapter.createFromResource(this,R.array.countries,android.R.layout.simple_spinner_item)
    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.adapter = arrayAdapter





//        ToogleButton learning
//        lateinit var image : ImageView
//        lateinit var text : TextView
//        lateinit var button : ToggleButton
//
//        image = findViewById(R.id.bulb)
//        text = findViewById(R.id.textResult)
//        button = findViewById(R.id.onOff)
//
//    button.setOnCheckedChangeListener { compoundButton , isChecked ->
//        if (isChecked){
//            image.setImageResource(R.drawable.lighton)
//            text.text  = "Light is On"
//        }
//        else{
//            image.setImageResource(R.drawable.lightoff)
//            text.text = "light is Off"
//        }
//    }


//        RadioButton Learning
//        lateinit var layout : LinearLayout
//        lateinit var green : RadioButton
//        lateinit var black : RadioButton
//        lateinit var shadow : RadioButton
//        lateinit var grey : RadioButton
//        lateinit var change : Button
//
//        layout = findViewById(R.id.main)
//        green = findViewById(R.id.green)
//        black = findViewById(R.id.black)
//        shadow = findViewById(R.id.shadow)
//        grey =  findViewById(R.id.chevron)
//        change = findViewById(R.id.button)
//
//        change.setOnClickListener {
//            if(green.isChecked){
//                layout.setBackgroundColor(Color.GREEN)
//            }
//            else if(black.isChecked){
//                layout.setBackgroundColor(Color.BLACK)
//                green.setTextColor(Color.WHITE)
//                shadow.setTextColor(Color.WHITE)
//                grey.setTextColor(Color.WHITE)
//            }
//            else if (shadow.isChecked){
//                layout.setBackgroundColor(Color.RED)
//            }
//            else if (shadow.isChecked){
//                layout.setBackgroundColor(Color.GRAY)
//            }
//            else if(grey.isChecked){
//                layout.setBackgroundColor(Color.WHITE)
//                green.setTextColor(Color.BLACK)
//            }
//        }





//        checkbox learning
//        lateinit var yess: CheckBox
//        lateinit var noo : CheckBox
//        lateinit var question : TextView
//
//        yess = findViewById(R.id.yes)
//        noo = findViewById(R.id.no)
//        question = findViewById(R.id.textViewResult)
//
//        yess.setOnClickListener {
//            if(yess.isChecked){
//                question.text = "You are Eligible to Vote"
//                noo.isChecked= false
//            }
//            else{
//                question.text = "Are you legal to Vote"
//            }
//        }
//
//        noo.setOnClickListener {
//            if(noo.isChecked){
//                question.text = "You are not Eligible to Vote"
//                yess.isChecked = false
//            }
//            else{
//                question.text = "Are you legal to Vote"
//            }
//        }


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }

//
    }
    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        if (parent!=null){
            result.text = parent.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

}