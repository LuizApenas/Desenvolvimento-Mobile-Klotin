package com.example.activitycom3fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FormularioFragment : Fragment() {

    private lateinit var nome: EditText
    private lateinit var email: EditText
    private lateinit var idade: EditText
    private lateinit var botaoEnviar: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_formulario, container, false)

        nome = view.findViewById(R.id.nome)
        email = view.findViewById(R.id.email)
        idade = view.findViewById(R.id.idade)
        botaoEnviar = view.findViewById(R.id.botaoEnviar)

        botaoEnviar.setOnClickListener {
            val nomeTexto = nome.text.toString()
            val emailTexto = email.text.toString()
            val idadeTexto = idade.text.toString()

            // Criar instância do fragmento de resultados e passar os dados
            val resultadoFragment = ResultadoFragment().apply {
                arguments = Bundle().apply {
                    putString("nome", nomeTexto)
                    putString("email", emailTexto)
                    putString("idade", idadeTexto)
                }
            }

            // Substituir este fragmento pelo fragmento de resultados
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, resultadoFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}