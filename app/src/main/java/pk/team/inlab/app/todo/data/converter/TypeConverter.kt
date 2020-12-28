package pk.team.inlab.app.todo.data.converter

import androidx.room.TypeConverter
import pk.team.inlab.app.todo.data.model.Priority

/**
 * The TypeConverter class is used to convert Priority enums
 * as String values so that Room Database can store those in
 * table.
 *
 * @author Arshad Ali (Team InLab Inc.)
 * @see Priority
 */
class TypeConverter {

    @TypeConverter
    fun fromPriorityToString(priority: Priority): String{
        return priority.name
    }

    @TypeConverter
    fun toPriorityFromString(priority: String): Priority {
        return Priority.valueOf(priority)
    }

}