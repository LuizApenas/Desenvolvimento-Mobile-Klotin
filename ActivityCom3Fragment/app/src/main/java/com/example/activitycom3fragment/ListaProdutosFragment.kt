package com.example.activitycom3fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListaProdutosFragment : Fragment() {

    private lateinit var listaProdutos: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_lista_produtos, container, false)

        listaProdutos = view.findViewById(R.id.listaProdutos)

        // Lista de produtos
        val produtos = arrayOf(
            "Smartphone Galaxy A23 - R$ 1.299,99",
            "Smart TV 50\" - R$ 2.499,99",
            "Notebook Dell Inspiron - R$ 3.599,99",
            "Headphone Bluetooth - R$ 299,99",
            "Tablet iPad - R$ 2.399,99",
            "Mouse Wireless - R$ 89,99",
            "Teclado Mecânico - R$ 249,99",
            "Monitor 24\" - R$ 899,99"
        )

        // Adapter para a ListView
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, produtos)
        listaProdutos.adapter = adapter

        // Configurar clique nos itens
        listaProdutos.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                requireContext(),
                "Produto selecionado: ${produtos[position]}",
                Toast.LENGTH_SHORT
            ).show()
        }

        return view
    }
}