package com.udhipe.pokemontcglist.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val BASE_URL = "https://api.pokemontcg.io/v1/"

    private val mClient = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val POKEMON_TCG_SERVICE: PokemonTcgService = mClient.create(PokemonTcgService::class.java)
}