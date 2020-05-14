package id.ac.pointearth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    HomeAdapter homeAdapter;

    int []arr = {R.drawable.adenium, R.drawable.adiantum, R.drawable.anthurium, R.drawable.hydrangea,
            R.drawable.mandevila, R.drawable.palemhias, R.drawable.puring, R.drawable.sansevieria};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        layoutManager=new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        homeAdapter=new HomeAdapter(arr);

        recyclerView.setAdapter(homeAdapter);
        recyclerView.setHasFixedSize(true);

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
