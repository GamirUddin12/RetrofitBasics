package com.example.retrofitbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvText;
    RetrofitClient retrofitClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvText = findViewById(R.id.tv_Text);
        retrofitClient = new RetrofitClient();

        JsonPlaceHolderApi jp = retrofitClient.getRetrofitInstance().create(JsonPlaceHolderApi.class);

        Call<List<User>> call = jp.getPosts();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (!response.isSuccessful()) {
                    //tvText.setText(response.code());
                    return;
                } else {
                    List<User> users = response.body();
                    for (User user : users) {
                        String s = "\n " + user.getId() +
                                "\n " + user.getName() +
                                "\n " + user.getAddress() + "\n ";
                        tvText.append(s);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {

            }
        });
    }
}
