package com.c.weatherdrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.c.weatherdrop.weatherclass.WeatherClass;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String url;
        final TextView txtday = findViewById(R.id.txtday);
        final TextView txtcity = findViewById(R.id.txtcity);
        final TextView txtmaxTemp = findViewById(R.id.txtmaxTemp);
        final TextView txtminTemp = findViewById(R.id.txtminTemp);
        final TextView txtsunrise = findViewById(R.id.txtsunrise);
        final TextView txtsunset = findViewById(R.id.txtsunset);
        final TextView txtDescription = findViewById(R.id.txtDescription);
        final TextView txtweather = findViewById(R.id.txtweather);
        final TextView txtWindSpeed = findViewById(R.id.txtWindSpeed);
        final TextView txtMainTemp = findViewById(R.id.txtMainTemp);


        url = "http://api.openweathermap.org/data/2.5/weather?q=tehran&APPID=140f88d03d5cbfb6d018df31638ed465";


        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson = new Gson();
                String city;
                Double minTemp;
                Double maxTemp;
                Double mainTemp;
                Double windSpeed;
                Integer sunrise;
                Integer sunset;


                WeatherClass weatherClass = gson.fromJson(response.toString(), WeatherClass.class);


                city = weatherClass.getName();
                txtcity.setText(city);
                minTemp = weatherClass.getMain().getTempMin();
                txtminTemp.setText(minTemp.toString() + "°C");

                maxTemp = weatherClass.getMain().getTempMax();
                txtmaxTemp.setText(maxTemp.toString() + "°C");

                mainTemp = weatherClass.getMain().getTemp();
                txtMainTemp.setText(mainTemp.toString() + "°C");

                windSpeed = weatherClass.getWind().getSpeed();
                txtWindSpeed.setText(windSpeed.toString() + "m/s");

                sunrise = weatherClass.getSys().getSunrise();
                txtsunrise.setText(sunrise.toString());

                sunset = weatherClass.getSys().getSunset();
                txtsunset.setText(sunset.toString());


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });


        TextView txtsearch = findViewById(R.id.txtsearch);
        txtsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchPage.class);
                startActivity(intent);
            }
        });

        Button btnForcase = findViewById(R.id.btnForcase);
        btnForcase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this, ForcaseWeather.class);
                startActivity(intent);

            }
        });
    }
}
