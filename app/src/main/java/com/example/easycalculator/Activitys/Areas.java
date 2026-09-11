package com.example.easycalculator.Activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.easycalculator.R;

public class Areas extends AppCompatActivity {

    Spinner sp_selectShapes ;
    Button btn_calculate ;
    EditText ed_rectangle_width ;
    EditText ed_rectangle_height ;
    EditText ed_circle_radius ;
    EditText ed_triangle_base ;
    EditText ed_triangle_height ;
    TextView tv_result;
    View linier1, linier2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_areay);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_calculate =findViewById(R.id.areas_btn_calculate);
        ed_rectangle_width =findViewById(R.id.areas_ed_rectangle_width);
        ed_rectangle_height =findViewById(R.id.areas_ed_rectangle_height);
        ed_circle_radius =findViewById(R.id.areas_ed_circle_radius);
        ed_triangle_base =findViewById(R.id.areas_ed_triangle_base);
        ed_triangle_height =findViewById(R.id.areas_ed_triangle_height);
        tv_result=findViewById(R.id.areas_tv_result);
        sp_selectShapes = findViewById(R.id.spinar_shapes);
        linier1 = findViewById(R.id.linier1);
        linier2 = findViewById(R.id.linier2);

        // Hide all inputs initially
        linier1.setVisibility(View.GONE);
        ed_circle_radius.setVisibility(View.GONE);
        linier2.setVisibility(View.GONE);

        sp_selectShapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Areas.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
                switch (i){
                    case 0:
                        Toast.makeText(Areas.this, "Select Shape", Toast.LENGTH_SHORT).show();
                        linier1.setVisibility(View.GONE);
                        ed_circle_radius.setVisibility(View.GONE);
                        linier2.setVisibility(View.GONE);
                        break;
                    case 1:
                        //Rectangle
                        linier1.setVisibility(View.VISIBLE);
                        ed_rectangle_width.setVisibility(View.VISIBLE);
                        ed_rectangle_height.setVisibility(View.VISIBLE);
                        ed_circle_radius.setVisibility(View.GONE);
                        linier2.setVisibility(View.GONE);
                        break;
                    case 2:
                        //Circle
                        linier1.setVisibility(View.GONE);
                        ed_circle_radius.setVisibility(View.VISIBLE);
                        linier2.setVisibility(View.GONE);
                        break;
                    case 3:
                        //Triangle
                        linier1.setVisibility(View.GONE);
                        ed_circle_radius.setVisibility(View.GONE);
                        linier2.setVisibility(View.VISIBLE);
                        ed_triangle_base.setVisibility(View.VISIBLE);
                        ed_triangle_height.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int shape = sp_selectShapes.getSelectedItemPosition();
                double area = 0;
                boolean valid = false;

                try {
                    switch (shape) {
                        case 1: // Rectangle
                            String w = ed_rectangle_width.getText().toString();
                            String h = ed_rectangle_height.getText().toString();
                            if (!w.isEmpty() && !h.isEmpty()) {
                                area = Double.parseDouble(w) * Double.parseDouble(h);
                                valid = true;
                            }
                            break;
                        case 2: // Circle
                            String r = ed_circle_radius.getText().toString();
                            if (!r.isEmpty()) {
                                area = Math.PI * Math.pow(Double.parseDouble(r), 2);
                                valid = true;
                            }
                            break;
                        case 3: // Triangle
                            String b = ed_triangle_base.getText().toString();
                            String th = ed_triangle_height.getText().toString();
                            if (!b.isEmpty() && !th.isEmpty()) {
                                area = 0.5 * Double.parseDouble(b) * Double.parseDouble(th);
                                valid = true;
                            }
                            break;
                        default:
                            Toast.makeText(Areas.this, "Please select a shape", Toast.LENGTH_SHORT).show();
                            return;
                    }

                    if (valid) {
                        tv_result.setText(String.format("%.2f", area));
                    } else {
                        Toast.makeText(Areas.this, "Please enter all values", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(Areas.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}