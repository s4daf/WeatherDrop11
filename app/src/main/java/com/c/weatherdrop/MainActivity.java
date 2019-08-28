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
        final String url;
        final TextView txtday=findViewById(R.id.txtday);
        final TextView txtcity=findViewById(R.id.txtcity);
        final TextView txtmaxTemp=findViewById(R.id.txtmaxTemp);
        final TextView txtminTemp=findViewById(R.id.txtminTemp);
        final TextView txtsunrise=findViewById(R.id.txtsunrise);
        final TextView txtsunset=findViewById(R.id.txtsunset);
        final TextView txtDescription=findViewById(R.id.txtDescription);
        final TextView txtweather=findViewById(R.id.txtweather);
        final TextView txtWindSpeed=findViewById(R.id.txtWindSpeed);
        final TextView txtMainTemp=findViewById(R.id.txtMainTemp);


url = "http://api.openweathermap.org/data/2.5/weather?q=tehran&APPID=140f88d03d5cbfb6d018df31638ed465";












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
