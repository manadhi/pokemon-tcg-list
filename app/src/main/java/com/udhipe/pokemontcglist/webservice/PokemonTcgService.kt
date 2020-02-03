package com.udhipe.pokemontcglist.webservice

import com.udhipe.pokemontcglist.model.PokemonSet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonTcgService {
//    @GET("cards")
//    suspend fun getCard(@Query("set") set: String: Response<>)

    @GET("Sets")
    suspend fun getSet(): Response<PokemonSet.PokemonSetResponse>
}