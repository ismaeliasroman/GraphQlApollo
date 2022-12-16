package ar.com.ragiant.graphqlapollo

import CharacterListQuery
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.await
import javax.inject.Inject

class CharacterRepoImplement @Inject constructor(
    private val charactersApi: RockAndMortiApi
): CharacterRepository {
    override suspend fun getCharacters(): Response<CharacterListQuery.Data> {
        return charactersApi.getApolloClient().query(CharacterListQuery()).await()
    }
}