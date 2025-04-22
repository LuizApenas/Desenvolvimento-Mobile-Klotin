package com.example.duastelasclaudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textResultado = findViewById(R.id.textResultado)

        // Recebendo os dados enviados pela MainActivity
        val nome = intent.getStringExtra("nome")
        val idade = intent.getStringExtra("idade")
        val email = intent.getStringExtra("email")

        // Exibindo os dados recebidos
        textResultado.text = "Nome: $nome\nIdade: $idade anos\nE-mail: $email"
    }
}