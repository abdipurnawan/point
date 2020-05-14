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

public class PlantListAdapter extends RecyclerView.Adapter<PlantListAdapter.MyViewHolder> {

    String name[], asal[];
    int img[];
    Context context;
    public PlantListAdapter(Context ct, String[] nama, int gambar[], String daftarAsal[]){
        context = ct;
        name = nama;
        img = gambar;
        asal = daftarAsal;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.plant_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.gambarTanaman.setImageResource(img[position]);
        holder.namaTanaman.setText(name[position]);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PlantDetail.class);
                intent.putExtra("name", name[position]);
                intent.putExtra("gambar", img[position]);
                intent.putExtra("asal", asal[position]);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView gambarTanaman;
        TextView namaTanaman;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            gambarTanaman = itemView.findViewById(R.id.gambarTanaman);
            namaTanaman = itemView.findViewById(R.id.namaTanaman);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
