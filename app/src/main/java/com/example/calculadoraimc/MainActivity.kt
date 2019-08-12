package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Half.toFloat
import android.util.Log
import android.widget.Button
import android.widget.TextView

/**
 * @Atividade: Calculadora IMC
 * @author: Douglas Alexandre dos Santos
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //Definindo as Views pelo seu id
        val txtPeso = findViewById<TextView>(R.id.txtPeso)
        val txtAltura = findViewById<TextView>(R.id.txtAltura)
        val btnPeso = findViewById<Button>(R.id.btnPeso)
        val btnAltura = findViewById<Button>(R.id.btnAltura)
        val btnCalcula = findViewById<Button>(R.id.btnCalcula)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        //Criando Intent para capturar os valores
        val intent = Intent(this, Main2Activity::class.java)

        //Definindo Listeners dos botões

        //Botão para alterar o peso
        btnPeso.setOnClickListener {
            startActivityForResult(intent, 1)
        }

        //Botão para alterar a altura
        btnAltura.setOnClickListener {
            startActivityForResult(intent, 2)
        }

        //Botão para calcular o resultado
        btnCalcula.setOnClickListener {
            val TAG = "myapp"
            var peso = txtPeso.text.toString().toFloat()
            var altura = txtAltura.text.toString().toFloat()
            var result = peso/(altura*altura)

            //Log.d(TAG, "" + peso + ", " + altura + ", " + result)

            var msg = String()
            if (result < 16){
                msg = "IMC < 16:\nMagreza Grave"
            }
            if (16 <= result && result < 17){
                msg = "16 <= IMC < 17:\nMagreza Moderada"
            }
            if (17 <= result && result < 18.5){
                msg = "17 <= IMC < 18.5:\nMagreza Leve"
            }
            if (18.5 <= result && result < 25){
                msg = "18.5 <= IMC < 25:\nSaudável"
            }
            if (25 <= result && result < 30){
                msg = "25 <= IMC < 30:\nSobrepeso"
            }
            if (30 <= result && result < 35){
                msg = "30 <= IMC < 35:\nObesidade Grau I"
            }
            if (35 <= result && result < 40){
                msg = "35 <= IMC < 40:\nObesidade Grau II (severa)"
            }
            if (40 <= result){
                msg = "30 <= IMC < 35:\nObesidade Grau III(mórbida)"
            }

            txtResultado.text = msg

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        val TAG = "myapp"
        var valor = data?.getStringExtra("valor")
        if (requestCode == 1){
            var txtPeso = findViewById<TextView>(R.id.txtPeso)
            txtPeso.text = valor.toString()
            //Log.d(TAG, valor + ", " + valor.toString().toFloat())

        }

        if (requestCode == 2){
            var txtAltura = findViewById<TextView>(R.id.txtAltura)
            txtAltura.text = valor.toString()
            //Log.d(TAG, valor + ", " + valor.toString().toFloat())


        }


    }

}
