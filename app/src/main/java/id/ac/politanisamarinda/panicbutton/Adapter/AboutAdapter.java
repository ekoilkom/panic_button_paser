package id.ac.politanisamarinda.panicbutton.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.ac.politanisamarinda.panicbutton.DetailAboutActivity;
import id.ac.politanisamarinda.panicbutton.Model.About;
import id.ac.politanisamarinda.panicbutton.R;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.AppViewHolder> {

    private ArrayList<About> mModelItemList;
    private Context context;

    public AboutAdapter(ArrayList<About> mModelItemList,Context context){
        this.mModelItemList = mModelItemList;
        this.context = context;
    }
    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_about, parent, false);
        AppViewHolder v = new AppViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, final int position) {
        final About currentItem = mModelItemList.get(position);
        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView.setText(currentItem.getNama());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =new Intent(context, DetailAboutActivity.class);
//                Bundle mbundle = new Bundle();
//                mbundle.putString("nama", currentItem.getNama());
////                mbundle.putString("alamat", mModelItemList.get(position).getAlamat());
////                mbundle.putString("tanggal", mModelItemList.get(position).getTanggalLahir());
////                mbundle.putString("job", mModelItemList.get(position).getSocialMedia());
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mModelItemList.size();
    }

    public class AppViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public AppViewHolder(@NonNull final View itemView) {
            super(itemView);
                imageView = itemView.findViewById(R.id.gambarabout);
                textView = itemView.findViewById(R.id.nama);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            About klik = mModelItemList.get(position);
                            Intent intent =new Intent(context, DetailAboutActivity.class);

                            intent.putExtra("nama", mModelItemList.get(position).getNama());
                            intent.putExtra("tanggal", mModelItemList.get(position).getTanggalLahir());
                            intent.putExtra("alamat", mModelItemList.get(position).getAlamat());
                            intent.putExtra("job", mModelItemList.get(position).getSocialMedia());
                            intent.putExtra("gambar", mModelItemList.get(position).getImageResource());

                            context.startActivity(intent);
                        }
                    }
                });
        }
    }
}
