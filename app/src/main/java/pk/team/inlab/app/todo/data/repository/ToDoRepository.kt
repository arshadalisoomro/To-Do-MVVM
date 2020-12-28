package pk.team.inlab.app.todo.data.repository


import kotlinx.coroutines.flow.Flow
import pk.team.inlab.app.todo.data.dao.ToDoDao
import pk.team.inlab.app.todo.data.model.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {

    val getAll: Flow<List<ToDoData>> = toDoDao.getAll()

    suspend fun insert(toDoData: ToDoData){
        toDoDao.insert(toDoData)
    }

}