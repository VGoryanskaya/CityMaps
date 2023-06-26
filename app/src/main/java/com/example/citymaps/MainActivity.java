package com.example.citymaps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Next(View view){


        Client client = new Client();
        EditText surname = findViewById(R.id.surname);
        EditText name = findViewById(R.id.name);
        EditText mail = findViewById(R.id.mail);

        if (!name.getText().toString().equals("")) {

            client.setSurname(surname.getText().toString());
            client.setName(name.getText().toString());
            client.setMail(mail.getText().toString());

            Intent intent = new Intent(MainActivity.this, MainListActivity.class);
            intent.putExtra("client", client);
            startActivity(intent);
        } else
            Toast.makeText(this, "Введите имя!", Toast.LENGTH_LONG).show();
    }
}
