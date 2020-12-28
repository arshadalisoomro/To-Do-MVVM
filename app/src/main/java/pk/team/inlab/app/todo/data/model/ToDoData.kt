package pk.team.inlab.app.todo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import pk.team.inlab.app.todo.util.Util.Companion.TO_DO_TABLE_NAME

@Entity(tableName = TO_DO_TABLE_NAME)
data class ToDoData(
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        var title: String,
        var priority: Priority,
        var description: String
)
