package com.Myapp.ezzyfoodv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.Myapp.ezzyfoodv2.Adapter.OrderAdapter;
import com.Myapp.ezzyfoodv2.Repository.BalanceRepository;
import com.Myapp.ezzyfoodv2.Repository.OrderRepository;

public class TransactionActivity extends AppCompatActivity {
    RecyclerView OrdersList;
    TextView TotalPrice;
    Button PayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        PayBtn = findViewById(R.id.PayBtn);
        OrdersList = (RecyclerView)findViewById(R.id.OrdersList);
        TotalPrice = findViewById(R.id.TotalPriceTxt);

        if(!PayBtn.getText().equals("Home") && OrderRepository.getOrder().isEmpty()){
            toMain();
        }
        else{
            OrderAdapter adapter = new OrderAdapter(OrderRepository.getOrder(), this);
            OrdersList.setLayoutManager(new LinearLayoutManager(this));
            OrdersList.setAdapter(adapter);

            setTotalPrice();
        }
    }

    public void setTotalPrice() {
        TotalPrice.setText(OrderRepository.totalPrice());
    }

    public void toMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Pay(View view) {
        if(PayBtn.getText().equals("PayNow")){
            if(BalanceRepository.getBalance() > OrderRepository.totalPriceValue()){
                BalanceRepository.buyItem(OrderRepository.totalPriceValue());
                OrderRepository.clearOrder();
                TotalPrice.setText("Thank you for Your Order!");
                PayBtn.setText("Home");
            }
        }else if(PayBtn.getText().equals("Home")){
            toMain();
        }
    }

    public void Back(View view) {
        finish();
    }
}