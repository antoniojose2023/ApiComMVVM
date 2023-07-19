package com.example.apicommvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.apicommvvm.data.model.Postagem

interface IPostagemRepository {
    var liveData : MutableLiveData<List<Postagem>>
    suspend fun recuperarPostagens()
}