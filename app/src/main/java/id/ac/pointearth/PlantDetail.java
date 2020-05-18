package id.ac.pointearth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlantDetail extends AppCompatActivity {

    ImageView gambarDetail;
    TextView namaDetail, asalDetail, fungsiDetail, merawatDetail;

    String nama, asal, fungsi, merawat;
    int gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detail);

        gambarDetail = findViewById(R.id.gambarDetail);
        namaDetail = findViewById(R.id.namaDetail);
        asalDetail = findViewById(R.id.asalDetail);
        fungsiDetail = findViewById(R.id.fungsiDetail);
        merawatDetail = findViewById(R.id.merawatDetail);

        getData();
        setData();

    }

    private void getData(){
        if(getIntent().hasExtra("name") && getIntent().hasExtra("gambar") && getIntent().hasExtra("asal")){
            nama = getIntent().getStringExtra("name");
            gambar = getIntent().getIntExtra("gambar", 1);
            asal = getIntent().getStringExtra("asal");
            fungsi = getIntent().getStringExtra("fungsi");
            merawat = getIntent().getStringExtra("merawat");
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        gambarDetail.setImageResource(gambar);
        namaDetail.setText(nama);
        asalDetail.setText(asal);
        fungsiDetail.setText(fungsi);
        merawatDetail.setText(merawat);
    }
}
