package com.example.mariam.movieratingapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mariam on 12/05/2016.
 */
public class CustomAdapter extends BaseAdapter
{
    Context context;
    String[] names;
    LayoutInflater inflater;
    List<MovieList.Movies> movies;




    CustomAdapter(Context context,List<MovieList.Movies> movies)
    {
        this.context = context;
        this.movies = movies;

        inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override


    public int getCount() {
        return movies.size();
    }


    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {


        Holder holder = new Holder();
        View view =  inflater.inflate(R.layout.row_layout,null);
        holder.title =(TextView) view.findViewById(R.id.textViewtitle);
        holder.ratings =(TextView) view.findViewById(R.id.textViewrating);
        holder.poster = (ImageView) view.findViewById(R.id.imageViewposter);

        holder.title.setText(movies.get(position).getTitle());
        holder.ratings.setText("Audience Score "+ movies.get(position).getRatings().getAudience_score() + "%");
        Picasso.with(context).load(movies.get(position).getPosters().getThumbnail()).into(holder.poster);


        return view;
    }
    class Holder
    {
        TextView title,ratings;
        ImageView poster;
    }
}


