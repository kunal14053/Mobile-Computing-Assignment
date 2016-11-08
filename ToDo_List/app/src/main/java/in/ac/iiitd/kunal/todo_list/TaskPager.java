package in.ac.iiitd.kunal.todo_list;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class TaskPager extends AppCompatActivity {

    private static final String EXTRA_Task_ID = "id";

    private ViewPager mViewPager;
    private List<Task> mTasks;

    public static Intent newIntent(Context packageContext, UUID taskId) {
        Intent intent = new Intent(packageContext, TaskPager.class);
        intent.putExtra(EXTRA_Task_ID, taskId);
        return intent;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_pager);

        UUID TaskId = (UUID) getIntent().getSerializableExtra(EXTRA_Task_ID);
        mViewPager = (ViewPager) findViewById(R.id.activity_task_pager_view_pager);
        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mTasks = TaskLab.get(this).getTasks();
        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Task task = mTasks.get(position);
                return TaskFragments.newInstance(task.getmId());
            }

            @Override
            public int getCount() {
                return mTasks.size();
            }
        });

        for (int i = 0; i < mTasks.size(); i++) {
            if (mTasks.get(i).getmId().equals(TaskId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }
}
