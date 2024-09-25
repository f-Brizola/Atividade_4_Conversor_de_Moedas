package com.example.myapplicationatividade_4_conversor_de_moedas

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputValor = findViewById<EditText>(R.id.edValor)
        val inputTaxa = findViewById<EditText>(R.id.edTaxa)
        val resultado = findViewById<TextView>(R.id.txtResultado)
        val botaoConverter = findViewById<Button>(R.id.btnConverter)

        botaoConverter.setOnClickListener {

            val valorInformado = inputValor.text.toString()
            val taxaInformada = inputTaxa.text.toString()

            val money = DecimalFormat("R$ #,###.00")

            if (valorInformado.isNotEmpty() && taxaInformada.isNotEmpty()){

                val valorDouble = valorInformado.toDouble()
                val taxaDouble = taxaInformada.toDouble()

                val valorConvertido = valorDouble * taxaDouble

                resultado.setText("Valor da Converção: ${money.format(valorConvertido)}")

            }else{
                resultado.setText("Informe O Valor e a Taxa de cambio"  )
            }

        }

    }

    fun limparValores(view: View){
        val inputValor = findViewById<EditText>(R.id.edValor)
        val inputTaxa = findViewById<EditText>(R.id.edTaxa)
        val resultado = findViewById<TextView>(R.id.txtResultado)

        inputValor.setText("")
        inputTaxa.setText("")
        resultado.setText("")

    }
}