package com.example.duastelasclaudio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.util.Log


class MainActivity : AppCompatActivity() {

    private lateinit var nome: EditText
    private lateinit var email: EditText
    lateinit var idade : EditText
    private lateinit var botaoEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ciclo_vida", "onCreate")
        setContentView(R.layout.activity_main)

        nome = findViewById(R.id.nome)
        email = findViewById(R.id.email)
        idade = findViewById(R.id.idade)
        botaoEnviar = findViewById(R.id.botaoEnviar)

        botaoEnviar.setOnClickListener {
            val nome = nome.text.toString()
            val email = email.text.toString()
            val idade = idade.text.toString()

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("nome", nome)
                putExtra("idade", idade)
                putExtra("email", email)

            }
            startActivity(intent)
        }
    }
}
