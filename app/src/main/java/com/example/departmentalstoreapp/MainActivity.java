
package com.example.departmentalstoreapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNewItemButton = findViewById(R.id.buttonAddNewItem);
        Button seeItemsButton = findViewById(R.id.buttonSeeItems);
        Button seePricesButton = findViewById(R.id.buttonSeePrices);

        addNewItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewItemActivity.class);
                startActivity(intent);
            }
        });

        seeItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeeItemsActivity.class);
                startActivity(intent);
            }
        });

        seePricesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeePricesActivity.class);
                startActivity(intent);
            }
        });
    }
}
