package in.ac.iiitd.kunal.expresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Update extends AppCompatActivity {


    private Button Proceed;
    private EditText Name,College_name,College_id,Dob,Po_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final DatabaseHandler db = new DatabaseHandler(this);

        Name=(EditText)findViewById(R.id.name1);
        College_name=(EditText)findViewById(R.id.college_name1);
        College_id=(EditText)findViewById(R.id.college_id1);
        Dob=(EditText)findViewById(R.id.dob1);
        Po_no=(EditText)findViewById(R.id.po_no1);

        Proceed=(Button)findViewById(R.id.proceed1);
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.updateInfo(getIntent().getStringExtra("ID"),new Information(Name.getText().toString(),College_name.getText().toString(),College_id.getText().toString(),Dob.getText().toString(),Po_no.getText().toString()));
            }
        });

    }
}
