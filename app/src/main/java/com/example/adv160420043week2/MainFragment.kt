package com.example.adv160420043week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // DECLARATION OBJECT
        val btnStart = view.findViewById<Button>(R.id.btnStart)
        val txtName = view.findViewById<TextInputEditText>(R.id.txtName)

        btnStart.setOnClickListener {
            val namaPemain = txtName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(namaPemain)
            Navigation.findNavController(it).navigate(action)
        }
    }

}