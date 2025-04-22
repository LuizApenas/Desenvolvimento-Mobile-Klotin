package com.example.activitycom3fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class MenuFragment : Fragment() {
    private lateinit var fragmentManager: androidx.fragment.app.FragmentManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        fragmentManager = childFragmentManager

        // Configurar botões para navegar entre sub-fragmentos
        view.findViewById<Button>(R.id.fragmentButton01).setOnClickListener {
            trocarSubFragment(Fragment1())
        }

        view.findViewById<Button>(R.id.fragmentButton02).setOnClickListener {
            trocarSubFragment(Fragment2())
        }

        view.findViewById<Button>(R.id.fragmentButton03).setOnClickListener {
            trocarSubFragment(Fragment3())
        }

        // Iniciar com o primeiro sub-fragmento
        if (savedInstanceState == null) {
            trocarSubFragment(Fragment1())
        }

        return view
    }

    private fun trocarSubFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}