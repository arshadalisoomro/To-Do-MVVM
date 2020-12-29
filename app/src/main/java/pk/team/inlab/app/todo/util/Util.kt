package pk.team.inlab.app.todo.util

import android.text.TextUtils
import com.google.android.material.textfield.TextInputEditText
import pk.team.inlab.app.todo.data.model.Priority

class Util {
    companion object{
        const val TO_DO_DATA_NAME = "to_do_db"
        const val TO_DO_TABLE_NAME = "to_do"
        const val PRIORITY_HIGH = "High Priority"
        const val PRIORITY_MEDIUM = "Medium Priority"
        const val PRIORITY_LOW = "Low Priority"

        fun parePriorityObject(string: String): Priority {
            return when(string){
                PRIORITY_HIGH -> {Priority.HIGH}
                PRIORITY_MEDIUM -> {Priority.MEDIUM}
                PRIORITY_LOW -> {Priority.LOW}
                else -> {Priority.LOW}
            }
        }
        
    }
}