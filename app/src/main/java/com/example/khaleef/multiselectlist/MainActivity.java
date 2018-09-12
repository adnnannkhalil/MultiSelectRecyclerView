package com.example.khaleef.multiselectlist;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Activity activity = MainActivity.this;
    RecyclerView rv;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new ItemAdapter(this);

        rv = findViewById(R.id.rcView);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), lm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);

        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1"));
        items.add(new Item("Item 2"));
        items.add(new Item("Item 3"));
        items.add(new Item("Item 4"));
        items.add(new Item("Item 5"));
        items.add(new Item("Item 6"));
        items.add(new Item("Item 7"));
        items.add(new Item("Item 8"));
        items.add(new Item("Item 9"));
        items.add(new Item("Item 10"));
        items.add(new Item("Item 11"));
        items.add(new Item("Item 12"));
        items.add(new Item("Item 13"));
        items.add(new Item("Item 14"));
        items.add(new Item("Item 15"));
        items.add(new Item("Item 16"));
        items.add(new Item("Item 17"));
        items.add(new Item("Item 18"));
        items.add(new Item("Item 19"));
        items.add(new Item("Item 20"));
        items.add(new Item("Item 21"));
        items.add(new Item("Item 22"));
        items.add(new Item("Item 23"));
        items.add(new Item("Item 24"));
        items.add(new Item("Item 25"));
        items.add(new Item("Item 26"));
        items.add(new Item("Item 27"));
        items.add(new Item("Item 28"));
        items.add(new Item("Item 29"));

        adapter.addAll(items);
    }

    public void selectAll(View v) {
        adapter.selectAll();
    }

    public void deselectAll(View v) {
        adapter.clearSelected();
    }

    public void doAction(View v) {
        Toast.makeText(activity, String.format("Selected %d items", adapter.getSelected().size()), Toast.LENGTH_SHORT).show();
    }
}