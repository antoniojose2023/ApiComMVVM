package com.example.apicommvvm.data.repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.apicommvvm.data.api.JsonPlaceHolderApi
import com.example.apicommvvm.data.api.RetrofitService
import com.example.apicommvvm.data.model.Postagem
import retrofit2.Response

import java.lang.Exception

class PostagemRepository(private val jsonPlaceHolderApi: JsonPlaceHolderApi) {

     var liveData = MutableLiveData<List<Postagem>>()

     @SuppressLint("SuspiciousIndentation")
     suspend fun recuperarPostagens(){
         var retorno : Response<List<Postagem>>? = null

            try{
                retorno = jsonPlaceHolderApi.getPostagens()
                if(retorno.isSuccessful){
                    val list = retorno.body()
                    list?.let {
                          liveData.postValue(it)
                    }
                }
            }catch (ex: Exception){
                println("Erro ${ex.message}")
            }
     }

}