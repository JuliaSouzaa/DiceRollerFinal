package com.example.diceroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    //Função que mostra respectivamente os lados do dado aleatoriamente
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

        //declaração e converção  de variaveis
        diceImage.setImageResource(drawableResource)
        val txtResultado: TextView = findViewById(R.id.txtResultado)
        val edtNum: EditText = findViewById(R.id.edtNum)
        val Num: Int = edtNum.text.toString().toInt()

        //verificando se o numero corresnponde a um dos lados do dado
        if (Num in 1..6 == false) {
            txtResultado.setText("Esse número não existe! Tente de 1 a 6 ) :")

        //caso seja true, verifica se o numero corresponde ao numero atual do lado do dado
        }else if (Num == randomInt) {
            txtResultado.setText("Parabéns acertou! Você tem sorte ( :")

        //se for um dos lados do dado, mas nao corresponde ao numero do lado atual
        }else {
            txtResultado.setText("Você errou o número! Tente novamente ):")

        }//fim do if
    }
}

