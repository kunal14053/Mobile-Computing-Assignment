package in.ac.iiitd.kunal.expresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ask_Key extends AppCompatActivity {

    Button Ask;
    EditText id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask__key);
        final DatabaseHandler db = new DatabaseHandler(this);
        id=(EditText)findViewById(R.id.id);
        Ask=(Button)findViewById(R.id.show_me);
        Ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Empty Field",Toast.LENGTH_LONG).show();
                }
                else if(!db.Exist(id.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"This ID is Invalid",Toast.LENGTH_LONG).show();
                }
                else
                {
                    int input=getIntent().getIntExtra("Value",0);
                    if(input==1)
                    {
                        Intent i=new Intent(Ask_Key.this,Update.class);
                        i.putExtra("ID",id.getText().toString());
                        startActivity(i);
                    }
                    else
                    {
                        db.deleteInfo(id.getText().toString());
                        finish();
                    }
                }
            }
        });
    }



}
