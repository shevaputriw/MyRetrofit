package id.ac.polinema.myretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolder {
    @GET("Mahasiswa")
    Call<List<Post>> getPost();

    @GET("Mahasiswa")
    Call<List<Post>> getPost(@Query("id_siswa")String id_siswa);

    @POST("Mahasiswa")
    Call<Post> createPost(@Body Post post);

    @PUT("Mahasiswa")
    Call<Post> createPut(@Body Post post);

}