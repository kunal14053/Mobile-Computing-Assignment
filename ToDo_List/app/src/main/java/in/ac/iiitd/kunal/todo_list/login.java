package in.ac.iiitd.kunal.todo_list;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private Button Login1,Signup;
    private EditText Username,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Signup=(Button)findViewById(R.id.Sighup);
        Username=(EditText)findViewById(R.id.username);
        Password=(EditText)findViewById(R.id.password);
        final Context context = this;
        final SharedPreferences prefs = getSharedPreferences("Login Details", MODE_PRIVATE);

        Login1=(Button)findViewById(R.id.Login1);
        Login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(prefs.contains("Username")&&prefs.contains("Password")&&prefs.getString("Username","").equals(Username.getText().toString()) && prefs.getString("Password","").equals(Password.getText().toString())) {
                    Intent i = new Intent(login.this, MainActivity.class);
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
                Intent i=new Intent(login.this,SignUp.class);
                startActivity(i);
            }
        });
    }
}
