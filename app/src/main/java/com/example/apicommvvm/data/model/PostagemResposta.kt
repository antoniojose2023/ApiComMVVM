package com.example.apicommvvm.data.model

import com.example.apicommvvm.data.repository.PostagemRepository
import com.example.apicommvvm.domain.models.Postagem

data class PostagemResposta(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)
fun PostagemResposta.toPostagem(): Postagem{
      return Postagem(
                    conteudo = this.body,
                    idPostagem = this.id,
                    idUsuario = this.userId,
                    titulo = this.title
               )
}
