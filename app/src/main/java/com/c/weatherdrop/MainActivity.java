package com.c.weatherdrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtsearch=findViewById(R.id.txtsearch);
        txtsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,SearchPage.class);
        startActivity(intent);
            }
        });

        Button btnForcase =findViewById(R.id.btnForcase);
        btnForcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this,ForcaseWeather.class);
                startActivity(intent);

            }
        });
    }
}
