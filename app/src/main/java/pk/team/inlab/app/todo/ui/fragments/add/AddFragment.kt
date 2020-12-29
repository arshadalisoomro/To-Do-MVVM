package pk.team.inlab.app.todo.ui.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText
import pk.team.inlab.app.todo.R
import pk.team.inlab.app.todo.data.model.ToDoData
import pk.team.inlab.app.todo.util.Util
import pk.team.inlab.app.todo.util.Util.Companion.PRIORITY_HIGH
import pk.team.inlab.app.todo.util.Util.Companion.PRIORITY_LOW
import pk.team.inlab.app.todo.util.Util.Companion.PRIORITY_MEDIUM
import pk.team.inlab.app.todo.util.Util.Companion.parePriorityObject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddFragment : Fragment() {

    // ViewModel object
    private val mAddViewModel: AddViewModel by viewModels()

    private lateinit var mTitleTextInput: TextInputEditText
    private lateinit var mPriorityTextInput: MaterialAutoCompleteTextView
    private lateinit var mDescriptionTextInput: TextInputEditText
    private lateinit var mSaveToDoButton: MaterialButton

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Init views
        mTitleTextInput = view.findViewById(R.id.tiet_note_title)
        mPriorityTextInput = view.findViewById(R.id.tiet_note_priority)
        mDescriptionTextInput = view.findViewById(R.id.tiet_note_description)
        mSaveToDoButton = view.findViewById(R.id.mbtn_save_todo)

        // Set items to DropDown list
        val items = listOf(PRIORITY_HIGH, PRIORITY_MEDIUM, PRIORITY_LOW)
        val adapter = ArrayAdapter(requireContext(), R.layout.item_priority_list, items)
        mPriorityTextInput.setAdapter(adapter)

        mSaveToDoButton.setOnClickListener {
            when {
                insertToDoInDatabase() -> {
                    findNavController().navigate(R.id.action_AddFragment_to_ListFragment)
                    Toast.makeText(requireContext(), "Record saved!", LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun insertToDoInDatabase(): Boolean {
        val title = mTitleTextInput.text.toString()
        val priority = mPriorityTextInput.text.toString()
        val description = mDescriptionTextInput.text.toString()

        when {
            TextUtils.isEmpty(title) -> {
                mTitleTextInput.error = "Title must not be empty"
                return false
            }
            TextUtils.isEmpty(description) -> {
                mDescriptionTextInput.error = "Description must not be empty"
                return false
            }
            else -> {
                // Insert in to Database
                val newToDoData = ToDoData(
                        id = 0,
                        title = title,
                        description = description,
                        priority = parePriorityObject(priority)
                )

                // call view model insert function
                mAddViewModel.insertToDo(newToDoData)
                return true
            }
        }
    }


}