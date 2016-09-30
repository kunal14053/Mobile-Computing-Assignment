package in.ac.iiitd.kunal.expresso;


import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class Save extends AppCompatActivity {


    private Button Save;
    private EditText Write;
    private int way;
    private String out;
    private String filename;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        Write = (EditText) findViewById(R.id.write);

        way = getIntent().getIntExtra(Express.TAG, 0);

        Save = (Button) findViewById(R.id.submit);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out = Write.getText().toString();
                    if(way==0) {
                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                    }
                     else if(way==1) {
                        //General External Private Internal Public

                        filename="General";
                        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
                                File folder=getPrivateStorageDir(filename);
                                File file = new File (folder, "Data");
                                FileOutputStream fout=null;
                                if(file.exists())
                                {
                                    try {
                                        fout = new FileOutputStream(file,true);
                                        fout.write(out.getBytes());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                else
                                {
                                    try {
                                        fout = new FileOutputStream(file,false);
                                        fout.write(out.getBytes());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                        }
                        else
                        {
                            FileOutputStream fOut = null;
                            if(fileExistance(filename))
                            {
                                try {
                                    fOut = openFileOutput(filename,MODE_APPEND);
                                    fOut.write(out.getBytes());
                                    fOut.close();
                                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            else
                            {
                                try {
                                    fOut = openFileOutput(filename,MODE_PRIVATE);
                                    fOut.write(out.getBytes());
                                    fOut.close();
                                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    else if(way==2) {
                        //Memorable External Public Internal Private

                        filename="Memorable";
                        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
                            File folder=getPublicStorageDir(filename);
                            File file = new File (folder, "Data");
                            FileOutputStream fout=null;
                            if(file.exists())
                            {
                                try {
                                    fout = new FileOutputStream(file,true);
                                    fout.write(out.getBytes());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            else
                            {
                                try {
                                    fout = new FileOutputStream(file,false);
                                    fout.write(out.getBytes());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                        else {
                            FileOutputStream fOut = null;
                            if (fileExistance(filename)) {
                                try {
                                    fOut = openFileOutput(filename, MODE_APPEND);
                                    fOut.write(out.getBytes());
                                    fOut.close();
                                    Toast.makeText(getBaseContext(), "file saved", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                try {
                                    fOut = openFileOutput(filename, MODE_PRIVATE);
                                    fOut.write(out.getBytes());
                                    fOut.close();
                                    Toast.makeText(getBaseContext(), "file saved", Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    else {
                        //Personal Internal Private

                        filename="Personal";
                        FileOutputStream fOut = null;
                        if(fileExistance(filename))
                        {
                            try {
                                fOut = openFileOutput(filename,MODE_APPEND);
                                fOut.write(out.getBytes());
                                fOut.close();
                                Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            try {
                                fOut = openFileOutput(filename,MODE_PRIVATE);
                                fOut.write(out.getBytes());
                                fOut.close();
                                Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

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

