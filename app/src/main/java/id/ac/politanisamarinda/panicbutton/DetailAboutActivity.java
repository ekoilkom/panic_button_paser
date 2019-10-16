package id.ac.politanisamarinda.panicbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailAboutActivity extends AppCompatActivity {

    TextView txtNama, txtTanggal, txtAlamat, txtJob;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_about);

        imageView = findViewById(R.id.img_detail_abt);
        txtAlamat = findViewById(R.id.detail_alamat_abt);
        txtJob = findViewById(R.id.detail_job_abt);
        txtNama = findViewById(R.id.detail_nama_abt);
        txtTanggal = findViewById(R.id.detail_tanggal_abt);

        txtNama.setText(getIntent().getExtras().getString("nama"));
        txtJob.setText(getIntent().getExtras().getString("job"));
        txtAlamat.setText(getIntent().getExtras().getString("alamat"));
        txtTanggal.setText(getIntent().getExtras().getString("tanggal"));
        imageView.setImageResource(getIntent().getExtras().getInt("gambar"));

    }
}
