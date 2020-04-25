package id.ac.polinema.myretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textViewResult;
    private PostAdapter postAdapter;
    private RecyclerView recyclerView;
    private Button tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_title);
        tambah = findViewById(R.id.tambah_data);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://retrofitsheva.000webhostapp.com/Api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.235/retrofit/Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);
        Call<List<Post>> call = jsonPlaceHolder.getPost();
//        Call<List<Post>> call = jsonPlaceHolder.getPost("183171001");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    public void generateDataList(List<Post> aa) {
        recyclerView = findViewById(R.id.rv_siswa);
        postAdapter = new PostAdapter(this, aa);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);
    }

    public void handleAdd(View view) {
        Intent intent = new Intent(MainActivity.this, FormAdd.class);
        startActivity(intent);
    }
}
