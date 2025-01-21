package com.example.averagecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android .widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Referenciando os elementos do layout
        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val number3 = findViewById<EditText>(R.id.number3)
        val number4 = findViewById<EditText>(R.id.number4)
        val calculateButton = findViewById<Button>(R.id.calcutateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        //Configurando o clique do botão
        calculateButton.setOnClickListener {
            //Obtendo os valores inseridos
            val num1 = number1.text.toString().toDoubleOrNull()
            val num2 = number2.text.toString().toDoubleOrNull()
            val num3 = number3.text.toString().toDoubleOrNull()
            val num4 = number4.text.toString().toDoubleOrNull()

            //Verificando se todos os números foram preenchidos
            if  (num1 != null && num2 != null && num3 != null && num4 != null) {
                //Calculando a média
                val average = (num1 + num2 + num3 + num4) / 4
                resultTextView.text = "Resultado: %.2f".format(average)
            } else {
                //Mostrando mensagem de erro
                resultTextView.text = "Por favor, insira todos os números."
            }
        }
    }

}