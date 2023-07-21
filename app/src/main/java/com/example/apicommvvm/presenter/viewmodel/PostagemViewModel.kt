package com.example.apicommvvm.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.apicommvvm.data.model.PostagemResposta
import com.example.apicommvvm.data.repository.IPostagemRepository
import com.example.apicommvvm.domain.models.Postagem
import com.example.apicommvvm.domain.usecase.PostagemUseCase
import kotlinx.coroutines.launch

class PostagemViewModel(private val useCase: PostagemUseCase): ViewModel() {

    private var _liveData = MutableLiveData<List<Postagem>>()
    val liveData : LiveData<List<Postagem>> = _liveData

//    init {
//        exibirPostagens()
//    }

    fun exibirPostagens(){
           viewModelScope.launch {
               val list = useCase()
               _liveData?.postValue(list)
           }


    }

}