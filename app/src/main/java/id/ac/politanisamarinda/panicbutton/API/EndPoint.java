package id.ac.politanisamarinda.panicbutton.API;

import id.ac.politanisamarinda.panicbutton.Model.ResponseIncidents;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EndPoint {

    @GET("api/incidents")
    Call<ResponseIncidents> getIncident();
//
//    @POST
//    createPost(@Body )
}
