package id.ac.pointearth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    int Gambar[] = {R.drawable.quotes1, R.drawable.quotes2, R.drawable.quotes3,
            R.drawable.quotes4, R.drawable.quotes5};
    String Nama[], Deskripsi[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        Nama = getResources().getStringArray(R.array.namaQuotes);
        Deskripsi = getResources().getStringArray(R.array.deskripsiQuotes);

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.HORIZONTAL, false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        homeAdapter = new HomeAdapter(this, Gambar, Deskripsi, Nama);
        recyclerView.setAdapter(homeAdapter);

        //inisialisasi
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set home
        bottomNavigationView.setSelectedItemId(R.id.home);
        //selectedlistener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.category:
                        startActivity(new Intent(getApplicationContext(),Category.class));
                        overridePendingTransition(0, 0);
                        return true;


                    case R.id.home:
                        return true;


                    case R.id.help:
                        startActivity(new Intent(getApplicationContext(), Help.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
    }
}
