package id.ac.politanisamarinda.panicbutton;


import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import id.ac.politanisamarinda.panicbutton.API.EndPoint;
import id.ac.politanisamarinda.panicbutton.API.RetrofitClient;
import id.ac.politanisamarinda.panicbutton.Adapter.IncidentAdapter;
import id.ac.politanisamarinda.panicbutton.Adapter.SimpleDividerItemDecoration;
import id.ac.politanisamarinda.panicbutton.InterfaceCallback.IncidentClickListener;
import id.ac.politanisamarinda.panicbutton.Model.Incident;
import id.ac.politanisamarinda.panicbutton.Model.ResponseIncidents;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncidentFragment extends Fragment implements EasyPermissions.PermissionCallbacks, IncidentClickListener {

    RecyclerView rv;
    IncidentAdapter adapter;
    SwitchCompat switchCompat;
    private Double lang, lat;
    private FusedLocationProviderClient client;

    public IncidentFragment() {
        // Required empty public constructor
    }

    public static IncidentFragment newInstance() {
        IncidentFragment fragment = new IncidentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_incident, container, false);

        switchCompat=view.findViewById(R.id.switch1);
        rv=view.findViewById(R.id.recycle_view);
        requestPermission();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getActivity()!=null){
            client = LocationServices.getFusedLocationProviderClient(getActivity());
            openPermission();

            rv.setHasFixedSize(true);
            rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
            adapter = new IncidentAdapter(this);
            rv.setAdapter(adapter);
            rv.addItemDecoration(new SimpleDividerItemDecoration(getContext()));

            getIncidents();
        }
    }

    //Menampilkan recycleView dari Adapter
    public void getIncidents(){
        try {
            EndPoint api = RetrofitClient.getClient().create(EndPoint.class);
            Call<ResponseIncidents> call = api.getIncident();
            call.enqueue(new Callback<ResponseIncidents>() {
                @Override
                public void onResponse(Call<ResponseIncidents> call, Response<ResponseIncidents> response) {
                    List<Incident> incidents = response.body().getData();
                    adapter.setIncidents(incidents);
                }

                @Override
                public void onFailure(Call<ResponseIncidents> call, Throwable t) {
                    Log.d("eror","sa");
                }
            });
        }
        catch (Exception ex){

        }
    }

    //fungsi permission untuk android marshmellow dan diatasnya
    @AfterPermissionGranted(123)
    private void openPermission(){
        String[] perms = {ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        if (EasyPermissions.hasPermissions(getActivity(), perms))
        {
            Toast.makeText(getActivity(),"Location Detected", Toast.LENGTH_SHORT).show();
            //Mendapatkan lokasi latitude dan longitude
            client.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        double dlat = location.getLatitude();
                        double dlon = location.getLongitude();

                        lat = dlat;
                        lang = dlon;
                    }else {
                        lat = Double.valueOf(0);
                        lang = Double.valueOf(0);
                    }

                }
            });

        }else {
            EasyPermissions.requestPermissions(this,"we need permission",
                    123,perms);
        }
    }

    //Fungsi meminta penggunaan lokasi
    private void requestPermission(){
        ActivityCompat.requestPermissions(getActivity(), new String[]{ACCESS_FINE_LOCATION}, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    //metode permission callback
    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }
    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if(EasyPermissions.somePermissionPermanentlyDenied(this,perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onItemClick(Incident item) {

    }
}
