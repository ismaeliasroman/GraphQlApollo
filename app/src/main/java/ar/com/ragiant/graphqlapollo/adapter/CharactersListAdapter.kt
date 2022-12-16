package ar.com.ragiant.graphqlapollo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.ragiant.graphqlapollo.databinding.RowCharacterBinding

class CharacterAdapter constructor(
    private var dataSet:ArrayList<ar.com.ragiant.graphqlapollo.Character>
): RecyclerView.Adapter<CharacterAdapter.ViewHolder>(){
    class ViewHolder constructor(
        val binding: RowCharacterBinding
    ):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding= RowCharacterBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val character = dataSet[position]
        viewHolder.binding.tvId.text=character.id.toString()
        viewHolder.binding.tvNombre.text= character.name
        viewHolder.binding.tvEspecie.text= character.specie
    }

    fun addCharacter(character: ar.com.ragiant.graphqlapollo.Character){
        dataSet.add(character)
        notifyItemInserted(dataSet.size-1)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}