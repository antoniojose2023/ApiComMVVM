package com.example.apicommvvm.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apicommvvm.data.repository.IPostagemRepository
import com.example.apicommvvm.data.repository.PostagemRepository
import com.example.apicommvvm.domain.usecase.PostagemUseCase

class PostagemViewModelFactory(private val useCase: PostagemUseCase): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if(modelClass.isAssignableFrom(PostagemViewModel::class.java)){
                PostagemViewModel(useCase) as T
        }else{
               throw IllegalArgumentException("A classe de viewmodel que você esta passando é invalida")
        }
    }
}