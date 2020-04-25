package id.ac.polinema.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormAdd extends AppCompatActivity {
    private EditText edittext_nama;
    private EditText edittext_alamat;
    private EditText edittext_jk;
    private EditText edittext_telepon;
//    private EditText edittext_id;
    private TextView judul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add);

        edittext_nama = findViewById(R.id.edittext_nama);
        edittext_alamat = findViewById(R.id.edittext_alamat);
        edittext_jk = findViewById(R.id.edittext_jk);
        edittext_telepon = findViewById(R.id.edittext_telepon);
        judul = findViewById(R.id.judul);
    }

    public void handleSubmit(View view) {
        String nama = edittext_nama.getText().toString();
        String alamat = edittext_alamat.getText().toString();
        String jk = edittext_jk.getText().toString();
        String telepon = edittext_telepon.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.235/retrofit/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Post post = new Post(nama, alamat, jk, telepon);

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<Post> call = jsonPlaceHolder.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(FormAdd.this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FormAdd.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(FormAdd.this, "Gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
