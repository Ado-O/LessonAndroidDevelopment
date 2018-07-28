package com.example.user.lesson_android_development;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter  extends ArrayAdapter<Movie> {

    private Context mContext;
    private List<Movie> moviesList = new ArrayList<>();

    /**
     * extends ArrayAdapter and setup context
     */
    public MainAdapter(@NonNull Context context, ArrayList<Movie> list) {
        super(context, 0 , list);

        mContext = context;
        moviesList = list;
    }

    /**
     * setup getView and get listItem
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);

        Movie currentMovie = moviesList.get(position);

        //Finding views
        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(currentMovie.getName());
        TextView release = (TextView) listItem.findViewById(R.id.textView_release);
        release.setText(currentMovie.getRelease());

        return listItem;
    }
}


