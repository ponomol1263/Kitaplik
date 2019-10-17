package com.codeandmania.kitaplik.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.codeandmania.kitaplik.R;

public class GirisActivity extends AppCompatActivity {

    ConstraintLayout l_book, l_movie, l_serie ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        l_book = findViewById(R.id.layout_book);
        l_movie =findViewById(R.id.layout_movie);
        l_serie = findViewById(R.id.layout_serie);

        l_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GirisActivity.this, KitapActivityMain.class));
            }
        });


        l_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GirisActivity.this , FilmActivityMain.class));
            }
        });

        l_serie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GirisActivity.this, DiziActivityMain.class));
            }
        });
    }
}
