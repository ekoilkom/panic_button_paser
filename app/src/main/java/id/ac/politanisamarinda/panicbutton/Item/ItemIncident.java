package id.ac.politanisamarinda.panicbutton.Item;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import id.ac.politanisamarinda.panicbutton.R;

public class ItemIncident extends AppCompatActivity {
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_incident);

        cardView = findViewById(R.id.cv);

       // cardView.setRadius();

    }
}