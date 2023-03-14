package com.example.adv160420043week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import org.w3c.dom.Text

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
        val txtScoreAkhir = view.findViewById<TextView>(R.id.txtScoreAkhir)

        if (arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            val score = GameFragmentArgs.fromBundle(requireArguments()).scorePlayer
            txtTurn.text = "$playerName"
            txtScoreAkhir.text = "$score"
        }

        val btnBack = view.findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}