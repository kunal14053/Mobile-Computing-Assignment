package in.ac.iiitd.kunal.expresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Save extends AppCompatActivity {

    //Put the data in files

    private Button Save;
    private EditText Write;
    private int way;
    private String out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);


        Write=(EditText) findViewById(R.id.write);
        out=Write.getText().toString();

        Save=(Button)findViewById(R.id.submit);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                way=getIntent().getIntExtra(Express.TAG,0);
                switch (way)
                {
                    case 0:
                        Toast.makeText(getApplicationContext(),"SORRY",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"SORRY",Toast.LENGTH_SHORT).show();
                        break;
                }

                Intent i=new Intent(Save.this,Express.class);
                startActivity(i);
                Write.setText("");
                finish();
            }
        });

    }
}
