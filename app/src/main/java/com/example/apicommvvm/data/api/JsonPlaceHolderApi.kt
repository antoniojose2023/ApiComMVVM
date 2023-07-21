package com.example.apicommvvm.data.api

import com.example.apicommvvm.data.model.PostagemResposta
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceHolderApi {

   @GET("posts")
   suspend fun getPostagens(): Response<List<PostagemResposta>>
}