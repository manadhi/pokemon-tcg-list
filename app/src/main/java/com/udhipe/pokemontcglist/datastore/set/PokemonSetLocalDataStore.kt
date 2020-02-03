package com.udhipe.pokemontcglist.datastore.set

import com.udhipe.pokemontcglist.model.PokemonSet

class PokemonSetLocalDataStore :
    PokemonSetDataStore {
    private var mCache = mutableListOf<PokemonSet>()

    override suspend fun getSet(): MutableList<PokemonSet>? =
        if (mCache.isNotEmpty()) mCache else null

    override suspend fun addAll(set: MutableList<PokemonSet>?) {
        set?.let { mCache = it }
    }
}