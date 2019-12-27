package com.rahul.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    private String URL = "http://eduinsight.edunexttechnologies.com/mobapps/management/schoolmailbox";
    @Inject
    public APIInterface apiInterface;
    ActivityComponent activityComponent;

    @Inject
    NewsAdapter newsAdapter;

    RecyclerView recyclerView;
    ApplicationComponent appComponent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        appComponent = ((MyApplication) getApplication()).getAppComponent();

        activityComponent = DaggerActivityComponent.builder().adapterModule(new AdapterModule(this)).applicationComponent(appComponent).build();

        activityComponent.inject(this);

        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiInterface.getNewsData(URL).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String responseData = response.body();

                if(responseData!=null){
                    List<String> data=new ArrayList<>();

                    try {

                        JSONObject jsonObject=new JSONObject(responseData);

                        if(jsonObject.has("comunicationdata")){
                            JSONArray jsonArray =  jsonObject.getJSONArray("comunicationdata");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject1 =    jsonArray.getJSONObject(i);
                                data.add(jsonObject1.toString());
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    newsAdapter.setData(data);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                System.out.println("Error: "+t.getMessage());
            }
        });

    }

    @Override
    public void onItemClick(Object o1) {
        String data = (String) o1;

        try {
            JSONObject jsonObject = new JSONObject(data);
            if (jsonObject.has("from")) {
                String valueToSet = jsonObject.getString("from");
                Toast.makeText(this, valueToSet, Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
