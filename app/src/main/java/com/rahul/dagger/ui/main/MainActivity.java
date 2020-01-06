package com.rahul.dagger.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.rahul.dagger.CircularInterface;
import com.rahul.dagger.MyApplication;
import com.rahul.dagger.R;
import com.rahul.dagger.ViewModelFactory;
import com.rahul.dagger.databinding.ActivityMainBinding;
import com.rahul.dagger.di.component.ApplicationComponent;
import com.rahul.dagger.di.module.ActivityContextModule;
import com.rahul.dagger.di.module.MainViewModel;
import com.rahul.dagger.di.utility.Library;
import com.rahul.dagger.ui.base.BaseActivity;
import com.rahul.dagger.util.Listeners;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.DaggerApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements Listeners.ItemClickListener {

        // 0 - Gson
        // 1- Scalar
    public static int dataType = 0;

    @Inject
    ViewModelFactory viewModelFactory;

    NewsAdapter newsAdapter;

    RecyclerView recyclerView;
    private MainViewModel viewModel;
    private ActivityMainBinding mBinding;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBinding = getmViewBinding();

        viewModel.getOutputObservable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);

                    System.out.println(":::: Response APIInterface");

                    List<String> data = new ArrayList<>();

                    if (jsonObject.has("comunicationdata")) {
                        JSONArray jsonArray = jsonObject.getJSONArray("comunicationdata");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            data.add(jsonObject1.toString());
                        }
                    }

                    newsAdapter.setData(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        viewModel.getGsonOutputObservable().observe(this, new Observer<Library>() {
            @Override
            public void onChanged(@Nullable Library s) {

                if(s!=null && s.getLibrary_data()!= null){
                    List<Library.LibraryData> libraryData =  s.getLibrary_data();
                    List<String> data = new ArrayList<>();

                    for (int i = 0; i < libraryData.size(); i++) {
                        data.add(libraryData.get(i).getLabel());

                    }
                    newsAdapter.setData(data);
                }
            }
        });

        viewModel.getToastObservable().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(MainActivity.this, "GSON Data- Size is: "+s, Toast.LENGTH_SHORT).show();
            }
        });

        newsAdapter=new NewsAdapter(this);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataType = 0;
        viewModel.executeGson();
    }


    @Override
    public void onSelect(Object o, Object o1) {
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

    @Override
    public void onUnSelect(Object o, Object o1) { }

    public void onScalarButtonClick(View view) {
        dataType = 1;
        viewModel.executeScalar();
    }

    public void onGsonButtonClick(View view) {
        dataType = 0;
        viewModel.executeGson();
    }
}
