package pk.team.inlab.app.todo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import pk.team.inlab.app.todo.data.converter.TypeConverter
import pk.team.inlab.app.todo.data.dao.ToDoDao
import pk.team.inlab.app.todo.data.model.ToDoData
import pk.team.inlab.app.todo.util.Util
import pk.team.inlab.app.todo.util.Util.Companion.TO_DO_DATA_NAME

@Database(entities = [ToDoData::class], version = 1, exportSchema = false)
@TypeConverters(value = [TypeConverter::class])
abstract class ToDoDatabase(): RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

    companion object{

        @Volatile
        private var INSTANCE: ToDoDatabase? = null

        fun getDatabase(context: Context): ToDoDatabase{
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ToDoDatabase::class.java,
                        TO_DO_DATA_NAME
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }

}