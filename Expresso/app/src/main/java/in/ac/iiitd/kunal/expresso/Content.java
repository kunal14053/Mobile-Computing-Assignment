package in.ac.iiitd.kunal.expresso;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Content extends AppCompatActivity {

    TextView content;
    FileInputStream inputstream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        content=(TextView)findViewById(R.id.content_provide);
        int k=getIntent().getIntExtra("Type",-1);

        //odd internal
        //even external

        if(k==1)
        {
            Toast.makeText(getApplicationContext(),"INTERNAL GENERAL",Toast.LENGTH_LONG);
            try {
                inputstream=openFileInput("General");
                InputStreamReader isr = new InputStreamReader(inputstream);
                BufferedReader bufferedReader = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                content.setText(sb);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(k==2)
        {
            content.setText("external");
        }
        else if(k==3)
        {
            Toast.makeText(getApplicationContext(),"INTERN MEMORABLE",Toast.LENGTH_LONG);
            try {
                inputstream=openFileInput("Memorable");
                InputStreamReader isr = new InputStreamReader(inputstream);
                BufferedReader bufferedReader = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                content.setText(sb);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else if(k==4)
        {
            content.setText("external");
        }
        else if(k==5)
        {
            Toast.makeText(getApplicationContext(),"INTERN PERSONAL",Toast.LENGTH_LONG);
            try {
                inputstream=openFileInput("Personal");
                InputStreamReader isr = new InputStreamReader(inputstream);
                BufferedReader bufferedReader = new BufferedReader(isr);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                content.setText(sb);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(k==6)
        {
            content.setText("external");
        }
        else
        {
            Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();
        }

    }
}
