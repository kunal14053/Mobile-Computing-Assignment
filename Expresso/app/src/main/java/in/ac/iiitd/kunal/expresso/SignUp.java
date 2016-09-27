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

public class SignUp extends AppCompatActivity {

    //Put the Data in Shared Preference

    private Button Next;
    private EditText Username,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Username=(EditText)findViewById(R.id.username1);
        Password=(EditText)findViewById(R.id.password1);

        Next=(Button)findViewById(R.id.next);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Username.getText().toString().equals("") || Password.getText().toString().equals(""))
                {
                    Toast.makeText(getApplication(),"One Or More Field Empty",Toast.LENGTH_LONG).show();
                }
                else {
                    SharedPreferences.Editor editor = getSharedPreferences("Login Details", MODE_PRIVATE).edit();
                    editor.putString("Username", Username.getText().toString());
                    editor.putString("Password", Password.getText().toString());
                    editor.commit();
                    Intent i = new Intent(SignUp.this, Details.class);
                    startActivity(i);
                }
            }
        });

    }
}
