package com.university.calculator.app;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final CalculatorModel CALCULATOR_MODEL = new CalculatorModel();

    private TextView text;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> actionsIds = new ArrayList<>();
        actionsIds.add(R.id.zero);
        actionsIds.add(R.id.one);
        actionsIds.add(R.id.two);
        actionsIds.add(R.id.three);
        actionsIds.add(R.id.four);
        actionsIds.add(R.id.five);
        actionsIds.add(R.id.six);
        actionsIds.add(R.id.seven);
        actionsIds.add(R.id.eight);
        actionsIds.add(R.id.nine);
        actionsIds.add(R.id.point);
        actionsIds.add(R.id.plus);
        actionsIds.add(R.id.minus);
        actionsIds.add(R.id.multiply);
        actionsIds.add(R.id.division);
        actionsIds.add(R.id.divisionWithRemainder);
        actionsIds.add(R.id.equals);
        actionsIds.add(R.id.clean);

        text = findViewById(R.id.text);

        View.OnClickListener numberButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CALCULATOR_MODEL.onActionPressed(view.getId());
                text.setText(CALCULATOR_MODEL.getText());
            }
        };

        actionsIds.forEach(a -> {
                    findViewById(a).setOnClickListener(numberButtonListener);
                }
        );
    }
}