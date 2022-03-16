package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Dish> aDishes;
    private RecyclerView aRecyclerDish;
    private DishAdapter aDishAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aRecyclerDish = findViewById(R.id.rv_dish);
        aDishes = new ArrayList<>();
        createDishList();
        aDishAdapter = new DishAdapter(this, aDishes);
        aRecyclerDish.setAdapter(aDishAdapter);
        aRecyclerDish.setLayoutManager(new LinearLayoutManager(this));
    }

    private void createDishList() {
        aDishes.add(new Dish(R.drawable.dish1, "Pizza", "Spicy Chicken Pizza", "RS 310.00"));
        aDishes.add(new Dish(R.drawable.dish2, "Burger", "Chicken Burger", "RS 350.00"));
        aDishes.add(new Dish(R.drawable.dish3, "Pizza", "Beef Pizza", "RS 250.00"));
        aDishes.add(new Dish(R.drawable.dish4, "Burger", "Pork Burger", "RS 350.00"));
        aDishes.add(new Dish(R.drawable.dish5, "Burger", "Beef Burger", "RS 310.00"));
        aDishes.add(new Dish(R.drawable.dish6, "Pizza", "Fish Pizza", "RS 250.00"));
        aDishes.add(new Dish(R.drawable.dish7, "Burger", "Shrimp Burger ", "RS 300.00"));
    }


}