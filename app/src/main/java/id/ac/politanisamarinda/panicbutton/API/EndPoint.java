package id.ac.politanisamarinda.panicbutton.API;

import id.ac.politanisamarinda.panicbutton.Model.ResponseIncidents;
import id.ac.politanisamarinda.panicbutton.Model.ResponseLoginApi;
import id.ac.politanisamarinda.panicbutton.Model.ResponseUser;
import id.ac.politanisamarinda.panicbutton.Model.ResponseUserIncident;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface EndPoint {

    @POST("api/login")
    @FormUrlEncoded
    @Headers({
            "Accept: Application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    Call<ResponseLoginApi> getLoginApi(
            @Field("email") String email,
            @Field("password") String password
    );

    @POST("api/me")
    @Headers({
            "Accept: Application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    Call<ResponseUser> checkLogin(
            @Header("Authorization") String token
    );

    @GET("api/incidents")
    Call<ResponseIncidents> getIncident();

    @POST("api/user_incidents")
    @FormUrlEncoded
    @Headers({
            "Accept: Application/json",
            "Content-Type: application/x-www-form-urlencoded"
    })
    Call<ResponseUserIncident> setUserIncident(
            @Header("Authorization") String token,
            @Field("incident_id") int bencanaId,
            @Field("latitude") Double lat,
            @Field("longitude") Double lng
    );
//
//    @POST
//    createPost(@Body )
}
