package com.example.easycalculator.Activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.easycalculator.R;

public class MainActivity extends AppCompatActivity {

    TextView tv_result ;
    EditText ed_num1 ;
    EditText ed_num2 ;
    Button btn_sum ;
    Button btn_sub ;
    Button btn_mul ;
    Button btn_div ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv_result = findViewById(R.id.easyCalculator_tv_result);
        ed_num1 = findViewById(R.id.easyCalculator_ed_num1);
        ed_num2 = findViewById(R.id.easyCalculator_ed_num2);
        btn_sum = findViewById(R.id.easyCalculator_btn_sum);
        btn_sub = findViewById(R.id.easyCalculator_btn_subtraction);
        btn_mul = findViewById(R.id.easyCalculator_btn_multiplication);
        btn_div = findViewById(R.id.easyCalculator_btn_division);

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val1 = ed_num1.getText().toString();
                String val2 = ed_num2.getText().toString();

                if (!val1.isEmpty() && !val2.isEmpty()) {
                    int num1 = Integer.parseInt(val1);
                    int num2 = Integer.parseInt(val2);
                    int result = num2 + num1;

                    tv_result.setText(String.valueOf(result));
                }else {
                    Toast.makeText(MainActivity.this, "Enter the numbers!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val1 = ed_num1.getText().toString();
                String val2 = ed_num2.getText().toString();

                if (!val1.isEmpty() && !val2.isEmpty()) {
                    int num1 = Integer.parseInt(val1);
                    int num2 = Integer.parseInt(val2);
                    int result = num1 - num2;

                    tv_result.setText(String.valueOf(result));
                }else {
                    Toast.makeText(MainActivity.this, "Enter the numbers!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val1 = ed_num1.getText().toString();
                String val2 = ed_num2.getText().toString();

                if (!val1.isEmpty() && !val2.isEmpty()) {
                    int num1 = Integer.parseInt(val1);
                    int num2 = Integer.parseInt(val2);
                    int result = num1 * num2;

                    tv_result.setText(String.valueOf(result));
                }else {
                    Toast.makeText(MainActivity.this, "Enter the numbers!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val1 = ed_num1.getText().toString();
                String val2 = ed_num2.getText().toString();

                if (!val1.isEmpty() && !val2.isEmpty()) {
                    double num1 = Integer.parseInt(val1);
                    double num2 = Integer.parseInt(val2);
                    double result;
                    result = num1 / num2;

                    tv_result.setText(String.valueOf(result));
                }else {
                    Toast.makeText(MainActivity.this, "Enter the numbers!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}