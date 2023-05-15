package com.example.attendenceestimator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("deprecation")
public class MainActivity extends AppCompatActivity {
    Button b1;
    Button btnCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Lecture Attendance Estimator");

        EditText edtlecture, edtpresent, edtAbsent;


        TextView txtRemaining;
        TextView txtResult;
        TextView txtheld, txtcoming, txtsuggestion;

        LinearLayout llMain;


        edtlecture = findViewById(R.id.edtlecture);
        edtpresent = findViewById(R.id.edtpresent);
        edtAbsent = findViewById(R.id.edtabsent);
        btnCalculator = findViewById(R.id.calResult);
        txtResult = findViewById(R.id.txtResult);
        txtRemaining = findViewById(R.id.txtRemaining);
        txtheld = findViewById(R.id.txtheld);
        txtcoming = findViewById(R.id.txtcoming);
        txtsuggestion = findViewById(R.id.txtsuggestion);
        b1 = findViewById(R.id.page1);


                        btnCalculator.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                float tl = Integer.parseInt(edtlecture.getText().toString());
                                float pl = Integer.parseInt(edtpresent.getText().toString());
                                float al = Integer.parseInt(edtAbsent.getText().toString());
                                float held = pl+al;
                                float percentage = (100 * pl) / held;
                                float coming = tl - held;
                                double suggest = (double) ((0.80 * tl) - pl);
                                double suggestion = Math.round(suggest);
                                if (percentage < 80) {
                                    if(suggestion>coming){
                                        txtResult.setText("You've less than 80% 😥");
                                        txtRemaining.setText("Current percentage : " + percentage);
                                        txtheld.setText("No of lectures held : " + held);
                                        txtcoming.setText("No of upcoming lectures: " + coming);
                                        txtsuggestion.setText("You are Detained!!");
//                                    llMain.setBackgroundColor(getResources().getColor(R.color.less_than));
                                    }else {

                                        txtResult.setText("You've less than 80% 😥");
                                        txtRemaining.setText("Current percentage : " + percentage);
                                        txtheld.setText("No of lectures held : " + held);
                                        txtcoming.setText("No of upcoming lectures: " + coming);
                                        txtsuggestion.setText("You have to take " + (int)suggestion + " more classes");
//                                      llMain.setBackgroundColor(getResources().getColor(R.color.less_than));
                                    }

                                } else {
                                    txtResult.setText("Your percentage is above than 80% 😀");
                                    txtRemaining.setText("Current percentage : " + percentage);
                                    txtheld.setText("No of lectures held: " + held);
                                    txtcoming.setText("No of upcoming lectures: " + coming);
                                    txtsuggestion.setText("");
//                                  llMain.setBackgroundColor(getResources().getColor(R.color.above));
                                }


                            }
                        });

        b1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }
                }
        );
    }
}
