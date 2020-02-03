package com.udhipe.pokemontcglist.repository

import com.udhipe.pokemontcglist.datastore.set.PokemonSetDataStore
import com.udhipe.pokemontcglist.datastore.set.PokemonSetLocalDataStore
import com.udhipe.pokemontcglist.datastore.set.PokemonSetRemoteDataStore
import com.udhipe.pokemontcglist.model.PokemonSet

class PokemonSetRepository private constructor() {
    private var setLocalDataStore: PokemonSetDataStore? = null
    private var setRemoteDataStore: PokemonSetDataStore? = null

    fun init(
        setLocalDataStore: PokemonSetLocalDataStore,
        setRemoteDataStore: PokemonSetRemoteDataStore
    ) {
        this.setLocalDataStore = setLocalDataStore
        this.setRemoteDataStore = setRemoteDataStore
    }

    suspend fun getSet(): MutableList<PokemonSet>? {
        val cache = setLocalDataStore?.getSet()
        if (cache != null) return cache
        val reseponse = setRemoteDataStore?.getSet()
        setLocalDataStore?.addAll(reseponse)
        return reseponse
    }

    companion object {
        val instance by lazy { PokemonSetRepository }
    }
}