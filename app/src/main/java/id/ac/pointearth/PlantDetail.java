package id.ac.pointearth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlantDetail extends AppCompatActivity {

    ImageView gambarDetail;
    TextView namaDetail;

    String nama;
    int gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        gambarDetail = findViewById(R.id.gambarDetail);
        namaDetail = findViewById(R.id.namaDetail);

        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("name") && getIntent().hasExtra("gambar")){
            nama = getIntent().getStringExtra("name");
            gambar = getIntent().getIntExtra("gambar", 1);
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        gambarDetail.setImageResource(gambar);
        namaDetail.setText(nama);
    }
}
