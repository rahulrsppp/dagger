package com.rahul.dagger.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rahul.dagger.R;
import com.rahul.dagger.util.Listeners;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ujjawal on 7/17/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<String> newsData;
    private List<String> libraryData;
    private Listeners.ItemClickListener itemClickListener;

    public NewsAdapter(Listeners.ItemClickListener listener) {
        this.itemClickListener = listener;
        newsData = new ArrayList<>();
        libraryData = new ArrayList<>();
    }


    public void setData(List<String> data){
        if(MainActivity.dataType == 0) { //Gson
            libraryData = data;
        }else {
            newsData = data;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        if(MainActivity.dataType == 0) { // Gson
            final String data = libraryData.get(position);
            holder.tvTextView.setText(data);


        }else {

            final String data = newsData.get(position);

            try {
                JSONObject jsonObject = new JSONObject(data);
                if (jsonObject.has("from")) {
                    String valueToSet = jsonObject.getString("from");
                    holder.tvTextView.setText("From: " + valueToSet);
                }

                holder.tvTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemClickListener.onSelect(newsData.get(holder.getAdapterPosition()), null);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getItemCount() {

        if(MainActivity.dataType == 0){ //Gson
            return libraryData.size();

        }
        return newsData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTextView;

        public ViewHolder(View v) {
            super(v);
            tvTextView = v.findViewById(R.id.tvTextView);
        }
    }
}