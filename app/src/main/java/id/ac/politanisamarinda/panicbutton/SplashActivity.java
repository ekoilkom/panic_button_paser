package id.ac.politanisamarinda.panicbutton;

import androidx.appcompat.app.AppCompatActivity;
import id.ac.politanisamarinda.panicbutton.API.EndPoint;
import id.ac.politanisamarinda.panicbutton.API.RetrofitClient;
import id.ac.politanisamarinda.panicbutton.Model.ResponseUser;
import id.ac.politanisamarinda.panicbutton.Utility.PrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {
    PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefManager=new PrefManager(this);
        if(!prefManager.getString(PrefManager.TOKEN).equalsIgnoreCase("")){
            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        if (prefManager.getString(PrefManager.TOKEN).equalsIgnoreCase("")){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        }

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }
}
