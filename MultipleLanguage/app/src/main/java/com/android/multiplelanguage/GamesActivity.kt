package com.android.multiplelanguage

import android.graphics.Color
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GamesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_games)

        var layout = findViewById<ConstraintLayout>(R.id.fullView)
        var gameGroup = findViewById<RadioGroup>(R.id.gameGroup)
        var chess = findViewById<RadioButton>(R.id.chess)
        var table_tennis = findViewById<RadioButton>(R.id.tabletennis)
        var ludo = findViewById<RadioButton>(R.id.ludo)

        gameGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.chess -> {
                    layout.setBackgroundResource(R.drawable.chess)
                    chess.setTextColor(Color.WHITE)
                    table_tennis.setTextColor(Color.WHITE)
                    ludo.setTextColor(Color.WHITE)
                }
                R.id.tabletennis -> {
                    layout.setBackgroundResource(R.drawable.table_tenis)
                    chess.setTextColor(Color.WHITE)
                    table_tennis.setTextColor(Color.WHITE)
                    ludo.setTextColor(Color.WHITE)
                }
                R.id.ludo -> {
                    layout.setBackgroundResource(R.drawable.ludo)
                    chess.setTextColor(Color.WHITE)
                    table_tennis.setTextColor(Color.WHITE)
                    ludo.setTextColor(Color.WHITE)
                }
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fullView)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}