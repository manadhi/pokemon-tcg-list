package com.udhipe.pokemontcglist.datastore.set

import com.udhipe.pokemontcglist.model.PokemonSet

interface PokemonSetDataStore {
    suspend fun getSet(): MutableList<PokemonSet>?
    suspend fun addAll(set: MutableList<PokemonSet>?)
}