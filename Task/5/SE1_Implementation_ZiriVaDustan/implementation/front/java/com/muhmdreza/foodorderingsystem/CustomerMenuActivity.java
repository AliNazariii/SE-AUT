package com.muhmdreza.foodorderingsystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.muhmdreza.foodorderingsystem.Adapter.MenuItemAdapter;
import com.muhmdreza.foodorderingsystem.Models.CommentItem;
import com.muhmdreza.foodorderingsystem.Models.MenuItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerMenuActivity extends AppCompatActivity {
    private final String url = "http://192.168.1.4/foodOrderingSystem";
    private FrameLayout frameLayout;
    private RecyclerView recyclerView;
    private List<MenuItem> menuItems;
    private FloatingActionButton floatingActionButton;
    private MenuItemAdapter menuItemAdapter;
    private String username;

    public static final String ORDER_NAME = "order_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_menu_activity);
        Intent i = getIntent();
        username = i.getStringExtra(CustomerLoginActivity.TOKEN);
        setupViews();
        getFoods();
        setFloatingActionButtonAction();
    }

    private void setFloatingActionButtonAction() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (menuItemAdapter.getOrder().isEmpty()) {
                    Toast.makeText(CustomerMenuActivity.this, "List is Empty", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = (new Intent(CustomerMenuActivity.this, OrderActivity.class));
                    i.putExtra(CustomerMenuActivity.ORDER_NAME, (Serializable) menuItemAdapter.getOrder());
                    startActivity(i);
                }
            }

        });
    }

    private void getFoods() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray foods = response.getJSONArray("data");
                            for (int i = 0; i < foods.length(); i++) {
                                JSONObject food = foods.getJSONObject(i);
                                int available = (int) food.get("available");
                                if (available == 1) {
                                    String id = food.getString("id");
                                    String name = food.getString("name");
                                    String price = food.getString("price") + " Toman";
                                    String category = food.getString("category");
                                    String description = food.getString("description");
                                    String imageUrl;
                                    switch (category) {
                                        case "food":
                                            imageUrl = "https://images.pexels.com/photos/1435907/pexels-photo-1435907.jpeg?auto=format%2Ccompress&cs=tinysrgb&dpr=2&h=650&w=940";
                                            break;
                                        case "salad":
                                            imageUrl = "https://images.pexels.com/photos/1211887/pexels-photo-1211887.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
                                            break;
                                        default:
                                            imageUrl = "https://images.pexels.com/photos/2532752/pexels-photo-2532752.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
                                            break;
                                    }
                                    String count = food.getString("count");

                                    MenuItem newsModel = new MenuItem();
                                    newsModel.setName(name);
                                    newsModel.setPrice(price);
                                    newsModel.setImageUrl(imageUrl);
                                    newsModel.setDescription(description);
                                    newsModel.setCount(count);
                                    newsModel.setID(id);
                                    for (int j = 0; j < 20; j++) {
                                        newsModel.setCommentItems(new CommentItem("Qaza KHUBE", "Qaza" + j));
                                    }
                                    menuItems.add(newsModel);

                                }
                            }
                            frameLayout.setVisibility(View.GONE);
                            floatingActionButton.setVisibility(View.VISIBLE);
                            menuItemAdapter = new MenuItemAdapter(CustomerMenuActivity.this, menuItems, username);
                            recyclerView.setAdapter(menuItemAdapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(CustomerMenuActivity.this));
                        } catch (Exception e) {
                            Log.e("Error", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorInReq", error.toString());
            }
        });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(15000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // bayad be saf add she
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }

    @SuppressLint("WrongViewCast")
    private void setupViews() {
        this.recyclerView = findViewById(R.id.rv_customerMenu_recycler);
        menuItems = new ArrayList<>();
        frameLayout = findViewById(R.id.frame_customer_waiting);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setVisibility(View.GONE);
    }

}
