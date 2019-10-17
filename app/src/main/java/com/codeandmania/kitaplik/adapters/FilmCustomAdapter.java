package com.codeandmania.kitaplik.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codeandmania.kitaplik.R;
import com.codeandmania.kitaplik.utils.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmCustomAdapter extends BaseAdapter {

    List<Film> liste;
    LayoutInflater inflater;
    Context context;

    public FilmCustomAdapter(List<Film> liste, Context context) {
        this.liste = liste;
        this.context = context;
    }

    @Override
    public int getCount() {
        return liste.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = LayoutInflater.from(context);
        View list = inflater.inflate(R.layout.listfilm,null);
        ImageView img = list.findViewById(R.id.img);
        TextView title = list.findViewById(R.id.title);
        TextView id = list.findViewById(R.id.id);
        Glide.with(context).load(liste.get(i).getImg()).into(img);
        title.setText(liste.get(i).getTitle());
        System.out.println("Alperen: "+liste.get(i).getTitle());
        id.setText(String.valueOf(liste.get(i).getId()));
        return list;
    }
}
