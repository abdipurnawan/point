package id.ac.pointearth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlantDetail extends AppCompatActivity {

    ImageView gambarDetail;
    TextView namaDetail, asalDetail, fungsiDetail, merawatDetail;

    String nama, asal, fungsi, merawat, youtube;
    int gambar;

    ConstraintLayout expandableView1, expandableView2, expandableView3;
    Button arrowBtn1, arrowBtn2, arrowBtn3;
    CardView cardView1, cardView2, cardView3;

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

        expandableView1 = findViewById(R.id.expandableView1);
        arrowBtn1 = findViewById(R.id.arrowBtn1);
        cardView1 = findViewById(R.id.cardView1);

        arrowBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView1.getVisibility()==View.GONE){
                    expandableView1.setVisibility(View.VISIBLE);
                    arrowBtn1.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    expandableView1.setVisibility(View.GONE);
                    arrowBtn1.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        expandableView2 = findViewById(R.id.expandableView2);
        arrowBtn2 = findViewById(R.id.arrowBtn2);
        cardView2 = findViewById(R.id.cardView2);

        arrowBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView2.getVisibility()==View.GONE){
                    expandableView2.setVisibility(View.VISIBLE);
                    arrowBtn2.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    expandableView2.setVisibility(View.GONE);
                    arrowBtn2.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });

        expandableView3 = findViewById(R.id.expandableView3);
        arrowBtn3 = findViewById(R.id.arrowBtn3);
        cardView3 = findViewById(R.id.cardView3);

        arrowBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView3.getVisibility()==View.GONE){
                    expandableView3.setVisibility(View.VISIBLE);
                    arrowBtn3.setBackgroundResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                } else {
                    expandableView3.setVisibility(View.GONE);
                    arrowBtn3.setBackgroundResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                }
            }
        });
    }

    private void getData(){
        if(getIntent().hasExtra("name") && getIntent().hasExtra("gambar") && getIntent().hasExtra("asal")){
            nama = getIntent().getStringExtra("name");
            gambar = getIntent().getIntExtra("gambar", 1);
            asal = getIntent().getStringExtra("asal");
            fungsi = getIntent().getStringExtra("fungsi");
            merawat = getIntent().getStringExtra("merawat");
            youtube = getIntent().getStringExtra("youtube");
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
