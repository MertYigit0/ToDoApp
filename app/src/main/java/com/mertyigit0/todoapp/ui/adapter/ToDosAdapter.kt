package com.mertyigit0.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mertyigit0.todoapp.data.entity.ToDos
import com.mertyigit0.todoapp.databinding.CardDesignBinding

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


    }
    override fun getItemCount(): Int {
        return toDosList.size
    }

}