package com.example.apicommvvm.domain.usecase

import android.util.Log
import com.example.apicommvvm.data.repository.IPostagemRepository
import com.example.apicommvvm.data.repository.PostagemRepository
import com.example.apicommvvm.domain.models.Postagem
import java.lang.Exception

class PostagemUseCase(private val respository: IPostagemRepository) {

    suspend operator fun invoke(): List<Postagem>{
        try{
            return respository.recuperarPostagens()
        }catch (ex: Exception){
            Log.i("ERRO", "recuperarPostagens: "+ex.message)
        }

        return emptyList()
    }

}