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

import com.squareup.picasso.Picasso;

import id.ac.politanisamarinda.panicbutton.Model.Incident;
import id.ac.politanisamarinda.panicbutton.R;

public class IncidentAdapter extends RecyclerView.Adapter<IncidentAdapter.IncidentViewHolder> {
    private List<Incident> incidents =new ArrayList<>();
    private Context context;

    public String lat, lang;
    public IncidentAdapter(Context context){
        this.context = context;
    }

    public void setIncidents(List<Incident> incidents, String lat,String lang) {
        this.incidents = incidents;
        this.lat = lat;
        this.lang = lang;
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
        Picasso.get().load("http://panic.britech.id/"+incidents.get(position).getFoto()).into(holder.imageIncident);
    }

    @Override
    public int getItemCount() {
        return incidents.size();
    }

    public class IncidentViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView textIncident;
        public ImageView imageIncident;
        public String tanggal;
        private Handler handler = new Handler();

        public IncidentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            handler.postDelayed(runnable,1000);
            textIncident = itemView.findViewById(R.id.textIncident);
            imageIncident = itemView.findViewById(R.id.imageIncident);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Toast.makeText(v.getContext(), "lat :" + lat +
                                " long :" + lang +
                                " id :" + incidents.get(position).getId() +
                                " Date :" + tanggal , Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Calendar c1 = Calendar.getInstance();
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/M/d h:m:s");
                String strdate1 = sdf1.format(c1.getTime());
                tanggal = strdate1;
                handler.postDelayed(this, 1000);
            }
        };
    }

}
