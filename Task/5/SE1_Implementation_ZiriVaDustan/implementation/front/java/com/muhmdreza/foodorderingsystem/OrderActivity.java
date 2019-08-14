package com.muhmdreza.foodorderingsystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.muhmdreza.foodorderingsystem.Adapter.MenuItemAdapter;
import com.muhmdreza.foodorderingsystem.Adapter.OrderAdapter;
import com.muhmdreza.foodorderingsystem.Models.MenuItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderActivity extends AppCompatActivity {
    private Map<MenuItem, Integer> order;
    private TextView total;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent i = getIntent();
        total = findViewById(R.id.textView);
        order = (HashMap<MenuItem, Integer>) i.getSerializableExtra(CustomerMenuActivity.ORDER_NAME);
        Toast.makeText(this, order.size() + "", Toast.LENGTH_LONG).show();
        OrderAdapter orderAdapter = new OrderAdapter(this, order);
        RecyclerView recyclerView = findViewById(R.id.rv_order_recycler);
        recyclerView.setAdapter(orderAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setTotal();
    }

    @SuppressLint("SetTextI18n")
    private void setTotal() {
        Integer temp = 0;
        for (MenuItem m : order.keySet()) {
            temp += Integer.parseInt(m.getPrice().replace(" Toman", "")) * order.get(m);
        }
        total.setText("Total Cost: " + temp + " Toman");
    }
}
