package in.ac.iiitd.kunal.expresso;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //Shared Preference To Check Weather the Account have been there or not

    private Button Login,Signup;
    private EditText Username,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Signup=(Button)findViewById(R.id.Sighup);
        Username=(EditText)findViewById(R.id.username);
        Password=(EditText)findViewById(R.id.password);
        final Context context = this;
        final SharedPreferences prefs = getSharedPreferences("Login Details", MODE_PRIVATE);

        Login=(Button)findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(prefs.contains("Username")&&prefs.contains("Password")&&prefs.getString("Username","").equals(Username.getText().toString()) && prefs.getString("Password","").equals(Password.getText().toString())) {
                    Intent i = new Intent(MainActivity.this, Express.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(context,"Username or Password not valid",Toast.LENGTH_LONG).show();
                }
            }
        });


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,SignUp.class);
                startActivity(i);
            }
        });
    }
}
