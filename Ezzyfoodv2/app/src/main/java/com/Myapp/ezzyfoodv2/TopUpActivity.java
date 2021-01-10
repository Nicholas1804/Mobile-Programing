package com.Myapp.ezzyfoodv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.Myapp.ezzyfoodv2.Repository.BalanceRepository;

public class TopUpActivity extends AppCompatActivity {
    TextView BalanceTxt;
    EditText Input;
    Button TopUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        BalanceTxt = findViewById(R.id.balanceTxt);
        Input = findViewById(R.id.editTextTextPersonName);
        TopUpBtn = findViewById(R.id.TopUpBtn);

        BalanceTxt.setText("CurrentBalance: Rp " + BalanceRepository.getBalance());
    }

    public void TopUp(View view) {
        if(TopUpBtn.getText().toString().equals("Home")){
            finish();
        }

        if(TopUpBtn.getText().toString().equals("TopUp")){
            int input = Integer.parseInt(Input.getText().toString());

            if(input >= 10000){
                BalanceRepository.topupBalance(input);
                BalanceTxt.setText("Added!\nCurrentBalance: Rp "+ BalanceRepository.getBalance());
                TopUpBtn.setText("Home");
            }
        }
    }

    public void Back(View view) {
        finish();
    }
}