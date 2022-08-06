package br.com.impacta.laboratrio16.data.local.repository

import br.com.impacta.laboratrio16.data.local.database.AppDatabase
import br.com.impacta.laboratrio16.data.models.Contato

class ContatoRepository(private val appDatabase: AppDatabase) {

    private val contatoDao = appDatabase.contatoDao()

    suspend fun inserir(contato: Contato) {
        contatoDao.inserir(contato)
    }

    suspend fun atualizar(contato: Contato) {
        contatoDao.atualizar(contato)
    }

    suspend fun deletar(contato: Contato) {
        contatoDao.deletar(contato)
    }

    suspend fun pegarTodosContatos(): List<Contato> {
        return contatoDao.pegarTodosContatos()
    }

    suspend fun pegarContato(id: Int): Contato {
        return contatoDao.pegarContato(id)
    }

}