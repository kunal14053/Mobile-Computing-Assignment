package in.ac.iiitd.kunal.expresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Show extends AppCompatActivity {

    TextView Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Data=(TextView)findViewById(R.id.display);
        DatabaseHandler db = new DatabaseHandler(this);
        List<Information> contacts = db.getAllInfo();
        String data="";
        for (Information cn : contacts) {
            data = data + "Id: " + cn.getId() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhone_number() + " ,College Name: " + cn.getCollege_name() + " ,College Id: " + cn.getCollege_id()
                    + " ,DOB: " + cn.getDob() + "\n";
        }

        Data.setText(data);
    }
}
