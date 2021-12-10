package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context  context;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView =(ImageView) findViewById(R.id.imageView);


        if (!isConnected()){
            imageView.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this,"No Internet access",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this,"Welcome to our application",Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}