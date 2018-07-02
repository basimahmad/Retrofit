package com.example.onebyte.retrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.example.onebyte.retrofit.R;
import com.example.onebyte.retrofit.model.joke;
import com.example.onebyte.retrofit.model.value;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JokeViewHolder> {

    private List<value> value;
    private int rowLayout;
    private Context context;


    public static class JokeViewHolder extends RecyclerView.ViewHolder {
        LinearLayout jokeLayout;
        TextView joke_string;
        TextView id;



        public JokeViewHolder(View v) {
            super(v);
            jokeLayout = (LinearLayout) v.findViewById(R.id.jokes_layout);
            joke_string = (TextView) v.findViewById(R.id.joke);
            id = (TextView) v.findViewById(R.id.id);
        }
    }

    public JokeAdapter(List<value> value, int rowLayout, Context context) {
        this.value = value;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public JokeAdapter.JokeViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new JokeViewHolder(view);
    }




    @Override
    public void onBindViewHolder(JokeViewHolder holder, final int position) {
        holder.joke_string.setText(value.get(position).getJoke());
        //holder.id.setText();

    }

    @Override
    public int getItemCount() {
        return value.size();
    }
}