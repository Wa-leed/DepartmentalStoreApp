package com.example.departmentalstoreapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddNewItemActivity extends AppCompatActivity {

    private EditText passwordEditText, itemNameEditText, itemPriceEditText;
    private Spinner categorySpinner;
    private Button submitButton, addItemButton;
    private String selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_item);

        passwordEditText = findViewById(R.id.editTextPassword);
        itemNameEditText = findViewById(R.id.editTextItemName);
        itemPriceEditText = findViewById(R.id.editTextItemPrice);
        categorySpinner = findViewById(R.id.spinnerCategory);
        submitButton = findViewById(R.id.buttonSubmit);
        addItemButton = findViewById(R.id.buttonAddItem);

        // Initialize the spinner with categories
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCategory = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedCategory = null;
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = passwordEditText.getText().toString();

                if (password.equals("abcd")) {
                    Toast.makeText(AddNewItemActivity.this, "You entered correctly", Toast.LENGTH_SHORT).show();
                    categorySpinner.setVisibility(View.VISIBLE);
                    itemNameEditText.setVisibility(View.VISIBLE);
                    itemPriceEditText.setVisibility(View.VISIBLE);
                    addItemButton.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(AddNewItemActivity.this, "Incorrect password, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemName = itemNameEditText.getText().toString();
                String itemPrice = itemPriceEditText.getText().toString();

                if (!itemName.isEmpty() && !itemPrice.isEmpty() && selectedCategory != null) {
                    // Here you would normally save the item to a database or some storage
                    // For simplicity, we will use SharedPreferences to store items
                    getSharedPreferences("items", MODE_PRIVATE)
                            .edit()
                            .putString(itemName, selectedCategory + ":" + itemPrice)
                            .apply();

                    Toast.makeText(AddNewItemActivity.this, "Item added: " + itemName + " with price " + itemPrice + " to " + selectedCategory, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AddNewItemActivity.this, "Please enter all item details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
