package com.muhmdreza.foodorderingsystem.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muhmdreza.foodorderingsystem.Models.CommentItem;
import com.muhmdreza.foodorderingsystem.Models.MenuItem;
import com.muhmdreza.foodorderingsystem.Models.Order;
import com.muhmdreza.foodorderingsystem.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private Context context;
    private Map<MenuItem, Integer> menuItemIntegerMap;

    public OrderAdapter(Context context, Map<MenuItem, Integer> menuItemIntegerMap) {
        this.context = context;
        this.menuItemIntegerMap = menuItemIntegerMap;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderAdapter.OrderViewHolder(LayoutInflater.from(this.context).inflate(R.layout.order_row, parent, false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        final MenuItem menuItem = new ArrayList<>(menuItemIntegerMap.keySet()).get(position);
        holder.name.setText(menuItem.getName());
        holder.price.setText(menuItem.getPrice());
        holder.count.setText(menuItemIntegerMap.get(menuItem).toString()+" * ");

    }

    @Override
    public int getItemCount() {
        return menuItemIntegerMap.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder{
        TextView name, price,count;
        public OrderViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_orderRow_name);
            price = itemView.findViewById(R.id.txt_orderRow_price);
            count = itemView.findViewById(R.id.txt_orderRow_count);
        }
    }
}
