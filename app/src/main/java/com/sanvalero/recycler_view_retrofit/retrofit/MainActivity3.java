package com.sanvalero.recycler_view_retrofit.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.sanvalero.recycler_view_retrofit.R;

import retrofit2.Retrofit;

public class MainActivity3 extends AppCompatActivity {

    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mJsonTxtView = (TextView) findViewById(R.id.jsonText);
    }

    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }
}