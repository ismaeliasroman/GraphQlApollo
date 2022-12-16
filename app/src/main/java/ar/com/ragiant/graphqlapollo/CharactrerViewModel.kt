package ar.com.ragiant.graphqlapollo

import CharacterListQuery
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactrerViewModel @Inject constructor(
    private val repository: CharacterRepository
):ViewModel() {
    private val _characterList by lazy { MutableLiveData<ViewState<Response<CharacterListQuery.Data>>>() }
    val characterList: LiveData<ViewState<Response<CharacterListQuery.Data>>>
    get() = _characterList

    fun queryCharacterList()= viewModelScope.launch{
        _characterList.postValue(ViewState.Loading())
        try{
            val response= repository.getCharacters()
            _characterList.postValue(ViewState.Succes(response))
        } catch (e:ApolloException){
            Log.d("ApolloException","Failure",e)
            _characterList.postValue(ViewState.Error("Error fetching characters"))
        }
    }
}