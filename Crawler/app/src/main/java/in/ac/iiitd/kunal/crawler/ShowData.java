package in.ac.iiitd.kunal.crawler;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ShowData extends AppCompatActivity {


    TextView mDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        mDisplay=(TextView)findViewById(R.id.display);
        mDisplay.setMovementMethod(new ScrollingMovementMethod());
        try{
            String read_file=getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)+"/Content/Data.txt";
            File f =new File(read_file);
            String temp="";
            String aDataRow = "";
            FileInputStream fin = new FileInputStream(f);
            BufferedReader myReader = new BufferedReader(
                    new InputStreamReader(fin));

            while ((aDataRow = myReader.readLine()) != null) {
                temp += aDataRow + "\n";
            }
            myReader.close();
            mDisplay.setText(temp);
            Toast.makeText(getApplicationContext(),"file read", Toast.LENGTH_SHORT).show();
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(),"file not read", Toast.LENGTH_LONG).show();
        }
    }
}
