package com.example.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

    }

    //Parte aonde vai mostrar os lados do dado
    private fun rollDice() {

        val randomInt = (1..6).random()
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        val txtResultado: TextView = findViewById(R.id.txtResultado)
        val edtNum: EditText = findViewById(R.id.edtNum)

        if(randomInt == edtNum.text.toString().toInt()){
            txtResultado.setText("Você ganhou!")
        }else{
            txtResultado.setText("Você perdeu!!")
        }

    }

}