package ar.com.ragiant.graphqlapollo

import CharacterListQuery
import okhttp3.Response

interface CharacterRepository {
    suspend fun getCharacters():com.apollographql.apollo.api.Response<CharacterListQuery.Characters>
}