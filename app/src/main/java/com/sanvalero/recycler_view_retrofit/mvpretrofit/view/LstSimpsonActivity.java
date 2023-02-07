package com.sanvalero.recycler_view_retrofit.mvpretrofit.view;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.sanvalero.recycler_view_retrofit.R;
import com.sanvalero.recycler_view_retrofit.mvpretrofit.LstSimpsonContract;
import com.sanvalero.recycler_view_retrofit.mvpretrofit.adapter.AdapterSimpson;
import com.sanvalero.recycler_view_retrofit.mvpretrofit.entities.Simpson;
import com.sanvalero.recycler_view_retrofit.mvpretrofit.presenter.LstSimpsonPresenter;
import com.sanvalero.recycler_view_retrofit.recyclerview.AdaptadorPersonajes;

import java.util.ArrayList;

public class LstSimpsonActivity extends AppCompatActivity implements LstSimpsonContract.View {
    private LstSimpsonPresenter lstSimpsonPresenter;
    RecyclerView recyclerSimpson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_simpson);

        initComponents();
        initPresenter();
        initData();
    }

    private void initComponents() {
        recyclerSimpson = (RecyclerView) findViewById(R.id.RecyclerId);
    }

    private void initPresenter() {
        lstSimpsonPresenter = new LstSimpsonPresenter(this);
    }

    private void initData() {
        lstSimpsonPresenter.lstSimpson(null); // SELECT * FROM SIMPSON
    }

    @Override
    public void successLstSimpson(ArrayList<Simpson> lstSimpson, String msg) {
        Toast.makeText(this, "Datos recibidos correctamente!!", Toast.LENGTH_SHORT).show();
        // ADAPTER, NOTIFY SET DATA CHANGED
        recyclerSimpson.setLayoutManager(new LinearLayoutManager(this));

        AdapterSimpson adapter = new AdapterSimpson(lstSimpson);
        recyclerSimpson.setAdapter(adapter);
    }

    @Override
    public void failureLstSimpson(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
}