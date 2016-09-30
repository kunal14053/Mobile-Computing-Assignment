package in.ac.iiitd.kunal.expresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Read extends AppCompatActivity {

    Button G_internal,G_external,M_internal,M_external,P_internal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        G_internal=(Button)findViewById(R.id.g_internal);
        G_external=(Button)findViewById(R.id.g_external);
        M_internal=(Button)findViewById(R.id.m_internal);
        M_external=(Button)findViewById(R.id.m_external);
        P_internal=(Button)findViewById(R.id.p_internal);


        G_internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Read.this,Content.class);
                i.putExtra("Type",1);
                startActivity(i);
            }
        });

        G_external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Read.this,Content.class);
                i.putExtra("Type",2);
                startActivity(i);
            }
        });

        M_internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Read.this,Content.class);
                i.putExtra("Type",3);
                startActivity(i);
            }
        });

        M_external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Read.this,Content.class);
                i.putExtra("Type",4);
                startActivity(i);
            }
        });

        P_internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Read.this,Content.class);
                i.putExtra("Type",5);
                startActivity(i);
            }
        });



    }
}
