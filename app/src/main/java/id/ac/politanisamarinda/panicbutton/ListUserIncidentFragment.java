package id.ac.politanisamarinda.panicbutton;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import id.ac.politanisamarinda.panicbutton.API.EndPoint;
import id.ac.politanisamarinda.panicbutton.API.RetrofitClient;
import id.ac.politanisamarinda.panicbutton.Adapter.IncidentAdapter;
import id.ac.politanisamarinda.panicbutton.Adapter.SimpleDividerItemDecoration;
import id.ac.politanisamarinda.panicbutton.Adapter.UserIncidentAdapter;
import id.ac.politanisamarinda.panicbutton.InterfaceCallback.UserIncidentClickListener;
import id.ac.politanisamarinda.panicbutton.Model.Incident;
import id.ac.politanisamarinda.panicbutton.Model.ResponseIncidents;
import id.ac.politanisamarinda.panicbutton.Model.ResponseListUserIncident;
import id.ac.politanisamarinda.panicbutton.Model.UserIncident;
import id.ac.politanisamarinda.panicbutton.Utility.PrefManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListUserIncidentFragment extends Fragment implements UserIncidentClickListener {

    RecyclerView rvListUserIncident;
    UserIncidentAdapter adapter;
    PrefManager prefManager;

    public ListUserIncidentFragment() {
        // Required empty public constructor
    }

    public static ListUserIncidentFragment newInstance() {
        ListUserIncidentFragment fragment = new ListUserIncidentFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list_incident, container, false);
        rvListUserIncident=view.findViewById(R.id.rv_list_userincident);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity()!=null){
            rvListUserIncident.setHasFixedSize(true);
            rvListUserIncident.setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new UserIncidentAdapter(this);
            rvListUserIncident.setAdapter(adapter);
            rvListUserIncident.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
            prefManager=new PrefManager(getActivity());
            getListUserIncidents();
        }
    }

    //Menampilkan recycleView dari Adapter
    public void getListUserIncidents(){
        try {
            EndPoint api = RetrofitClient.getClient().create(EndPoint.class);
            Call<ResponseListUserIncident> call = api.getListUserIncident(
                    "Bearer "+prefManager.getString(PrefManager.TOKEN));
            call.enqueue(new Callback<ResponseListUserIncident>() {
                @Override
                public void onResponse(Call<ResponseListUserIncident> call, Response<ResponseListUserIncident> response) {
                    List<UserIncident> userIncidentList = response.body().getListUserIncident();
                    adapter.setUserIncidentList(userIncidentList);
                }

                @Override
                public void onFailure(Call<ResponseListUserIncident> call, Throwable t) {
                    Log.d("eror","sa");
                }
            });
        }
        catch (Exception ex){

        }
    }

    @Override
    public void onItemClick(UserIncident item) {

    }
}
