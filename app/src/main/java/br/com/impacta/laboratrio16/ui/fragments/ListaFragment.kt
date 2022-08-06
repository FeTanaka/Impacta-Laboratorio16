package br.com.impacta.laboratrio16.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import br.com.impacta.laboratrio16.R
import br.com.impacta.laboratrio16.ui.activity.MainActivity
import br.com.impacta.laboratrio16.ui.view_model.ViewModel
import br.com.impacta.laboratrio16.ui.view_model.ViewModelFactory


class ListaFragment : Fragment() {

    private val viewModel: ViewModel by activityViewModels{
        ViewModelFactory((activity as MainActivity).db)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }


}