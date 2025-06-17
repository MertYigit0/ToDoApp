package com.mertyigit0.todoapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mertyigit0.todoapp.R
import com.mertyigit0.todoapp.databinding.FragmentUpdateScreenBinding


class UpdateScreenFragment : Fragment() {

    private var _binding: FragmentUpdateScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle: UpdateScreenFragmentArgs by navArgs()
        val toDo = bundle.toDo
        binding.imageView.setImageResource(
            resources.getIdentifier(toDo.image, "drawable", requireContext().packageName)
        )
        binding.editTextName.setText(toDo.name)

        binding.buttonUpdate.setOnClickListener {
          val name = binding.editTextName.text.toString()
            updateToDo(toDo.id,name)
        }

    }


    fun updateToDo(id : Int,name : String) {
        Log.e("UpdateScreenFragment"," $id $name")

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}