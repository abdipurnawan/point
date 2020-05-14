package id.ac.pointearth;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {

    String kategori[],daftarTanaman[][], daftarAsal[][];
    int image[], daftarGambar[][];
    Context context;

    public CatAdapter(Context ct, String s1[], int img[], String daftar[][], int gambarTanaman[][], String asalTanaman[][]) {
        context = ct;
        kategori = s1;
        image = img;
        daftarTanaman =  daftar;
        daftarGambar = gambarTanaman;
        daftarAsal = asalTanaman;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.category_row, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, final int position) {
        holder.namakategori.setText(kategori[position]);
        holder.gambarkategori.setImageResource(image[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlantList.class);
                intent.putExtra("nama", daftarTanaman[position]);
                intent.putExtra("gambar", daftarGambar[position]);
                intent.putExtra("asal", daftarAsal[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kategori.length;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder {

        TextView namakategori;
        ImageView gambarkategori;
        ConstraintLayout mainLayout;
        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            namakategori = itemView.findViewById(R.id.namakategori);
            gambarkategori = itemView.findViewById(R.id.gambarkategori);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
