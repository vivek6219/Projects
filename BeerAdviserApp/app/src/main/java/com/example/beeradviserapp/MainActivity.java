package com.example.beeradviserapp;

import androidx.appcompat.app.AppCompatActivity;
import Strings.xml

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFIndBeer(View view)
    {

        String brand = "brands";
        TextView brands = (TextView) findViewById(brand);
        Spinner color =(Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(color.getSelectedItem());

        brands.setText(beerType);
    }
}
