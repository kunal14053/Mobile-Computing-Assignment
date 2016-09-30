package in.ac.iiitd.kunal.expresso;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Save extends AppCompatActivity {

    //Put the data in files
    private Button Save;
    private EditText Write;
    private int way;
    private String out;
    private String filename;
    FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);


        Write = (EditText) findViewById(R.id.write);
        out = Write.getText().toString();

        Save = (Button) findViewById(R.id.submit);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                way = getIntent().getIntExtra(Express.TAG, 0);

                //Internal only public
                //External both private(deleted) and public(remain)

                    if(way==0) {
                        Toast.makeText(getApplicationContext(), "SORRY", Toast.LENGTH_SHORT).show();
                    }
                     else if(way==1) {
                        //General
                        //External Private
                        //Internal Public
                        filename="General";
                        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
                                Toast.makeText(getApplicationContext(),"External",Toast.LENGTH_LONG).show();
                            try {
                                File file=getPrivateStorageDir(filename);
                                if(file.exists())
                                {
                                    outputStream = new FileOutputStream(file,true);
                                    outputStream.write(out.getBytes());
                                    outputStream.close();
                                }
                                else {
                                    outputStream = new FileOutputStream(file,false);
                                    outputStream.write(out.getBytes());
                                    outputStream.close();
                                }
                                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else
                        {
                            if(fileExistance(filename))
                            {
                                try {
                                    outputStream = new FileOutputStream(filename,true);
                                    outputStream.write(out.getBytes());
                                    outputStream.close();
                                    Toast.makeText(getApplicationContext(), "Appended & Saved", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                try {
                                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                                    outputStream.write(out.getBytes());
                                    outputStream.close();
                                    Toast.makeText(getApplicationContext(), "Created & Saved", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                    else if(way==2) {
                        //Memorable
                        //External Public
                        //Internal Private
                        filename="Memorable";
                        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
                            Toast.makeText(getApplicationContext(),"External",Toast.LENGTH_LONG).show();
                                try {
                                    File file=getPublicStorageDir(filename);
                                    if(file.exists())
                                    {
                                        outputStream = new FileOutputStream(file,true);
                                        outputStream.write(out.getBytes());
                                        outputStream.close();
                                    }
                                    else {
                                        outputStream = new FileOutputStream(file,false);
                                        outputStream.write(out.getBytes());
                                        outputStream.close();
                                    }
                                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
                                }


                        }
                        else
                        {

                            if(fileExistance(filename))
                            {
                                try {
                                    outputStream = new FileOutputStream(filename,true);
                                    outputStream.write(out.getBytes());
                                    outputStream.close();
                                    Toast.makeText(getApplicationContext(), "Appended & Saved", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                try {
                                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                                    outputStream.write(out.getBytes());
                                    outputStream.close();
                                    Toast.makeText(getApplicationContext(), "Created & Saved", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    Toast.makeText(getApplicationContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                    else {
                        //Personal
                        //Internal Private
                        filename="Personal";
                        if(fileExistance(filename))
                        {
                            try {
                                outputStream = new FileOutputStream(filename,true);
                                outputStream.write(out.getBytes());
                                outputStream.close();
                                Toast.makeText(getApplicationContext(), "Appended & Saved", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            try {
                                outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                                outputStream.write(out.getBytes());
                                outputStream.close();
                                Toast.makeText(getApplicationContext(), "Created & Saved", Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                Intent i = new Intent(Save.this, Express.class);
                startActivity(i);
                Write.setText("");
                finish();
            }});

    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    public File getPublicStorageDir(String albumName) {
        File file= new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOCUMENTS), albumName);
        if (!file.mkdirs()) {
            Toast.makeText(getApplicationContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
        }
        return file;
    }

    public File getPrivateStorageDir(String albumName) {
        File file= new File(getApplicationContext().getExternalFilesDir(
                Environment.DIRECTORY_DOCUMENTS), albumName);
        if (!file.mkdirs()) {
            Toast.makeText(getApplicationContext(), "ERROR!!", Toast.LENGTH_SHORT).show();
        }
        return file;
    }


    public boolean fileExistance(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }


}

