package id.ac.politanisamarinda.panicbutton.Adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import id.ac.politanisamarinda.panicbutton.Model.Incident;
import id.ac.politanisamarinda.panicbutton.R;

public class IncidentAdapter extends RecyclerView.Adapter<IncidentAdapter.IncidentViewHolder> {
    private List<Incident> incidents =new ArrayList<>();
    private Context context;

    public String lat, lang;
    public IncidentAdapter(Context context){
        this.context = context;
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
    public void onBindViewHolder(@NonNull final IncidentViewHolder holder, int position) {
        holder.textIncident.setText(incidents.get(position).getNama());
        //holder.imageIncident.setImageResource(dataLogoIncidents.get(position).getmImageResource());
    }

    @Override
    public int getItemCount() {
        return incidents.size();
    }

    public class IncidentViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView textIncident;
        public ImageView imageIncident;

        public IncidentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            textIncident = itemView.findViewById(R.id.textIncident);
            imageIncident = itemView.findViewById(R.id.imageIncident);
        }
    }

}
