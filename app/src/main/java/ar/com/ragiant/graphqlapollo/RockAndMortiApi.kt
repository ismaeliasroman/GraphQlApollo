package ar.com.ragiant.graphqlapollo

import android.os.Looper
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class RockAndMortiApi {
    fun getApolloClient(): ApolloClient{
        check(Looper.myLooper() == Looper.getMainLooper()){
        }
        val okHttpClient = OkHttpClient.Builder().build()
        return ApolloClient.builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .okHttpClient(okHttpClient)
            .build()
    }
}