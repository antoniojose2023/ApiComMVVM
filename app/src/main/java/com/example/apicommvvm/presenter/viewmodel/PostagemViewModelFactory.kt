package com.example.apicommvvm.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apicommvvm.data.repository.IPostagemRepository
import com.example.apicommvvm.data.repository.PostagemRepository

class PostagemViewModelFactory(private val repository: IPostagemRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(PostagemViewModel::class.java)){
                PostagemViewModel(repository) as T
        }else{
               throw IllegalArgumentException("A classe de viewmodel que você esta passando é invalida")
        }
    }
}