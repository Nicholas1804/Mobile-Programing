package com.Myapp.ezzyfoodv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        Intent intent = new Intent(this, ItemsActivity.class);
        intent.putExtra("Type", Type.Food);
        startActivity(intent);
    }

    public void snack(View view) {
        Intent intent = new Intent(this, ItemsActivity.class);
        intent.putExtra("Type", Type.Snack);
        startActivity(intent);
    }

    public void drink(View view) {
        Intent intent = new Intent(this, ItemsActivity.class);
        intent.putExtra("Type", Type.Drink);
        startActivity(intent);
    }

    public void Order(View view) {
        if(OrderRepository.getOrder() != null && !OrderRepository.getOrder().isEmpty()){
            Intent intent = new Intent(this, OrdersActivity.class);
            startActivity(intent);
        }
    }
}