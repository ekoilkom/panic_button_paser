package id.ac.politanisamarinda.panicbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.politanisamarinda.panicbutton.API.EndPoint;
import id.ac.politanisamarinda.panicbutton.API.RetrofitClient;
import id.ac.politanisamarinda.panicbutton.Model.ResponseLoginApi;
import id.ac.politanisamarinda.panicbutton.Model.ResponseUser;
import id.ac.politanisamarinda.panicbutton.Utility.PrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail,etPassword;
    Button bLogin;
    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefManager=new PrefManager(this);

        if(!prefManager.getString(PrefManager.TOKEN).equalsIgnoreCase("v")){
            cekLoginApi(prefManager.getString(PrefManager.TOKEN));
        }

        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        bLogin=findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLoginApi(etEmail.getText().toString(),etPassword.getText().toString());
            }
        });
    }


    public void getLoginApi(String email,String password){
        try {
            EndPoint api = RetrofitClient.getClient().create(EndPoint.class);
            Call<ResponseLoginApi> call = api.getLoginApi(email,password);
            call.enqueue(new Callback<ResponseLoginApi>() {
                @Override
                public void onResponse(Call<ResponseLoginApi> call, Response<ResponseLoginApi> response) {
                    if(response.isSuccessful()) {
                        if(response.body().isSuccess()) {
//                        prefManager.setString(PrefManager.TOKEN, response.body().getLoginApi().getToken());
                            PrefManager prf = new PrefManager(getApplicationContext());
                            prf.setString("token", response.body().getLoginApi().getToken());
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        } else {

                        }
                    }else {
                        startActivity(new Intent(LoginActivity.this, PopUpActivity.class));
                    }
                }

                @Override
                public void onFailure(Call<ResponseLoginApi> call, Throwable t) {
                    Log.d("eror","sa");
                }
            });
        }
        catch (Exception ex){

        }
    }

    public void cekLoginApi(String token){
        try {
            EndPoint api = RetrofitClient.getClient().create(EndPoint.class);
            Call<ResponseUser> call = api.checkLogin("Bearer "+token);
            call.enqueue(new Callback<ResponseUser>() {
                @Override
                public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                    if(response.isSuccessful()){
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<ResponseUser> call, Throwable t) {
                    Log.d("eror","sa");
                }
            });
        }
        catch (Exception ex){
            Log.d("eror","sa");
        }
    }
}
