package id.ac.pointearth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Category extends AppCompatActivity {

    RecyclerView recyclerView;
    //DEKLARASI STRING NAMA, ASAL TANAMAN
    String s1[], hias[], akuatik[], obat[], buah[], peneduh[], pewarna[], serat[], beracun[], daftar[][];
    String asalHias[], asalAkuatik[], asalObat[], asalBuah[], asalPeneduh[], asalPewarna[], asalSerat[], asalBeracun[], daftarAsal[][];

    //DEKLARASI GAMBAR
    int image[] = {R.drawable.kategori_hias, R.drawable.kategori_akuatik, R.drawable.kategori_obat, R.drawable.kategori_buah,
            R.drawable.kategori_peneduh, R.drawable.kategori_pewarna, R.drawable.kategori_serat, R.drawable.kategori_beracun};
    int gambarHias[] = {R.drawable.hias_anggrek, R.drawable.hias_bonsai, R.drawable.hias_bougenville,
            R.drawable.hias_kaktus, R.drawable.hias_lily, R.drawable.hias_matahari, R.drawable.hias_mawar, R.drawable.hias_melati,
            } ;
    int gambarAkuatik[] = {R.drawable.akuatik_apu, R.drawable.akuatik_bambuair, R.drawable.akuatik_callalily, R.drawable.akuatik_ecenggondok,
            R.drawable.akuatik_lotus, R.drawable.akuatik_papyrus, R.drawable.akuatik_pisang, R.drawable.akuatik_teratai};
    int gambarObat[] = {R.drawable.obat_belimbing, R.drawable.obat_jahe, R.drawable.obat_jeruknipis, R.drawable.obat_kayumanis, R.drawable.obat_kencur,
            R.drawable.obat_kunyit, R.drawable.obat_lidahbuaya, R.drawable.obat_mengkudu, R.drawable.obat_seledri, R.drawable.obat_temulawak};
    int gambarBuah[] = {R.drawable.buah_apel, R.drawable.buah_durian, R.drawable.buah_jeruk, R.drawable.buah_kelapa, R.drawable.buah_mangga, R.drawable.buah_nanas,
            R.drawable.buah_pepaya, R.drawable.buah_rambutan, R.drawable.buah_stroberi};
    int gambarPeneduh[] = {R.drawable.peneduh_angsana, R.drawable.peneduh_asamjawa, R.drawable.peneduh_beringin, R.drawable.peneduh_flamboyan, R.drawable.peneduh_kiara,
            R.drawable.peneduh_pucukmerah, R.drawable.peneduh_tabebuya, R.drawable.peneduh_tanjung};
    int gambarPewarna[] = {R.drawable.pewarna_blueberry, R.drawable.pewarna_buahnaga, R.drawable.pewarna_coklat, R.drawable.pewarna_duwet, R.drawable.pewarna_pandan,
            R.drawable.pewarna_rosella, R.drawable.pewarna_secang, R.drawable.pewarna_ubiungu};
    int gambarSerat[] = {R.drawable.serat_flax, R.drawable.serat_jute, R.drawable.serat_kapas, R.drawable.serat_rami, R.drawable.serat_sunnhemp};
    int gambarBeracun[] = {R.drawable.beracun_birthwort, R.drawable.beracun_oleander, R.drawable.beracun_cicuta, R.drawable.berancun_gympiegympie, R.drawable.beracun_kacangracun,
            R.drawable.beracun_kecubung, R.drawable.beracun_kembangterompet, R.drawable.beracun_mataboneka, R.drawable.beracun_manchineel,
            R.drawable.beracun_singkong, R.drawable.beracun_jarak, R.drawable.beracun_rejeki};
    int daftarImage[][] = {gambarHias, gambarAkuatik, gambarObat, gambarBuah, gambarPeneduh, gambarPewarna, gambarSerat, gambarBeracun};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerView = findViewById(R.id.recyclerview);

        getNama();
        getAsal();

        CatAdapter catAdapter = new CatAdapter(this, s1, image, daftar, daftarImage, daftarAsal);
        recyclerView.setAdapter(catAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //inisialisasi
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set home
        bottomNavigationView.setSelectedItemId(R.id.category);
        //selectedlistener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId()){
                    case R.id.category:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0, 0);
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

    private void getNama(){
        s1 = getResources().getStringArray(R.array.kategori);
        hias = getResources().getStringArray(R.array.tanamanHias);
        akuatik = getResources().getStringArray(R.array.tanamanAkuatik);
        obat = getResources().getStringArray(R.array.tanamanObat);
        buah = getResources().getStringArray(R.array.tanamanBuah);
        peneduh = getResources().getStringArray(R.array.tanamanPeneduh);
        pewarna = getResources().getStringArray(R.array.tanamanPewarna);
        serat = getResources().getStringArray(R.array.tanamanSerat);
        beracun = getResources().getStringArray(R.array.tanamanBeracun);
        daftar = new String[][]{hias, akuatik, obat, buah, peneduh, pewarna, serat, beracun};
    }

    private void getAsal(){
        asalHias = getResources().getStringArray(R.array.tanamanHias);
        asalAkuatik = getResources().getStringArray(R.array.tanamanAkuatik);
        asalObat = getResources().getStringArray(R.array.tanamanObat);
        asalBuah = getResources().getStringArray(R.array.tanamanBuah);
        asalPeneduh = getResources().getStringArray(R.array.tanamanPeneduh);
        asalPewarna = getResources().getStringArray(R.array.tanamanPewarna);
        asalSerat = getResources().getStringArray(R.array.tanamanSerat);
        asalBeracun = getResources().getStringArray(R.array.tanamanBeracun);
        daftarAsal = new String[][]{asalHias, asalAkuatik, asalObat, asalBuah, asalPeneduh, asalPewarna, asalSerat, asalBeracun};
    }
}
