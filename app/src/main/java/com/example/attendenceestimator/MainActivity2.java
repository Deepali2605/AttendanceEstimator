package com.example.attendenceestimator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("deprecation")
public class MainActivity2 extends AppCompatActivity {
    Button buttonCalculator1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setTitle("SoftSkills Attendence Estimator");

        EditText edtlecture1, edtpresent1, edtAbsent1;
        TextView txtRemaining1;
        TextView txtResult;
        
        TextView txtheld1, txtcoming1, txtsuggestion1;
       Button cal_result;

        edtlecture1 = findViewById(R.id.edtlecture1);
        edtpresent1 = findViewById(R.id.edtpresent1);
        edtAbsent1 = findViewById(R.id.edtabsent1);
        cal_result = findViewById(R.id.calResult1);
        txtRemaining1 = findViewById(R.id.txtRemaining1);
        txtheld1 = findViewById(R.id.txtheld1);
        txtcoming1 = findViewById(R.id.txtcoming1);
        txtsuggestion1 = findViewById(R.id.txtsuggestion1);
        txtResult = findViewById(R.id.txtResult1);


      cal_result.setOnClickListener(view -> {
            Toast.makeText(MainActivity2.this, "Done!", Toast.LENGTH_SHORT).show();

            float tl1 = Integer.parseInt(edtlecture1.getText().toString());
            float pl1 = Integer.parseInt(edtpresent1.getText().toString());
            float al1 = Integer.parseInt(edtAbsent1.getText().toString());
            float held1 = (pl1 + al1);
            float percentage1 = (100 * pl1) / held1;
            float coming1 =  tl1 - held1;
            double suggest = (double) ((0.90 * tl1) - pl1);
            double suggestion1 = Math.round(suggest);
            if (percentage1 < 90) {
                if(suggestion1>coming1) {
                    txtResult.setText("You've less than 90% 😥");
                    txtRemaining1.setText("Current percentage : " + percentage1);
                    txtheld1.setText("No of lectures held : " + held1);
                    txtcoming1.setText("No of upcoming lectures: " + coming1);
                    txtsuggestion1.setText("You are detained!!!");
                }
                else{
                    txtResult.setText("You've less than 90% 😥");
                    txtRemaining1.setText("Current percentage : " + percentage1);
                    txtheld1.setText("No of lectures held : " + held1);
                    txtcoming1.setText("No of upcoming lectures: " + coming1);
                    txtsuggestion1.setText("You have to take " + (int)suggestion1 + " more classes");
                }
            } else {
                txtResult.setText("your percentage is above than 90% 😀");
                txtRemaining1.setText("Current percentage : " + percentage1);
                txtheld1.setText("No of lectures held: " + held1);
                txtcoming1.setText("No of upcoming lectures: " + coming1);
                txtsuggestion1.setText("");
            }
        });
    }
}













