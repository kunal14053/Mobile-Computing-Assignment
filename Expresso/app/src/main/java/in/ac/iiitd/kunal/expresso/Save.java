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


    private Button Save,Mode;
    private EditText Write;
    private int way;
    private String out;
    private String filename;
    private int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        Write = (EditText) findViewById(R.id.write);
        Mode= (Button) findViewById(R.id.mode);
        flag=1;
        way = getIntent().getIntExtra(Express.TAG, 0);

        if(way==3)
            Mode.setVisibility(View.GONE);

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
                        if (isExternalStorageAvailable() && flag!=0) {
                                File folder=getPrivateStorageDir(filename);
                                File file = new File (folder, "Data.txt");
                                FileOutputStream fout=null;
                                if(file.exists())
                                {
                                    try {
                                        fout = new FileOutputStream(file,true);
                                        fout.write(out.getBytes());
                                        fout.close();
                                        Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                else
                                {
                                    try {
                                        fout = new FileOutputStream(file,false);
                                        fout.write(out.getBytes());
                                        fout.close();
                                        Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
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

                        //filename="Memorable";
                        filename="Memorable";
                        if (isExternalStorageAvailable()&& flag!=0) {
                            File folder=getPrivateStorageDir(filename);
                            File file = new File (folder, "Data.txt");
                            FileOutputStream fout=null;
                            if(file.exists())
                            {
                                try {
                                    fout = new FileOutputStream(file,true);
                                    fout.write(out.getBytes());
                                    fout.close();
                                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            else
                            {
                                try {
                                    fout = new FileOutputStream(file,false);
                                    fout.write(out.getBytes());
                                    fout.close();
                                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
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



        Mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==1)
                {
                    flag=0;
                    Toast.makeText(getApplicationContext(),"Mode Changed To Internal",Toast.LENGTH_LONG).show();
                }
                else
                {
                    flag=1;
                    Toast.makeText(getApplicationContext(),"Mode Changed To External",Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    private static boolean isExternalStorageAvailable() {
        String extStorageState = android.os.Environment.getExternalStorageState();
        if (android.os.Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }


    public File getPrivateStorageDir(String albumName) {
        File file= new File(getApplicationContext().getExternalFilesDir(
                Environment.DIRECTORY_DOCUMENTS), albumName);
        if (!file.mkdirs()) {

        }
        return file;
    }


    public boolean fileExistance(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }


}

