package id.ac.politanisamarinda.panicbutton;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class BeritaFragment extends Fragment {


    public BeritaFragment() {
        // Required empty public constructor
    }

    public static BeritaFragment newInstance() {
        BeritaFragment fragment = new BeritaFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_berita, container, false);
    }

}
