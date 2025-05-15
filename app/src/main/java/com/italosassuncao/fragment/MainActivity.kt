package com.italosassuncao.fragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.italosassuncao.fragment.fragments.ChamadasFragment
import com.italosassuncao.fragment.fragments.ConversasFragment

class MainActivity : AppCompatActivity() {

    private lateinit var buttonMercado: Button
    private lateinit var buttonChamadas: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        buttonMercado = findViewById(R.id.buttonMercado)
        buttonChamadas = findViewById(R.id.button_chamadas)

        val fragment = supportFragmentManager.beginTransaction()
        /*fragment.add(R.id.fragment_content, ConversasFragment())
        fragment.commit()*/

        // Alternativa
        buttonMercado.setOnClickListener {
            val conversasFragment = ConversasFragment()

            val bundle = bundleOf(
                "categoria" to "Mercado",
                "usuario" to "italo"
            )

            conversasFragment.arguments = bundle

            /*supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_content, conversasFragment)
                .commit()*/

            // Passos utilizando o Kotlin KTX
            supportFragmentManager.commit {
                replace<ConversasFragment>(R.id.fragment_content, args = bundle)
            }
        }

        buttonChamadas.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_content, ChamadasFragment())
                .commit()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}