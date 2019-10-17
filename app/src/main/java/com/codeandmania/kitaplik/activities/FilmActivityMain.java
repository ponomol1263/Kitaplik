package com.codeandmania.kitaplik.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.codeandmania.kitaplik.R;

public class FilmActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_main);



        ImageView search = findViewById(R.id.imageViewFilm);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FilmAnasayfa.class);

                startActivity(intent);
            }
        });
    }
}
