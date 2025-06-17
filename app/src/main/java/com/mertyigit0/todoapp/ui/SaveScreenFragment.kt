package com.mertyigit0.todoapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mertyigit0.todoapp.databinding.FragmentSaveScreenBinding
import com.mertyigit0.todoapp.ui.viewmodel.MainViewModel
import com.mertyigit0.todoapp.ui.viewmodel.SaveViewModel
import com.mertyigit0.todoapp.ui.viewmodel.UpdateViewModel


class SaveScreenFragment : Fragment() {

    private var _binding: FragmentSaveScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: SaveViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:SaveViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSaveScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val images = listOf("agac", "gunes","gezegen","damla","semsiye","yildiz","roket")
        val image = images.random()
        binding.imageView.setImageResource(
            resources.getIdentifier(image, "drawable", requireContext().packageName)
        )
        binding.buttonSave.setOnClickListener {
           binding.editTextName.text.toString().let {
               saveTask(it,image)
           }
        }
    }

    fun saveTask(name:String,image:String) {
        Log.e("SaveScreenFragment", "saveTask: $name -$image))", )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}