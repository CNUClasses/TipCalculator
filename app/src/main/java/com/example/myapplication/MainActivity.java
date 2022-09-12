package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
//import java.lang.Math;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        double cost = Double.parseDouble(binding.costOfService.getText().toString());

        //get selected radio button
        int id = binding.tipOptions.getCheckedRadioButtonId();

        Double tip=.15;

        switch(id){
            case R.id.option_twenty_percent:
                tip=0.2;
                break;
            case R.id.option_eighteen_percent:
                tip=0.18;
                break;
            default:
                tip=0.15;
        }

        Double tots = cost*tip;
        if(binding.idRoundup.isChecked())
            tots=Math.ceil(tots);

        binding.tipResult.setText(String.valueOf(tots));
    }
}