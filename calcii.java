package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button sum, multi, div, sub;
    EditText num1,num2;
    int n1,n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sum=findViewById(R.id.btnSum);
        multi=findViewById(R.id.btnMulti);
        div=findViewById(R.id.btnDiv);
        sub=findViewById(R.id.btnSub);
        num1=findViewById(R.id.num1);
        num2=findViewById(R.id.num2);
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=Integer.parseInt(num1.getText().toString());
                n2=Integer.parseInt(num2.getText().toString());
                int s = n1+n2;
                Toast.makeText(getApplicationContext(),"Sum="+s,Toast.LENGTH_SHORT).show();
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=Integer.parseInt(num1.getText().toString());
                n2=Integer.parseInt(num2.getText().toString());
                int s = n1*n2;
                Toast.makeText(getApplicationContext(),"Multi="+s,Toast.LENGTH_SHORT).show();
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=Integer.parseInt(num1.getText().toString());
                n2=Integer.parseInt(num2.getText().toString());
                int s = n1/n2;
                Toast.makeText(getApplicationContext(),"Div="+s,Toast.LENGTH_SHORT).show();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1=Integer.parseInt(num1.getText().toString());
                n2=Integer.parseInt(num2.getText().toString());
                int s = n1-n2;
                Toast.makeText(getApplicationContext(),"Sub="+s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

