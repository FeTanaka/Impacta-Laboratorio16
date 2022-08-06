package br.com.impacta.laboratrio16.ui.view_model

import android.annotation.SuppressLint
import androidx.lifecycle.*
import androidx.lifecycle.ViewModel
import br.com.impacta.laboratrio16.data.local.database.AppDatabase
import br.com.impacta.laboratrio16.data.local.repository.ContatoRepository
import br.com.impacta.laboratrio16.data.models.Contato
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(private val appDatabase: AppDatabase): ViewModel() {

    private val repository: ContatoRepository = ContatoRepository(appDatabase)

    private var _listaContatos: MutableLiveData<List<Contato>> = MutableLiveData(listOf())
    val listaContatos: LiveData<List<Contato>> = _listaContatos

    private var _contato: MutableLiveData<Contato> = MutableLiveData(null)
    val contato: LiveData<Contato> = _contato

    fun criarContato(contato: Contato) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.inserir(contato)
        }
    }

    fun atualizarContato(contato: Contato) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.atualizar(contato)
        }
    }

    fun deletarContato(contato: Contato) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletar(contato)
        }
    }

    fun pegarTodosContatos() {
        viewModelScope.launch(Dispatchers.IO) {
            _listaContatos.postValue(repository.pegarTodosContatos())
        }
    }

    fun pegarContato(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _contato.postValue(repository.pegarContato(id))
        }
    }
}

class ViewModelFactory(private val appDatabase: AppDatabase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(br.com.impacta.laboratrio16.ui.view_model.ViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return br.com.impacta.laboratrio16.ui.view_model.ViewModel(appDatabase) as T
        }
        throw IllegalArgumentException()
    }
}