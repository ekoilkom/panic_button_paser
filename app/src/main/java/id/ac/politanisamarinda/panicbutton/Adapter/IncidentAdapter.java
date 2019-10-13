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
import id.ac.politanisamarinda.panicbutton.Model.DataLogoIncidents;
import id.ac.politanisamarinda.panicbutton.R;

public class IncidentAdapter extends RecyclerView.Adapter<IncidentAdapter.IncidentViewHolder> {
    private List<Incident> Incidents;
    private ArrayList<DataLogoIncidents> dataLogoIncidents;
    private Context context;
    private int rowLayout;

    public String lat, lon;
    public IncidentAdapter(List<Incident> Incidents, ArrayList<DataLogoIncidents> dataLogoIncidents , int rowLayout, Context context, String lon, String lat){
        this.Incidents = Incidents;
        this.context = context;
        this.rowLayout = rowLayout;
        this.lat = lat;
        this.lon = lon;
        this.dataLogoIncidents = dataLogoIncidents;
    }

    @NonNull
    @Override
    public IncidentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        IncidentViewHolder v = new IncidentViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull final IncidentViewHolder holder, int position) {
        holder.mText.setText(Incidents.get(position).getNama());
        holder.imageView.setImageResource(dataLogoIncidents.get(position).getmImageResource());
    }

    @Override
    public int getItemCount() {
        return Incidents.size();
    }

    public class IncidentViewHolder extends RecyclerView.ViewHolder{
        public TextView mText, mtext2;
        public View view;
        public String tanggal;
        public ImageView imageView;
        private Handler handler = new Handler();

        public IncidentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            handler.postDelayed(runnable,1000);
            mText = itemView.findViewById(R.id.textView);
            mtext2 = itemView.findViewById(R.id.textView4);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        Toast.makeText(v.getContext(), "lat :" + lat +
                                " long :" + lon +
                                " id :" + Incidents.get(position).getId() +
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
