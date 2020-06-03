package id.ac.pointearth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlantList extends AppCompatActivity {

    RecyclerView recyclerView;

    int imagee;
    String nama[], asal[], fungsi[], merawat[];
    int gambar[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);
        getData();
        recyclerView = findViewById(R.id.recyclerviewTanaman);
        PlantListAdapter plantListAdapter = new PlantListAdapter(this, nama, gambar, asal, fungsi, merawat);
        recyclerView.setAdapter(plantListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //setData();

    }
    private void getData(){
        if(getIntent().hasExtra("nama") && getIntent().hasExtra("gambar") && getIntent().hasExtra("asal") && getIntent().hasExtra("fungsi") && getIntent().hasExtra("merawat")){
            nama = getIntent().getStringArrayExtra("nama");
            gambar = getIntent().getIntArrayExtra("gambar");
            asal = getIntent().getStringArrayExtra("asal");
            fungsi = getIntent().getStringArrayExtra("fungsi");
            merawat = getIntent().getStringArrayExtra("merawat");
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}
