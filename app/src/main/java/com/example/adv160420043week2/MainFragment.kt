package com.example.adv160420043week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

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
        val btnStart = view.findViewById<Button>(R.id.btnStart)
        var number1 = (0..100).random()
        var number2 = (0..100).random()
        var jumlah = number1+number2
        var score = 0
        val txtNumber = view.findViewById<TextView>(R.id.txtNumber)
        txtNumber.text = number1.toString() + " + " + number2.toString()

        btnStart.setOnClickListener {
            val txtName = view.findViewById<TextInputEditText>(R.id.txtName)
            val jawaban = Integer.parseInt(txtName.text.toString())

            if (jumlah == jawaban) {
                number1 = (0..100).random()
                number2 = (0..100).random()
                jumlah = number1+number2
                txtNumber.text = number1.toString() + " + " + number2.toString()
                score = score + 1
            } else {
                val pesan = "GAME OVER"
                val action = MainFragmentDirections.actionGameFragment(pesan, score.toString())
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

}