package com.example.apicommvvm.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicommvvm.data.model.Postagem
import com.example.apicommvvm.data.repository.PostagemRepository
import kotlinx.coroutines.launch

class PostagemViewModel(private val postagemRepository: PostagemRepository): ViewModel() {

    val liveData : LiveData<List<Postagem>>
        get() = postagemRepository.liveData

//    init {
//        exibirPostagens()
//    }

    fun exibirPostagens(){
           viewModelScope.launch {
               postagemRepository.recuperarPostagens()
           }
    }

}