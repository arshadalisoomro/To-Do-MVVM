package pk.team.inlab.app.todo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pk.team.inlab.app.todo.data.model.ToDoData

@Dao
interface ToDoDao {

    @Query("SELECT * FROM to_do ORDER BY id ASC")
    fun getAll(): Flow<List<ToDoData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(toDoData: ToDoData)
    
}