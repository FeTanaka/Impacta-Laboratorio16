package br.com.impacta.laboratrio16.data.local.dao

import androidx.room.*
import br.com.impacta.laboratrio16.data.models.Contato

@Dao
interface ContatoDao {

    @Insert
    suspend fun inserir(contato: Contato)

    @Update
    suspend fun atualizar(contato: Contato)

    @Delete
    suspend fun deletar(contato: Contato)

    @Query("SELECT * FROM contato")
    suspend fun pegarTodosContatos(): List<Contato>

    @Query("SELECT * FROM Contato WHERE id = :id")
    suspend fun pegarContato(id: Int): Contato

}