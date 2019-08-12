package com.example.calculadoraimc

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val edtValor = findViewById<EditText>(R.id.edtValor)
        val btnAltera = findViewById<Button>(R.id.btnAlterar)


        btnAltera.setOnClickListener {
            val valor = edtValor?.text.toString()

            val i = intent

            i.putExtra("valor", valor)

            setResult(Activity.RESULT_OK, i)

            finish()
        }
    }
}
