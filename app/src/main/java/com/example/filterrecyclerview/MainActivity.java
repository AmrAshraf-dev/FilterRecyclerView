package com.example.filterrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;
//https://codinginflow.com/tutorials/android/searchview-recyclerview
// source code is from that link above

public class MainActivity extends AppCompatActivity {
    private ExampleAdapter adapter;
    private List<ExampleItem> exampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillExampleList();
        setUpRecyclerView();
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setNavigationIcon(R.drawable.ic_filter_list);
    }

       private void fillExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem(R.drawable.ic_android, "One", "Ten"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Two", "Eleven"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Three", "Twelve"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Four", "Thirteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Five", "Fourteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Six", "Fifteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Seven", "Sixteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Eight", "Seventeen"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Nine", "Eighteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "One", "Ten"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Two", "Eleven"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Three", "Twelve"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Four", "Thirteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Five", "Fourteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Six", "Fifteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Seven", "Sixteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Eight", "Seventeen"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Nine", "Eighteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "One", "Ten"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Two", "Eleven"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Three", "Twelve"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Four", "Thirteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Five", "Fourteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Six", "Fifteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_android, "Seven", "Sixteen"));
        exampleList.add(new ExampleItem(R.drawable.ic_audio, "Eight", "Seventeen"));
        exampleList.add(new ExampleItem(R.drawable.ic_sun, "Nine", "Eighteen"));
    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
