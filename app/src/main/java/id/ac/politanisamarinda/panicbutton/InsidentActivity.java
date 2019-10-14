package id.ac.politanisamarinda.panicbutton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.ac.politanisamarinda.panicbutton.API.EndPoint;
import id.ac.politanisamarinda.panicbutton.API.RetrofitClient;
import id.ac.politanisamarinda.panicbutton.Adapter.IncidentAdapter;
import id.ac.politanisamarinda.panicbutton.Adapter.SimpleDividerItemDecoration;
import id.ac.politanisamarinda.panicbutton.Model.Incident;
import id.ac.politanisamarinda.panicbutton.Model.ResponseIncidents;
import id.ac.politanisamarinda.panicbutton.Service.ShakeService;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class InsidentActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    RecyclerView rv;
    IncidentAdapter adapter;
    TextView text;
    Toolbar toolbar;
    SwitchCompat switchCompat;
    Menu menu = null;

    private String lang, lat;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incident);
        requestPermission();

        switchCompat=findViewById(R.id.switch1);

        client = LocationServices.getFusedLocationProviderClient(this);

        text = findViewById(R.id.textView3);
        rv = findViewById(R.id.recycle_view);
        toolbar = findViewById(R.id.toolbar);

        openPermission();

        //Mengatur tampilan recycleView
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new IncidentAdapter(this);
        rv.setAdapter(adapter);
        rv.addItemDecoration(new SimpleDividerItemDecoration(this));

        setSupportActionBar(toolbar);

        getIncidents();

        Intent intent = new Intent(InsidentActivity.this, ShakeService.class);
        startService(intent);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setEnableRecyclerView(isChecked);
            }
        });
    }
    
    public void setEnableRecyclerView(boolean enable){
        for(int i=0;i<rv.getChildCount();i++){
            rv.getChildAt(i).setEnabled(enable);
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
        if (EasyPermissions.hasPermissions(this, perms))
        {
            Toast.makeText(this,"Location Detected", Toast.LENGTH_SHORT).show();
            //Mendapatkan lokasi latitude dan longitude
            client.getLastLocation().addOnSuccessListener(InsidentActivity.this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null) {
                        double dlat = location.getLatitude();
                        double dlon = location.getLongitude();

                        lat = Double.toString(dlat);
                        lang = Double.toString(dlon);
                    }else {
                        lat = "Tidak dapat lat";
                        lang = "Tidak dapat long";
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
        ActivityCompat.requestPermissions(this, new String[]{ACCESS_FINE_LOCATION}, 1);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    // Ini Adalah Bagian Toolbar
    private void logout() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_list:
                logout();
            default:
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menubar, menu);
        this.menu = menu;

        return super.onCreateOptionsMenu(menu);
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE){

        }
    }
}


