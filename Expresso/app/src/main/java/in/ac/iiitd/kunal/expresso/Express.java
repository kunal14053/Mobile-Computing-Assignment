package in.ac.iiitd.kunal.expresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Express extends AppCompatActivity {

    private Button General,Personal,Memorable;
    public static String TAG="Id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express);

        General=(Button)findViewById(R.id.general);
        General.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Express.this,Save.class);
                i.putExtra(TAG,1);
                startActivity(i);
            }
        });
        Memorable=(Button)findViewById(R.id.memorable);
        Memorable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Express.this,Save.class);
                i.putExtra(TAG,2);
                startActivity(i);
            }
        });
        Personal=(Button)findViewById(R.id.personal);
        Personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Express.this,Save.class);
                i.putExtra(TAG,3);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        moveTaskToBack(true);
    }
}
