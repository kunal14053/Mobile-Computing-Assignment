package in.ac.iiitd.kunal.todo_list;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new todo_fragment();
    }
}
