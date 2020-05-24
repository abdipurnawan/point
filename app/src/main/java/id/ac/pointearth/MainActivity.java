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
//    ViewFlipper viewFlipper;

    ArrayList<MainModel> mainModels;
    HomeAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

//        viewFlipper = findViewById(R.id.v_flipper);

        Integer[] Gambar = {R.drawable.quotes1, R.drawable.quotes2, R.drawable.quotes3,
                R.drawable.quotes4, R.drawable.quotes5};

//        Integer[] gambarSlide = {R.drawable.tanaman2, R.drawable.tanaman3, R.drawable.tanaman4};

        String[] Deskripsi = {"tanaman", "tanaman", "tanaman", "tanaman", "tanaman"};

        mainModels = new ArrayList<>();
        int i;
        for (i = 0; i < Gambar.length; i++) {
            MainModel model = new MainModel(Gambar[i], Deskripsi[i]);
            mainModels.add(model);
        }

//        for (int gambarSlide)

        //design horizontal layout
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                MainActivity.this, LinearLayoutManager.HORIZONTAL, false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new HomeAdapter(MainActivity.this, mainModels);
        recyclerView.setAdapter(mainAdapter);




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
