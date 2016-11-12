package in.ac.iiitd.kunal.crawler;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button mCrawl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCrawl=(Button)findViewById(R.id.Crawl);

        mCrawl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String stringUrl = " https://www.iiitd.ac.in/about";
                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    new Download().execute(stringUrl);
                } else {
                    Toast.makeText(getApplicationContext(),"No network connection available",Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    private class Download extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

        try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

        @Override
        protected void onPostExecute(String result) {

            String out=result;
            String filename="Content";
            if (isExternalStorageAvailable()) {
                File folder=getPrivateStorageDir(filename);
                File file = new File(folder, "Data.txt");
                FileOutputStream fout=null;

                    try {
                        fout = new FileOutputStream(file,false);
                        fout.write(out.getBytes());
                        fout.close();
                        Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

            }
            Intent i=new Intent(MainActivity.this,ShowData.class);
            startActivity(i);
        }


        private boolean isExternalStorageAvailable() {
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


        private String downloadUrl(String myurl) throws IOException {
            InputStream is = null;

            int len = 500;

            try {
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);

                conn.connect();
                int response = conn.getResponseCode();
                Log.d("Hello", "The response is: " + response);
                is = conn.getInputStream();


                String contentAsString = readIt(is);
                return contentAsString;

            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }



        public String readIt(InputStream stream) throws IOException{

            BufferedReader r = new BufferedReader(new InputStreamReader(stream));
            String total = "";
            String line;
            while ((line = r.readLine()) != null) {
                total=total+line+'\n';
            }
            return total;
        }


    }

}
