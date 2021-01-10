package com.Myapp.ezzyfoodv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Myapp.ezzyfoodv2.Model.Order;
import com.Myapp.ezzyfoodv2.OrderActivity;
import com.Myapp.ezzyfoodv2.R;
import com.Myapp.ezzyfoodv2.Repository.OrderRepository;

import java.util.Vector;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    protected Context context;
    protected Vector<Order> orderList;
    public static int totalPrice;

    public OrderAdapter(Vector<Order> orderList, Context context){
        this.context = context;
        this.orderList = orderList;
        this.totalPrice = OrderRepository.totalPriceValue();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = orderList.get(position);

        holder.itemName.setText(order.getItem().getName());
        holder.itemQtyxPrice.setText(order.getQty() + " x " + order.getItem().getPrice());
        holder.DeleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                OrderRepository.removeOrder(order);
                orderList = OrderRepository.getOrder();
                notifyDataSetChanged();
                Intent intent = new Intent(context, OrderActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView itemQtyxPrice;
        Button DeleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemNameTxt);
            itemQtyxPrice = itemView.findViewById(R.id.qtyxPriceTxt);
            DeleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }
}
