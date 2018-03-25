package com.example.nadyayulipratama.studycase5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Database dtbs;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<informasi> data_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Data.class
                ));
            }
        });
        setTitle("List Data");
        recyclerView = findViewById(R.id.recyclerView);
        data_list = new ArrayList<>();
        dtbs = new Database(this);
        dtbs.readdata(data_list);

        SharedPreferences sharedPreferences = this. getApplicationContext().getSharedPreferences("preferences", 0);
        int color = sharedPreferences.getInt("Colourground",R.color.colorPrimary);

        adapter = new Adapter(this, data_list,color);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        hapus();

    }

    private void hapus() {
        ItemTouchHelper.SimpleCallback call = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            informasi current = adapter.getData(position);
            if (direction==ItemTouchHelper.LEFT){
                if (dtbs.remove((String) current.getName()));
                adapter.delete(position);
                Snackbar.make(findViewById(R.id.coordinator),"Data berhasil terhapus", 1000).show();


            }
            }
        };
            ItemTouchHelper helper = new ItemTouchHelper(call);
        helper.attachToRecyclerView(recyclerView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, Setting.class);
            startActivity(intent);
            finish();
        }
            return true;
        }

       public  void AddList (View view){
        Intent intent = new Intent(MainActivity.this, Data.class);
        startActivity(intent);
       }
}
