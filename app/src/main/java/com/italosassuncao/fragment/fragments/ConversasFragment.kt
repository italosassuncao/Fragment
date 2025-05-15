package com.italosassuncao.fragment.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.italosassuncao.fragment.R

//class ConversasFragment : Fragment(R.layout.fragment_conversas) { ** Quando não há alterações
class ConversasFragment : Fragment(R.layout.fragment_conversas) {

    private lateinit var buttonExecutar: Button
    private lateinit var textNome: TextView
    private lateinit var textCategoria: TextView
    private lateinit var editNome: EditText

    private var categoria: String? = null
    private var usuario: String? = null

    //ciclo de vida do fragment

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("ciclo_vida", "Fragment onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ciclo_vida", "Fragment onCreate")
        categoria = arguments?.getString("categoria")
        usuario = arguments?.getString("usuario")
    }

    // No fragment é necessário construir e retornar a view manualmente, diferente da activity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("ciclo_vida", "Fragment onCreateView") // Construção da View
        val view = inflater.inflate(
            R.layout.fragment_conversas,
            container,
            false
        )

        buttonExecutar = view?.findViewById(R.id.buttonExecutar) ?: Button(requireContext())
        textNome = view?.findViewById(R.id.textNome) ?: TextView(requireContext())
        editNome = view?.findViewById(R.id.editNome) ?: EditText(requireContext())
        textCategoria = view?.findViewById(R.id.textCategoria) ?: TextView(requireContext())

        textCategoria.text = categoria
        textNome.text = usuario

        buttonExecutar.setOnClickListener {
            textNome.text = editNome.text.toString()
        }

        return view // Retorno da view
    }

    /* Depreciado
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("ciclo_vida", "Fragment onActivityCreated")
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("ciclo_vida", "Fragment onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo_vida", "Fragment onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo_vida", "Fragment onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo_vida", "Fragment onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo_vida", "Fragment onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("ciclo_vida", "Fragment onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo_vida", "Fragment onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("ciclo_vida", "Fragment onDetach")
    }
}