package in.ac.iiitd.kunal.todo_list;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;


public class TaskFragments extends Fragment {
    private static final String ARG_TASK_ID = "task_id";

    private Task mTask;
    private EditText mTitleField;
    private EditText mDescriptionField;
    private DatabaseHandler db;

    public static TaskFragments newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_TASK_ID, crimeId);
        TaskFragments fragment = new TaskFragments();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID taskId = (UUID) getArguments().getSerializable(ARG_TASK_ID);
        mTask = TaskLab.get(getActivity()).getTask(taskId);
        db = new DatabaseHandler(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_task_fragments, container, false);

        mTitleField = (EditText) v.findViewById(R.id.task_title);
        mDescriptionField=(EditText)v.findViewById(R.id.task_description);

        mTitleField.setText(mTask.getmTitle());

        mDescriptionField.setText(mTask.getmDescription());

        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTask.setmTitle(s.toString());
                db.updateInfo(mTask.getmId().toString(),mTask);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        mDescriptionField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTask.setmDescription(s.toString());
                db.updateInfo(mTask.getmId().toString(),mTask);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }
}
