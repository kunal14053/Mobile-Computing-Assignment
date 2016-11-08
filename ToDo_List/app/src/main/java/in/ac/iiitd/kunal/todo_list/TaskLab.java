package in.ac.iiitd.kunal.todo_list;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by KunalSaini on 08-Nov-16.
 */
public class TaskLab {


    private static TaskLab sTaskLab;

    private ArrayList<Task> mTasks;

    public static TaskLab get(Context context) {
        if (sTaskLab == null) {
            sTaskLab = new TaskLab(context);
        }
        return sTaskLab;
    }

    public void addTask(Task c)
    {
        mTasks.add(c);
    }


    private TaskLab(Context context) {

        mTasks = new ArrayList<>();
    }

    public List<Task> getTasks() {

        return mTasks;
    }

    public Task getTask(UUID id)
    {
        for (Task task : mTasks) {
            if (task.getmId().equals(id)) {
                return task;
            }
        }
        return null;
    }

}
