package pk.team.inlab.app.todo.ui.fragments.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pk.team.inlab.app.todo.data.ToDoDatabase
import pk.team.inlab.app.todo.data.model.ToDoData
import pk.team.inlab.app.todo.data.repository.ToDoRepository

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val toDoRepository: ToDoRepository

    // get all ToDos
    private val getAllToDos: LiveData<List<ToDoData>>

    init {
        toDoRepository = ToDoRepository(toDoDao)
        getAllToDos = toDoRepository.getAllFlow.asLiveData()
    }
}