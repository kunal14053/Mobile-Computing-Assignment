package in.ac.iiitd.kunal.expresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    Button Show,Update,Delete,Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Show=(Button)findViewById(R.id.show);
        Update=(Button)findViewById(R.id.update);
        Delete=(Button)findViewById(R.id.delete);
        Add=(Button)findViewById(R.id.add);

        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Settings.this,Show.class);
                startActivity(i);
            }
        });

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Settings.this,Ask_Key.class);
                i.putExtra("Value",1);
                startActivity(i);
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Settings.this,Ask_Key.class);
                i.putExtra("Value",2);
                startActivity(i);
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Settings.this,Details.class);
                startActivity(i);
            }
        });

    }
}
