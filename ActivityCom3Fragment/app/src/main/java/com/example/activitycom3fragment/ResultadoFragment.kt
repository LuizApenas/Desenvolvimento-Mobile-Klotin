package com.example.activitycom3fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ResultadoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_resultado, container, false)

        // Recuperar os dados do Bundle
        val nome = arguments?.getString("nome") ?: ""
        val email = arguments?.getString("email") ?: ""
        val idade = arguments?.getString("idade") ?: ""

        // Exibir os dados no TextView
        val textResultado = view.findViewById<TextView>(R.id.textResultado)
        textResultado.text = "Nome: $nome\nEmail: $email\nIdade: $idade"

        return view
    }
}