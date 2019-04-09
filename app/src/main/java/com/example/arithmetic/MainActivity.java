package com.example.arithmetic;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText EditText1, EditText2;
    TextView text1, text2;
    Button btnCalc, btnClose;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText1 = findViewById(R.id.EditText1);
        EditText2 = findViewById(R.id.EditText2);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = Integer.parseInt(EditText1.getText().toString()) + Integer.parseInt(EditText2.getText().toString());
                Toast.makeText(MainActivity.this, "Sum is : "+ result,Toast.LENGTH_LONG).show();
            }
        });


        btnClose = (Button) findViewById(R.id.btnClose);
        builder = new AlertDialog.Builder(this);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Do you want to close this application")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }

            })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("My Title");
                alert.show();
            }
        });
    }
}
