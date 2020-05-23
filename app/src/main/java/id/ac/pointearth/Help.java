package id.ac.pointearth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Help extends AppCompatActivity {

    TextView deskripsi, tujuan, cara, jenis, contact;
    String des, tuj, car, jen, con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        deskripsi = findViewById(R.id.deskripsiPoint);
        tujuan = findViewById(R.id.tujuanPoint);
        cara = findViewById(R.id.caraPoint);
        jenis = findViewById(R.id.jenisPoint);
        contact = findViewById(R.id.contactPoint);

        getData();
        setData();

        //inisialisasi
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set home
        bottomNavigationView.setSelectedItemId(R.id.help);
        //listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.category:
                        startActivity(new Intent(getApplicationContext(),Category.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.help:
                        return true;
                }
                return false;
            }
        });
    }

    private void getData(){
        des = getResources().getString(R.string.deskripsi);
        tuj = getResources().getString(R.string.tujuan);
        car = getResources().getString(R.string.cara);
        jen = getResources().getString(R.string.jenis);
        con = getResources().getString(R.string.contact);
    }

    private void setData(){
        deskripsi.setText(des);
        tujuan.setText(tuj);
        cara.setText(car);
        jenis.setText(jen);
        contact.setText(con);
    }
}
