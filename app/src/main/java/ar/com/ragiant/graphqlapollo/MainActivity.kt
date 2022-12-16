package ar.com.ragiant.graphqlapollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.ragiant.graphqlapollo.adapter.CharacterAdapter
import ar.com.ragiant.graphqlapollo.databinding.ActivityMainBinding
import com.apollographql.apollo.api.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CharactrerViewModel by viewModels()
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.characterList.observe(this){
            when(it){
                is ViewState.Succes -> {
                    it.value!!.data!!.characters!!.results!!.forEach {
                        characterAdapter.addCharacter(Character(it!!.id!!.toInt(), it.name!! ,it.species!!))
                    }
                }
                else -> {}
            }
        }
    }
    private fun initRecyclerView(){
        characterAdapter = CharacterAdapter(ArrayList())
        binding.rvEjemplo.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter
        }
    }
}