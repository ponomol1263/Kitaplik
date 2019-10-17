package com.codeandmania.kitaplik.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.codeandmania.kitaplik.R;
import com.codeandmania.kitaplik.adapters.FilmCustomAdapter;
import com.codeandmania.kitaplik.database.DatabaseHelper;
import com.codeandmania.kitaplik.utils.Film;

import java.util.List;

public class NewMovList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_mov_list);
        ListView ls = findViewById(R.id.list);
        DatabaseHelper db = new DatabaseHelper(getApplicationContext());
        List<Film> list = db.getNewMov();
        FilmCustomAdapter cs = new FilmCustomAdapter(list,getApplicationContext());
        System.out.println(list.get(0).getTitle());
        ls.setAdapter(cs);
    }
}
