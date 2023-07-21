package com.example.apicommvvm.presenter.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.apicommvvm.data.api.JsonPlaceHolderApi
import com.example.apicommvvm.data.api.RetrofitService
import com.example.apicommvvm.data.repository.PostagemRepository
import com.example.apicommvvm.databinding.ActivityMainBinding
import com.example.apicommvvm.domain.usecase.PostagemUseCase
import com.example.apicommvvm.presenter.viewmodel.PostagemViewModel
import com.example.apicommvvm.presenter.viewmodel.PostagemViewModelFactory

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var postagemViewModel : PostagemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val jsonPlaceHolderApi = RetrofitService.retrofit
        val repository = PostagemRepository(jsonPlaceHolderApi)
        val useCase = PostagemUseCase(repository)

        postagemViewModel = ViewModelProvider(this, PostagemViewModelFactory(useCase))[PostagemViewModel::class.java]

        postagemViewModel.liveData?.observe(this){ postagens ->
            var resultado = ""
            postagens.forEach { post ->
                resultado += "${post.titulo} \n"
            }

            binding.tvResultado.text = resultado
        }

    }

    override fun onStart() {
        postagemViewModel.exibirPostagens()
        super.onStart()
    }
}