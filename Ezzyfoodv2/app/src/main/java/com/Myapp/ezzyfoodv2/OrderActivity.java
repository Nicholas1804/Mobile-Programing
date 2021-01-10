package com.Myapp.ezzyfoodv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.Myapp.ezzyfoodv2.Model.Item;
import com.Myapp.ezzyfoodv2.Repository.ItemRepository;
import com.Myapp.ezzyfoodv2.Repository.OrderRepository;

public class OrderActivity extends AppCompatActivity {
    TextView itemName;
    TextView itemPrice;
    EditText qtyInput;
    Item curr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Bundle extras = getIntent().getExtras();

        curr = ItemRepository.getItemAt(extras.getString("ItemName"));
        qtyInput = findViewById(R.id.qtyInput);
        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.itemPrice);

        itemName.setText(curr.getName());
        itemPrice.setText(curr.getPrice());
    }

    public void Order(View view) {
        if(OrderRepository.getOrder() != null && !OrderRepository.getOrder().isEmpty()){
            Intent intent = new Intent(this, TransactionActivity.class);
            startActivity(intent);
        }
    }

    public void CheckOut(View view) {
        int input = Integer.parseInt(qtyInput.getText().toString());

        if(input > 0){
            OrderRepository.addOrder(curr, input);
            finish();
        }
    }
    public void Back(View view) {
        finish();
    }
}