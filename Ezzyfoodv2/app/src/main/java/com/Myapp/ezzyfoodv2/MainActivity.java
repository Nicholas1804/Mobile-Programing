package com.Myapp.ezzyfoodv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Myapp.ezzyfoodv2.Model.ItemType;
import com.Myapp.ezzyfoodv2.Repository.OrderRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Order = findViewById(R.id.OrderBtn);
    }

    public void topup(View view) {
        Intent intent = new Intent(this, TopUpActivity.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent = new Intent(this, ItemActivity.class);
        intent.putExtra("Type", ItemType.Food);
        startActivity(intent);
    }

    public void snack(View view) {
        Intent intent = new Intent(this, ItemActivity.class);
        intent.putExtra("Type", ItemType.Snack);
        startActivity(intent);
    }

    public void drink(View view) {
        Intent intent = new Intent(this, ItemActivity.class);
        intent.putExtra("Type", ItemType.Drink);
        startActivity(intent);
    }

    public void Order(View view) {
        if(OrderRepository.getOrder() != null && !OrderRepository.getOrder().isEmpty()){
            Intent intent = new Intent(this, TransactionActivity.class);
            startActivity(intent);
        }
    }
}