package com.mertyigit0.todoapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mertyigit0.todoapp.R
import com.mertyigit0.todoapp.data.entity.ToDos
import com.mertyigit0.todoapp.databinding.FragmentMainScreenBinding
import com.mertyigit0.todoapp.ui.adapter.ToDosAdapter


class MainScreenFragment : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView setup
        val toDosList = ArrayList<ToDos>()
        val todo1 = ToDos(1, "spor", "agac")
        val todo2 = ToDos(2, "gunes", "gunes")
        val todo3 = ToDos(3, "roket", "roket")
        val todo4 = ToDos(4, "semsiye", "semsiye")
        toDosList.add(todo1)
        toDosList.add(todo2)
        toDosList.add(todo3)
        toDosList.add(todo4)

        val todosAdapter = ToDosAdapter(requireContext(), toDosList)
        binding.recyclerViewToDos.adapter = todosAdapter
        binding.recyclerViewToDos.layoutManager = LinearLayoutManager(requireContext())

        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
               search(newText)
                return true
            }








            override fun onQueryTextSubmit(query: String): Boolean {
               search(query)
                return true
            }

        })




        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_saveScreenFragment)
        }


    }

    fun search(searchText: String) {
        Log.e("SearchResult", "search: $searchText")
    }

    override fun onResume() {
        super.onResume()
        Snackbar.make(requireView(), "Welcome", Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
