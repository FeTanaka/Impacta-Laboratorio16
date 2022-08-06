package br.com.impacta.laboratrio16.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contato(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var nome: String,
    var telefone: String,
    var idade: Int
) {
    fun getIdadeString() = this.idade.toString()
}
