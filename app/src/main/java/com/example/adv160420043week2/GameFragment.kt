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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtTurn = view.findViewById<TextView>(R.id.txtTurn)
        val txtNumber = view.findViewById<TextView>(R.id.txtRandomNumber)
        val btnSubmit = view.findViewById<Button>(R.id.btnSubmit)
        val txtJawaban = view.findViewById<TextInputEditText>(R.id.txtJawaban)

        var number1 = (0..100).random()
        var number2 = (0..100).random()
        var jumlah = number1+number2
        var score = 0
        txtNumber.text = number1.toString() + " + " + number2.toString()

        if (arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName"
        }

        btnSubmit.setOnClickListener {
            if (txtJawaban.text.toString() != "") {
                val jawaban = Integer.parseInt(txtJawaban.text.toString())

                if (jumlah == jawaban) {
                    number1 = (0..100).random()
                    number2 = (0..100).random()
                    jumlah = number1+number2
                    txtNumber.text = number1.toString() + " + " + number2.toString()
                    score = score + 1
                } else {
                    val action = GameFragmentDirections.actionResultFragment(score.toString())
                    Navigation.findNavController(it).navigate(action)
                }
            }
        }
    }

}