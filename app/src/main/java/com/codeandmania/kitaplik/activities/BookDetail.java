package com.codeandmania.kitaplik.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.codeandmania.kitaplik.R;
import com.codeandmania.kitaplik.database.DatabaseHelper;
import com.codeandmania.kitaplik.utils.Kitap;

public class BookDetail extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        //hide the default actionBar
        getSupportActionBar().hide();
        db = new DatabaseHelper(getApplicationContext());
        //Receive
        Bundle extras = getIntent().getExtras();
        String title =""
                , authors ="", description="" , categories ="", publishDate=""
                ,info ="", buy ="",preview ="" ,thumbnail ="";
        if(extras != null){
            title = extras.getString("book_title");
            authors = extras.getString("book_author");
            description = extras.getString("book_desc");
            categories = extras.getString("book_categories");
            publishDate = extras.getString("book_publish_date");
            info = extras.getString("book_info");
            buy = extras.getString("book_buy");
            preview = extras.getString("book_preview");
            thumbnail = extras.getString("book_thumbnail");
            System.out.println(thumbnail);
        }

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tvTitle = findViewById(R.id.aa_book_name);
        TextView tvAuthors = findViewById(R.id.aa_author);
        TextView tvDesc = findViewById(R.id.aa_description);
        TextView tvCatag = findViewById(R.id.aa_categorie);
        TextView tvPublishDate = findViewById(R.id.aa_publish_date);
        Button tvInfo = findViewById(R.id.aa_info);
        Button tvPreview = findViewById(R.id.aa_preview);

        ImageView ivThumbnail = findViewById(R.id.aa_thumbnail);

        tvTitle.setText(title);
        tvAuthors.setText(authors);
        tvDesc.setText(description);
        tvCatag.setText(categories);
        tvPublishDate.setText(publishDate);





        collapsingToolbarLayout.setTitle(title);

        //RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        Glide.with(this).load(thumbnail).into(ivThumbnail);
    }
}
