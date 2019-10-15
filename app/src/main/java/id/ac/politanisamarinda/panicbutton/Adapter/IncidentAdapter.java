package id.ac.politanisamarinda.panicbutton.Adapter;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import id.ac.politanisamarinda.panicbutton.IncidentFragment;
import id.ac.politanisamarinda.panicbutton.InterfaceCallback.IncidentClickListener;
import id.ac.politanisamarinda.panicbutton.Model.Incident;
import id.ac.politanisamarinda.panicbutton.R;

public class IncidentAdapter extends RecyclerView.Adapter<IncidentAdapter.IncidentViewHolder> {
    private List<Incident> incidents =new ArrayList<>();

    IncidentClickListener listener;
    public IncidentAdapter(IncidentClickListener listener){
        this.listener = listener;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IncidentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_incident,parent,false);
        IncidentViewHolder v = new IncidentViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull final IncidentViewHolder holder, final int position) {
        holder.textIncident.setText(incidents.get(position).getNama());
        Picasso.get().load("http://panic.britech.id/"+incidents.get(position).getFoto()).into(holder.imageIncident);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(incidents.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return incidents.size();
    }

    public class IncidentViewHolder extends RecyclerView.ViewHolder{
        public View itemView;
        public TextView textIncident;
        public ImageView imageIncident;

        public IncidentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            textIncident = itemView.findViewById(R.id.textIncident);
            imageIncident = itemView.findViewById(R.id.imageIncident);


        }

    }

}
