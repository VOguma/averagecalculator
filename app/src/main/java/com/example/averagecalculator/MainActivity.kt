package com.example.averagecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android .widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Referências aos componentes da UI
        val inputNumbers = findViewById<EditText>(R.id.inputNumbers)
        val calculateButton = findViewById<Button>(R.id.calcutateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        //Configurando o clique do botão
        calculateButton.setOnClickListener {
            //Obtendo os valores inseridos
            val numbersText = inputNumbers.text.toString()
            if (numbersText.isNotEmpty()) {
                //Separar os números fornecidos pelo usuário e calcular a média
                val numbers = numbersText.split(",").mapNotNull { it.trim().toDoubleOrNull() }
                if (numbers.isNotEmpty()) {
                    val average = numbers.average()
                    resultTextView.text = "Média: %.2f".format(average)
                } else {
                    resultTextView.text = "Por favor, insira apenas números válidos separados por vírgulas"
                }
            }else {
                resultTextView.text = "Por favor, insira algum número!"
            }

        }
    }

}