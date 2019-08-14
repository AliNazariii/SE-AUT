package com.muhmdreza.foodorderingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class CustomerLoginActivity extends AppCompatActivity {
    private EditText username, password;
    private Button loginButton;
    private String url = "http://192.168.1.4/foodOrderingSystem";
    public static final String TOKEN = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        username = findViewById(R.id.et_loginCustomer_username);
        password = findViewById(R.id.et_loginCustomer_password);
        loginButton = findViewById(R.id.btn_login_customerLogIn);
//        logIn();
        logInFake();
    }

    private void logInFake() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = (new Intent(CustomerLoginActivity.this, CustomerMenuActivity.class));
                i.putExtra(TOKEN,username.getText().toString());
                startActivity(i);
            }
        });
    }

    private void logIn() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("TRUE")) {
                            startActivity(new Intent(CustomerLoginActivity.this, CustomerMenuActivity.class));
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LOG", error.toString());
                    }
                }) {
                    Map<String, String> params = new HashMap<>();

                    @Override
                    public Map<String, String> getParams() {
                        params.put("username", username.getText().toString());
                        params.put("password", password.getText().toString());
                        return params;
                    }
                };
                stringRequest.setRetryPolicy(new DefaultRetryPolicy(15000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                RequestQueue requestQueue = Volley.newRequestQueue(CustomerLoginActivity.this);
                requestQueue.add(stringRequest);
            }
        });
    }


}
