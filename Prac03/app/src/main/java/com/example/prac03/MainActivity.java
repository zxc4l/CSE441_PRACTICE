package com.example.prac03;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CountryAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private CountryAdapter adapter;
    private List<Country> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        countryList = new ArrayList<>();
        countryList.add(new Country("India", R.drawable.ic_india));
        countryList.add(new Country("China", R.drawable.ic_china));
        countryList.add(new Country("United States", R.drawable.ic_usa));
        countryList.add(new Country("Indonesia", R.drawable.ic_indonesia));
        countryList.add(new Country("Indonesia", R.drawable.ic_pakistan));
        countryList.add(new Country("Indonesia", R.drawable.ic_nigeria));
        countryList.add(new Country("Indonesia", R.drawable.ic_brazil));
        countryList.add(new Country("Indonesia", R.drawable.ic_bangladesh));
        countryList.add(new Country("Indonesia", R.drawable.ic_vietnamese));
        countryList.add(new Country("Indonesia", R.drawable.ic_korea));
        countryList.add(new Country("Indonesia", R.drawable.ic_iceland));


        adapter = new CountryAdapter(this, countryList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(Country country) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("countryName", country.getName());
        intent.putExtra("flagResource", country.getFlagResource());
        startActivity(intent);
    }
}
