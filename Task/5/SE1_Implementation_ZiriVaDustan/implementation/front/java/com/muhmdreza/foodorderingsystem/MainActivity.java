package com.muhmdreza.foodorderingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButtons();
    }

    private void setButtons() {
        Button customerLogin = findViewById(R.id.btn_main_customer_login);
        Button orderManagerLogin = findViewById(R.id.btn_main_order_manager_login);
        Button chairmanLogin = findViewById(R.id.btn_main_chairman_login);
        customerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CustomerLoginActivity.class));
            }
        });

    }

}
