package com.example.apicommvvm.data.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.apicommvvm.data.api.JsonPlaceHolderApi
import com.example.apicommvvm.data.model.PostagemResposta
import com.example.apicommvvm.data.model.toPostagem
import com.example.apicommvvm.domain.models.Postagem
import retrofit2.Response

import java.lang.Exception

class PostagemRepository(private val jsonPlaceHolderApi: JsonPlaceHolderApi): IPostagemRepository {

     @SuppressLint("SuspiciousIndentation")
     override suspend fun recuperarPostagens(): List<Postagem>{
         var retorno : Response<List<PostagemResposta>>? = null

            try{
                retorno = jsonPlaceHolderApi.getPostagens()
                if(retorno.isSuccessful && retorno.body() != null){
                     var listaPostagem = retorno.body()?.map { postagemResposta ->
                            postagemResposta.toPostagem()
                     }

                     if(listaPostagem != null)
                           return listaPostagem
                }
            }catch (ex: Exception){
                println("Erro ${ex.message}")
            }

            return emptyList()
     }
}