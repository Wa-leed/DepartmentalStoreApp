package com.example.departmentalstoreapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText emailEditText, passwordEditText;
    Button signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        myDb = new DatabaseHelper(this);

        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        signInButton = findViewById(R.id.buttonSignIn);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignInActivity.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                } else if (!myDb.checkUser(email)) {
                    Toast.makeText(SignInActivity.this, "User not registered. Please sign up.", Toast.LENGTH_SHORT).show();
                } else {
                    // Assume success for this example
                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
