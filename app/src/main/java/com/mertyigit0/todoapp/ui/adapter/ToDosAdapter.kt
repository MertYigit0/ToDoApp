package com.mertyigit0.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mertyigit0.todoapp.data.entity.ToDos
import com.mertyigit0.todoapp.databinding.CardDesignBinding
import com.mertyigit0.todoapp.ui.MainScreenFragmentDirections

class ToDosAdapter(var mcontext: Context, var toDosList: List<ToDos>):RecyclerView.Adapter<ToDosAdapter.ViewHolder>() {
    inner class ViewHolder(binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val design = CardDesignBinding.inflate(LayoutInflater.from(mcontext),parent,false)
        return ViewHolder(design)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val toDo = toDosList[position]
        val design = CardDesignBinding.bind(holder.itemView)
        design.imageViewToDo.setImageResource(
            mcontext.resources.getIdentifier(toDo.image,"drawable",mcontext.packageName)
        )
        design.textViewName.text= toDo.name

        design.cardViewToDo.setOnClickListener {
            val direction = MainScreenFragmentDirections.actionMainScreenFragmentToUpdateScreenFragment(toDo=toDo)
            it.findNavController().navigate(direction)
        }
        design.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${toDo.name} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    deleteItem(position)
                    Snackbar.make(it,"${toDo.name} silindi", Snackbar.LENGTH_SHORT).show()
                }.show()

        }


    }
    override fun getItemCount(): Int {
        return toDosList.size
    }

    fun deleteItem(position: Int) {
        toDosList.drop(position)
    }

}