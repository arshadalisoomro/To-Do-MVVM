package pk.team.inlab.app.todo.ui.fragments.add

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

class AddViewModel(application: Application): AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val toDoRepository: ToDoRepository

    init {
        toDoRepository = ToDoRepository(toDoDao)
    }

    fun insertToDo(toDoData: ToDoData) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoRepository.insert(toDoData)
        }
    }

}