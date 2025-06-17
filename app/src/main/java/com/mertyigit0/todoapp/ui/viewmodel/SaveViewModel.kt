package com.mertyigit0.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mertyigit0.todoapp.data.repo.ToDosRepository

class SaveViewModel: ViewModel(){
    var toDosRepository = ToDosRepository()
}