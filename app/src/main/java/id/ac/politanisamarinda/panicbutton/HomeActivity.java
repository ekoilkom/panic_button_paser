package id.ac.politanisamarinda.panicbutton;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import id.ac.politanisamarinda.panicbutton.Service.ShakeService;
import id.ac.politanisamarinda.panicbutton.Utility.PrefManager;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class HomeActivity extends AppCompatActivity  {
    private final String SELECTED_MENU = "selected_menu";
    private BottomNavigationView navView;
    PrefManager prefManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            if (item.getItemId() == R.id.panic_home) {
                fragment = IncidentFragment.newInstance();
            } else if (item.getItemId() == R.id.list_berita) {
                fragment = ListUserIncidentFragment.newInstance();
            }else if (item.getItemId() == R.id.tentang) {
                fragment = AboutFragment.newInstance();
            }

            if (fragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .replace(R.id.container, fragment)
                        .commit();
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        prefManager=new PrefManager(this);

        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU);
        } else {
            navView.setSelectedItemId(R.id.panic_home);
        }

        Intent intent = new Intent(HomeActivity.this, ShakeService.class);
        startService(intent);
    }

    // Ini Adalah Bagian Toolbar
    private void logout() {
        prefManager.setString(prefManager.TOKEN ,"v");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_list:
                logout();
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menubar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
