package edu.csc4360.project2.wineinventory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private ArrayList<String> wineNames = new ArrayList<>();
    private WineDatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        getSupportActionBar().setTitle("View All Items");

        db = new WineDatabaseHandler(this);

        this.wineNames = getWineNames();
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(wineNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private ArrayList<String> getWineNames() {
        WineDatabaseHandler db = new WineDatabaseHandler(this);
        ArrayList<String> wineNames = new ArrayList<>();

        Cursor cursor = db.getAllData();
        while(cursor.moveToNext()) {
            wineNames.add(cursor.getString(1));
        }

        return wineNames;
    }



}
