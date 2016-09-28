package in.ac.iiitd.kunal.expresso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Details extends AppCompatActivity {

    private Button Proceed;
    private EditText Name,College_name,College_id,Dob,Po_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final DatabaseHandler db = new DatabaseHandler(this);

        Name=(EditText)findViewById(R.id.name);
        College_name=(EditText)findViewById(R.id.college_name);
        College_id=(EditText)findViewById(R.id.college_id);
        Dob=(EditText)findViewById(R.id.dob);
        Po_no=(EditText)findViewById(R.id.po_no);

        Proceed=(Button)findViewById(R.id.proceed);
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.addInfo(new Information(Name.getText().toString(),College_name.getText().toString(),College_id.getText().toString(),Dob.getText().toString(),Po_no.getText().toString()));
                Intent i=new Intent(Details.this,Express.class);
                startActivity(i);
            }
        });
    }
}
