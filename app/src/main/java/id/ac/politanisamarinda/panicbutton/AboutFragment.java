package id.ac.politanisamarinda.panicbutton;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.ac.politanisamarinda.panicbutton.Adapter.AboutAdapter;
import id.ac.politanisamarinda.panicbutton.Adapter.IncidentAdapter;
import id.ac.politanisamarinda.panicbutton.Adapter.SimpleDividerItemDecoration;
import id.ac.politanisamarinda.panicbutton.Model.About;
import id.ac.politanisamarinda.panicbutton.Utility.PrefManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    private RecyclerView rv;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<About> modelItemsList =  new ArrayList<>();

    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment newInstance() {
        AboutFragment fragment = new AboutFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about, container, false);

        modelItemsList.add(new About(R.drawable.dedes_foto, "Desnita Aspriyani", "20 Januari 2010", "Sungai Keledang", "Web Dev"));
        modelItemsList.add(new About(R.drawable.foto_riko, "Riko Raynol Hasan", "23 Mei 2019", "Harapan Baru", "Android Dev"));
        modelItemsList.add(new About(R.drawable.foto_ronal, "Ronaldo Pascalis Naro", "9 April 1950", "Bukuan", "Analisis"));
        rv = view.findViewById(R.id.recycle_about);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() != null) {

            mAdapter = new AboutAdapter(modelItemsList, getContext());
            rv.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getContext());
            rv.setLayoutManager(new GridLayoutManager(getActivity(),2));
            rv.setAdapter(mAdapter);


        }
    }
}
