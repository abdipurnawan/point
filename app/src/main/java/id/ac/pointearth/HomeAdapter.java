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

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    int foto[];
    String des[], nam[];

    public HomeAdapter(Context context, int gambar[], String deskripsi[], String nama[]) {
        this.context = context;
        foto = gambar;
        des = deskripsi;
        nam = nama;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.imageView.setImageResource(foto[position]);
        holder.textView.setText(nam[position]);

        holder.homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HomeDetail.class);
                intent.putExtra("foto", foto[position]);
                intent.putExtra("des", des[position]);
                intent.putExtra("nam", nam[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foto.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        ConstraintLayout homeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
            homeLayout = itemView.findViewById(R.id.homeLayout);
        }
    }
}
