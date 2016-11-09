package in.ac.iiitd.kunal.todo_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class todo_fragment extends Fragment {


    RecyclerView mRecyclerView;
    private TaskAdapter mAdapter;
    DatabaseHandler db;

    @Override
    public void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.activity_todo_fragment, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.todo_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
    {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.task_list_menu,menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.menu_item_new_task:
                Task task =  new Task();
                TaskLab.get(getActivity()).addTask(task);
                Intent intent=TaskPager.newIntent(getActivity(),task.getmId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }


        private void updateUI() {

        TaskLab taskLab = TaskLab.get(getActivity());
        List<Task> tasks = taskLab.getTasks();



         if (mAdapter == null) {
            mAdapter = new TaskAdapter(tasks);
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }


    private class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mTitleTextView;

        private Task mTask;

        public TaskHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView=(TextView)itemView.findViewById(R.id.TextView_List);
        }

        public void bindTask(Task task) {
            mTask = task;
            mTitleTextView.setText(mTask.getmTitle());
        }

        @Override
        public void onClick(View view) {
            Intent intent = TaskPager.newIntent(getActivity(), mTask.getmId());
            startActivity(intent);
        }
    }


    public class TaskAdapter extends RecyclerView.Adapter<TaskHolder>
    {

        private List<Task> mTasks;

        TaskAdapter(List<Task> tasks)
        {
            mTasks=tasks;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
//Change here
            View view = layoutInflater.inflate(R.layout.list_item, parent, false);

            return new TaskHolder(view);
        }



        @Override
        public void onBindViewHolder(TaskHolder holder, int position) {
            Task task= mTasks.get(position);
            holder.bindTask(task);
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }


    }



}
