package com.mertyigit0.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mertyigit0.todoapp.data.repo.ToDosRepository

class MainViewModel : ViewModel(){
    var toDosRepository = ToDosRepository()
}