package com.example.activitycom3fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.activitycom3fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar botões para navegar entre fragments
        binding.btnFormulario.setOnClickListener {
            trocarFragment(FormularioFragment())
        }

        binding.btnMenuFragments.setOnClickListener {
            trocarFragment(MenuFragment())
        }

        binding.btnListaProdutos.setOnClickListener {
            trocarFragment(ListaProdutosFragment())
        }

        // Iniciar com o fragmento principal
        if (savedInstanceState == null) {
            trocarFragment(FormularioFragment())
        }
    }

    private fun trocarFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}