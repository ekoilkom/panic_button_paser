package id.ac.politanisamarinda.panicbutton.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import id.ac.politanisamarinda.panicbutton.InterfaceCallback.IncidentClickListener;
import id.ac.politanisamarinda.panicbutton.InterfaceCallback.UserIncidentClickListener;
import id.ac.politanisamarinda.panicbutton.Model.UserIncident;
import id.ac.politanisamarinda.panicbutton.R;

public class UserIncidentAdapter extends RecyclerView.Adapter<UserIncidentAdapter.IncidentViewHolder> {
    private List<UserIncident> userIncidentList =new ArrayList<>();

    UserIncidentClickListener listener;
    public UserIncidentAdapter(UserIncidentClickListener listener){
        this.listener = listener;
    }

    public void setUserIncidentList(List<UserIncident> userIncidentList) {
        this.userIncidentList = userIncidentList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public IncidentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_userincident,parent,false);
        IncidentViewHolder v = new IncidentViewHolder(view);
        return v;
    }

    @Override
    public void onBindViewHolder(@NonNull final IncidentViewHolder holder, final int position) {
        holder.textIncident.setText(userIncidentList.get(position).getIncident().getNama());

        SimpleDateFormat formatOutgoing2 = new SimpleDateFormat("EEEE, dd MMM yyyy - HH:mm a");
        TimeZone tz2 = TimeZone.getTimeZone("Asia/Jakarta");
        formatOutgoing2.setTimeZone(tz2);

        String created=formatOutgoing2.format(userIncidentList.get(position).getCreatedAt());
        holder.textTanggal.setText(created);

        holder.txtLatitude.setText(String.valueOf(userIncidentList.get(position).getLatitude()));
        holder.txtLongitude.setText(String.valueOf(userIncidentList.get(position).getLongitude()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(userIncidentList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return userIncidentList.size();
    }

    public class IncidentViewHolder extends RecyclerView.ViewHolder{
        public View itemView;
        public TextView textIncident;
        public TextView textTanggal;
        public TextView txtLatitude;
        public TextView txtLongitude;

        public IncidentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            textIncident = itemView.findViewById(R.id.tvIncident);
            textTanggal = itemView.findViewById(R.id.tvTanggal);
            txtLatitude = itemView.findViewById(R.id.latitude);
            txtLongitude = itemView.findViewById(R.id.longitude);


        }

    }

}
