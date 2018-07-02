package com.example.onebyte.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.onebyte.retrofit.adapter.JokeAdapter;
import com.example.onebyte.retrofit.model.joke;
import com.example.onebyte.retrofit.model.value;
import com.example.onebyte.retrofit.rest.ApiClient;
import com.example.onebyte.retrofit.rest.ApiInterface;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<joke> jokesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private JokeAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.jokes_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<joke> call = apiService.getJokes();
        call.enqueue(new Callback<joke>() {
            @Override
            public void onResponse(Call<joke> call, Response<joke> response) {

//                jokesList.add(j);
//                mAdapter.notifyDataSetChanged();
                List<value> value = response.body().getValue();

                Log.d("RESPONSE_CHECK", "res: "+value.size());

                recyclerView.setAdapter(new JokeAdapter(value, R.layout.list_item_joke, getApplicationContext()));




            }

            @Override
            public void onFailure(Call<joke> call, Throwable t) {
                Log.d("RESPONSE_CHECK", t.toString());
            }




        });
    }
}
