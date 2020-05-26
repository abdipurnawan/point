package id.ac.pointearth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeDetail extends AppCompatActivity {

    ImageView foto;
    TextView des, nam;
    int gambar;
    String deskripsi, nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);

        foto = findViewById(R.id.gambarQuotes);
        des = findViewById(R.id.deskripsiQuotes);
        nam = findViewById(R.id.namaQuotes);
        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("foto") && getIntent().hasExtra("des")){
            gambar = getIntent().getIntExtra("foto", 1);
            deskripsi = getIntent().getStringExtra("des");
            nama = getIntent().getStringExtra("nam");
        }else{
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        foto.setImageResource(gambar);
        des.setText(deskripsi);
        nam.setText(nama);
    }
}
