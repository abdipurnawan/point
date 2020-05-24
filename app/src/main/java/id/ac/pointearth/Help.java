package id.ac.pointearth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Help extends AppCompatActivity {

    TextView deskripsi, tujuan, cara, jenis, contact;
    String des, tuj, car, jen, con;

    ConstraintLayout expandableView4, expandableView5, expandableView6, expandableView7, expandableView8;
    Button arrowBtn4, arrowBtn5, arrowBtn6, arrowBtn7, arrowBtn8;
    CardView cardView4, cardView5, cardView6, cardView7, cardView8;

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

        expandableView4 = findViewById(R.id.expandableView4);
        arrowBtn4 = findViewById(R.id.arrowBtn4);
        cardView4 = findViewById(R.id.cardView4);

        arrowBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView4.getVisibility()==View.GONE){
                    expandableView4.setVisibility(View.VISIBLE);
                    arrowBtn4.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    expandableView4.setVisibility(View.GONE);
                    arrowBtn4.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        expandableView5 = findViewById(R.id.expandableView5);
        arrowBtn5 = findViewById(R.id.arrowBtn5);
        cardView5 = findViewById(R.id.cardView5);

        arrowBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView5.getVisibility()==View.GONE){
                    expandableView5.setVisibility(View.VISIBLE);
                    arrowBtn5.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    expandableView5.setVisibility(View.GONE);
                    arrowBtn5.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        expandableView6 = findViewById(R.id.expandableView6);
        arrowBtn6 = findViewById(R.id.arrowBtn6);
        cardView6 = findViewById(R.id.cardView6);

        arrowBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView6.getVisibility()==View.GONE){
                    expandableView6.setVisibility(View.VISIBLE);
                    arrowBtn6.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    expandableView6.setVisibility(View.GONE);
                    arrowBtn6.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        expandableView7 = findViewById(R.id.expandableView7);
        arrowBtn7 = findViewById(R.id.arrowBtn7);
        cardView7 = findViewById(R.id.cardView7);

        arrowBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView7.getVisibility()==View.GONE){
                    expandableView7.setVisibility(View.VISIBLE);
                    arrowBtn7.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    expandableView7.setVisibility(View.GONE);
                    arrowBtn7.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        expandableView8 = findViewById(R.id.expandableView8);
        arrowBtn8 = findViewById(R.id.arrowBtn8);
        cardView8 = findViewById(R.id.cardView8);

        arrowBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView8.getVisibility()==View.GONE){
                    expandableView8.setVisibility(View.VISIBLE);
                    arrowBtn8.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    expandableView8.setVisibility(View.GONE);
                    arrowBtn8.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

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
