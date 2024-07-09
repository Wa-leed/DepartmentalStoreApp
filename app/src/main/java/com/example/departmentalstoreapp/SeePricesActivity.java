package com.example.departmentalstoreapp;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Map;

public class SeePricesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_prices);

        TableLayout groceryTable = findViewById(R.id.groceryTable);
        TableLayout medicalTable = findViewById(R.id.medicalTable);
        TableLayout cosmeticTable = findViewById(R.id.cosmeticTable);



        // Load dynamic items from SharedPreferences
        Map<String, ?> allItems = getSharedPreferences("items", MODE_PRIVATE).getAll();

        for (Map.Entry<String, ?> entry : allItems.entrySet()) {
            String itemName = entry.getKey();
            String[] itemData = entry.getValue().toString().split(":");
            String category = itemData[0];
            String price = itemData[1];

            TableRow row = new TableRow(this);
            TextView nameTextView = new TextView(this);
            TextView priceTextView = new TextView(this);

            nameTextView.setText(itemName);
            priceTextView.setText("$" + price);
            priceTextView.setGravity(View.TEXT_ALIGNMENT_TEXT_END);

            row.addView(nameTextView);
            row.addView(priceTextView);

            switch (category) {
                case "Grocery Items":
                    groceryTable.addView(row);
                    break;
                case "Medical Items":
                    medicalTable.addView(row);
                    break;
                case "Cosmetic Items":
                    cosmeticTable.addView(row);
                    break;
            }
        }
    }

//    private void addStaticItems(TableLayout groceryTable, TableLayout medicalTable, TableLayout cosmeticTable) {
//        // Adding static items to Grocery table
//        addRowToTable(groceryTable, "Soda", "1");
//        addRowToTable(groceryTable, "Beans", "2");
//        addRowToTable(groceryTable, "Mash Daal", "3");
//        addRowToTable(groceryTable, "Peanuts", "4");
//        addRowToTable(groceryTable, "Sugar", "2");
//        addRowToTable(groceryTable, "Salt", "1");
//
//        // Adding static items to Medical table
//        addRowToTable(medicalTable, "Panadol", "5");
//        addRowToTable(medicalTable, "Desprine", "6");
//        addRowToTable(medicalTable, "Xavour", "7");
//        addRowToTable(medicalTable, "Cough Serup", "8");
//
//        // Adding static items to Cosmetic table
//        addRowToTable(cosmeticTable, "Perfums", "50");
//        addRowToTable(cosmeticTable, "Soap", "5");
//        addRowToTable(cosmeticTable, "Head & Shoulders", "10");
//        addRowToTable(cosmeticTable, "Palmolive", "6");
//        addRowToTable(cosmeticTable, "UDY", "8");
//        addRowToTable(cosmeticTable, "NXT Body Sprays", "12");
//    }

    private void addRowToTable(TableLayout table, String itemName, String price) {
        TableRow row = new TableRow(this);
        TextView nameTextView = new TextView(this);
        TextView priceTextView = new TextView(this);

        nameTextView.setText(itemName);
        priceTextView.setText("$" + price);
        priceTextView.setGravity(View.TEXT_ALIGNMENT_TEXT_END);

        row.addView(nameTextView);
        row.addView(priceTextView);
        table.addView(row);
    }
}
