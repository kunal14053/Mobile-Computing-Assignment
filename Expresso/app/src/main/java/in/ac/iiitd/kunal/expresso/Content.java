package in.ac.iiitd.kunal.expresso;


import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Content extends AppCompatActivity {

    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        content=(TextView)findViewById(R.id.content_provide);
        int k=getIntent().getIntExtra("Type",-1);


        if(k==1)
        {
            try{
                FileInputStream fin = openFileInput("General");
                int c;
                String temp="";
                while( (c = fin.read()) != -1){
                    temp = temp + Character.toString((char)c);
                }
                content.setText(temp);
                Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
            }
            catch(Exception e){
            }
        }
        else if(k==2)
        {
            try{
                File file= new File(getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),"General");
                String read_file=file.getAbsolutePath()+"/Data";
                FileInputStream fin = openFileInput(read_file);
                int c;
                String temp="";
                while( (c = fin.read()) != -1){
                    temp = temp + Character.toString((char)c);
                }
                content.setText(temp);
                Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
            }
            catch(Exception e){
            }
        }
        else if(k==3)
        {
            try{
                FileInputStream fin = openFileInput("Memorable");
                int c;
                String temp="";
                while( (c = fin.read()) != -1){
                    temp = temp + Character.toString((char)c);
                }
                content.setText(temp);
                Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
            }
            catch(Exception e){
            }
        }
        else if(k==4)
        {
            try{
                File file= new File(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DOCUMENTS), "Memorable");
                String read_file=file.getAbsolutePath()+"/Data";
                FileInputStream fin = openFileInput(read_file);
                int c;
                String temp="";
                while( (c = fin.read()) != -1){
                    temp = temp + Character.toString((char)c);
                }
                content.setText(temp);
                Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
            }
            catch(Exception e){
            }
        }
        else if(k==5)
        {
            try{
                FileInputStream fin = openFileInput("Personal");
                int c;
                String temp="";
                while( (c = fin.read()) != -1){
                    temp = temp + Character.toString((char)c);
                }
                content.setText(temp);
                Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
            }
            catch(Exception e){
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();
        }


    }
}
