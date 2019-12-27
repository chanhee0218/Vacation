package com.chanhee.vacation;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private ArrayList<SaveData> mData;
    private ArrayList<String> texttt;
    public MovieAdapter(ArrayList<SaveData> mData) {
        this.mData = mData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView movieview;
        TextView rankView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.movieview=itemView.findViewById(R.id.movieNm);
            this.rankView=itemView.findViewById(R.id.rank);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.recycler_item,parent,false);
        return new MovieAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SaveData saveData=mData.get(position);
        holder.movieview.setText(saveData.getRanking());
        holder.rankView.setText(saveData.getMovieNm());
    }

    @Override
    public int getItemCount() {
        return mData.size();

    }


}
