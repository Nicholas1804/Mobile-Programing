package com.Myapp.ezzyfoodv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.Myapp.ezzyfoodv2.Adapter.ItemAdapter;
import com.Myapp.ezzyfoodv2.Model.ItemType;
import com.Myapp.ezzyfoodv2.Repository.ItemRepository;
import com.Myapp.ezzyfoodv2.Repository.OrderRepository;

public class ItemActivity extends AppCompatActivity {
    RecyclerView List;
    ItemAdapter adapter;
    ItemRepository repo;
    String type;
    TextView ItemText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Bundle extras = getIntent().getExtras();
        type = extras.getString("Type");

        Log.println(Log.ASSERT, "type:", (type));

        List = (RecyclerView)findViewById(R.id.ItemsList);
        repo = new ItemRepository();
        ItemText = findViewById(R.id.ItemText);

        initial();
        List.setLayoutManager(new GridLayoutManager(this, 2));
        List.setAdapter(adapter);
    }

    public void initial() {
        if(type.equals(ItemType.Drink)){
            adapter = new ItemAdapter(repo.getDrinks(), this);
            ItemText.setText("Drinks");
        }
        else if(type.equals(ItemType.Food)){
            adapter = new ItemAdapter(repo.getFoods(), this);
            ItemText.setText("Foods");
        }
        else if(type.equals(ItemType.Snack)){
            adapter = new ItemAdapter(repo.getSnacks(), this);
            ItemText.setText("Snacks");
        }
    }

    public void Order(View view) {
        if(OrderRepository.getOrder() != null && !OrderRepository.getOrder().isEmpty()){
            Intent intent = new Intent(this, TransactionActivity.class);
            startActivity(intent);
        }
    }

    public void Back(View view) {
        finish();
    }
}