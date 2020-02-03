package com.udhipe.pokemontcglist.datastore.set

import com.udhipe.pokemontcglist.model.PokemonSet
import com.udhipe.pokemontcglist.webservice.PokemonTcgService

class PokemonSetRemoteDataStore(private val mPokemonTcgService: PokemonTcgService) :
    PokemonSetDataStore {
    override suspend fun getSet(): MutableList<PokemonSet>? {
        val response = mPokemonTcgService.getSet()
        if (response.isSuccessful) return response.body()?.sets

        throw Exception("Failed to request data from web service, error : ${response.code()}")
    }

    override suspend fun addAll(set: MutableList<PokemonSet>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}