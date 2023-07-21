package com.example.apicommvvm.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.apicommvvm.data.model.PostagemResposta
import com.example.apicommvvm.domain.models.Postagem

interface IPostagemRepository {
     suspend fun recuperarPostagens(): List<Postagem>
}