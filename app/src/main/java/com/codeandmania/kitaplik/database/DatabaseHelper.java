package com.codeandmania.kitaplik.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.codeandmania.kitaplik.utils.Dizi;
import com.codeandmania.kitaplik.utils.Film;
import com.codeandmania.kitaplik.utils.Kitap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hitanshu on 9/8/17.
 */

    public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mobilecase";
    private static String ID = "id";

    //Kitap
    private static final String NEW_BOOK_TABLE = "new_book";
    private static final String OLD_BOOK_TABLE = "old_book";
    private static String BOOK_ID = "book_id";
    private static String BOOK_TITLE = "book_title";
    private static String BOOK_IMG = "book_img";
    //Son

    //Dizi
    private static final String NEW_TV_TABLE = "new_tv";
    private static final String OLD_TV_TABLE = "old_tv";
    private static String TV_ID = "tv_id";
    private static String TV_TITLE = "tv_title";
    private static String TV_IMG = "tv_img";
    //Son


    //Film

    private static final String NEW_MOV_TABLE = "new_mov";
    private static final String OLD_MOV_TABLE = "old_mov";
    private static String MOV_ID = "mov_id";
    private static String MOV_TITLE = "mov_title";
    private static String MOV_IMG = "mov_img";

    //Son




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private void createNewTvTable(SQLiteDatabase db){
        String CREATE_NEW_TV_TABLE = "CREATE TABLE IF NOT EXISTS " + NEW_TV_TABLE + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TV_ID + " INTEGER,"
            + TV_TITLE + " TEXT,"
            + TV_IMG + " TEXT" + ")";
        db.execSQL(CREATE_NEW_TV_TABLE);
    }

    private void createOldTvTable(SQLiteDatabase db){
        String CREATE_OLD_TV_TABLE = "CREATE TABLE IF NOT EXISTS " + OLD_TV_TABLE + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TV_ID + " INTEGER,"
                + TV_TITLE + " TEXT,"
                + TV_IMG + " TEXT" + ")";
        db.execSQL(CREATE_OLD_TV_TABLE);
    }

    private void createNewMovTable(SQLiteDatabase db){
        String CREATE_NEW_MOV_TABLE = "CREATE TABLE IF NOT EXISTS " + NEW_MOV_TABLE + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MOV_ID + " INTEGER,"
                + MOV_TITLE + " TEXT,"
                + MOV_IMG + " TEXT" + ")";
        db.execSQL(CREATE_NEW_MOV_TABLE);
    }


    private void createOldMovTable(SQLiteDatabase db){
        String CREATE_OLD_MOV_TABLE = "CREATE TABLE IF NOT EXISTS " + OLD_MOV_TABLE + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MOV_ID + " INTEGER,"
                + MOV_TITLE + " TEXT,"
                + MOV_IMG + " TEXT" + ")";
        db.execSQL(CREATE_OLD_MOV_TABLE);
    }




    private void createNewBookTable(SQLiteDatabase db){
        String CREATE_NEW_BOOK_TABLE = "CREATE TABLE IF NOT EXISTS " + NEW_BOOK_TABLE + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + BOOK_ID + " INTEGER,"
                + BOOK_TITLE + " TEXT,"
                + BOOK_IMG + " TEXT" + ")";
        db.execSQL(CREATE_NEW_BOOK_TABLE);
    }
    private void createOldBookTable(SQLiteDatabase db){
        String CREATE_OLD_BOOK_TABLE = "CREATE TABLE IF NOT EXISTS " + OLD_BOOK_TABLE + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + BOOK_ID + " INTEGER,"
                + BOOK_TITLE + " TEXT,"
                + BOOK_IMG + " TEXT" + ")";
        db.execSQL(CREATE_OLD_BOOK_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createNewBookTable(db);
        createOldBookTable(db);
        createNewTvTable(db);
        createOldTvTable(db);
        createNewMovTable(db);
        createOldMovTable(db);
    }



    //izleyecegim film sil

    public boolean delNewMov(Film film){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete(NEW_MOV_TABLE, MOV_ID + " = ?", new String[] {String.valueOf(film.getId())});
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }

    //son


    //izledigim film sil

    public boolean oldNewMov(Film film){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete(NEW_MOV_TABLE, MOV_ID + " = ?", new String[] {String.valueOf(film.getId())});
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }

    //son


    //izleyecegım film ekle
    public boolean addNewMov(Film film){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            ContentValues  values = new ContentValues();
            values.put(MOV_ID, film.getId());
            values.put(MOV_TITLE, film.getTitle());
            values.put(MOV_IMG, film.getImg());
            db.insert(NEW_MOV_TABLE, null, values);
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }
    //Son


    //izledim film ekle

    public boolean addOldMov(Film film){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            ContentValues  values = new ContentValues();
            values.put(MOV_ID, film.getId());
            values.put(MOV_TITLE, film.getTitle());
            values.put(MOV_IMG, film.getImg());
            db.insert(OLD_MOV_TABLE, null, values);
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }

    //son


    //transfer film

    public  boolean MovWatched(Film film){
        boolean process1 = addOldMov(film);
        boolean process2 = delNewMov(film);
        if (process1 == true && process2 == true){
            return true;
        }
        else{
            return false;
        }
    }

    //son

    //izleyecegim dizi

    public boolean addNewTv(Dizi dizi){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            ContentValues  values = new ContentValues();
            values.put(TV_ID, dizi.getId());
            values.put(TV_TITLE, dizi.getTitle());
            values.put(TV_IMG, dizi.getImg());
            db.insert(NEW_TV_TABLE, null, values);
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }

    //Son

    //izledim dizi

    public boolean addOldTv(Dizi dizi){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            ContentValues  values = new ContentValues();
            values.put(TV_ID, dizi.getId());
            values.put(TV_TITLE, dizi.getTitle());
            values.put(TV_IMG, dizi.getImg());
            db.insert(OLD_TV_TABLE, null, values);
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }

    //Son



    //Okuyacağım Kitap Ekle
    public boolean addNewBook(Kitap kitap){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            ContentValues  values = new ContentValues();
            values.put(BOOK_ID, kitap.getId());
            values.put(BOOK_TITLE, kitap.getTitle());
            values.put(BOOK_IMG, kitap.getImg());
            db.insert(NEW_BOOK_TABLE, null, values);
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }
    //Son


    //izleyecegim dizi sil

    public boolean delNewTv(Dizi dizi){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete(NEW_TV_TABLE, TV_ID + " = ?", new String[] {String.valueOf(dizi.getId())});
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }

    //Son



    //izledim dizi sil

    public boolean delOldTv(Dizi dizi){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete(OLD_TV_TABLE, TV_ID + " = ?", new String[] {String.valueOf(dizi.getId())});
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }

    //Son


    //izledim transfer

    public  boolean TvWatched(Dizi dizi){
        boolean process1 = addOldTv(dizi);
        boolean process2 = delNewTv(dizi);
        if (process1 == true && process2 == true){
            return true;
        }
        else{
            return false;
        }
    }

    //Son


    //Okudugum Kitap Ekle
    public boolean addOldBook(Kitap kitap){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            ContentValues  values = new ContentValues();
            values.put(BOOK_ID, kitap.getId());
            values.put(BOOK_TITLE, kitap.getTitle());
            values.put(BOOK_IMG, kitap.getImg());
            db.insert(OLD_BOOK_TABLE, null, values);
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }
    //Son

    //Okudum
    public  boolean read(Kitap kitap){
        boolean process1 = addOldBook(kitap);
        boolean process2 = delNewBook(kitap);
        if (process1 == true && process2 == true){
            return true;
        }
        else{
            return false;
        }
    }
    //Son

    //Kitap Sil NEW
    public boolean delNewBook(Kitap kitap){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete(NEW_BOOK_TABLE, BOOK_ID + " = ?", new String[] {String.valueOf(kitap.getId())});
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }
    //Son

    //Kitap Sil OLD
    public boolean delOldBook(Kitap kitap){
        SQLiteDatabase db = this.getWritableDatabase();
        try{
            db.delete(OLD_BOOK_TABLE, BOOK_ID + " = ?", new String[] {String.valueOf(kitap.getId())});
            db.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (db.isOpen())
                db.close();
        }
        return false;
    }
    //Son



    //izleyecegım fılm cek

    public List<Film> getNewMov() {

        List<Film> filmList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + NEW_MOV_TABLE, null);
        int ixID = cursor.getColumnIndex(MOV_ID);
        int ixTitle = cursor.getColumnIndex(MOV_TITLE);
        int ixImg = cursor.getColumnIndex(MOV_IMG);

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            while(cursor.moveToNext()){
                filmList.add(new Film(cursor.getInt(ixID),cursor.getString(ixTitle),cursor.getString(ixImg)));
                cursor.moveToNext();
            }
            return filmList;
        }
        return null;
    }

    //son

    //izledigim fılm cek

    public List<Film> getOldMov() {

        List<Film> filmList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select "+MOV_ID+", "+MOV_TITLE+", "+MOV_IMG+" from " + OLD_MOV_TABLE, null);
        int ixID = cursor.getColumnIndex(MOV_ID);
        int ixTitle = cursor.getColumnIndex(MOV_TITLE);
        int ixImg = cursor.getColumnIndex(MOV_IMG);

        if (cursor.moveToFirst()){
            do{
                filmList.add(new Film(cursor.getInt(ixID),cursor.getString(ixTitle),cursor.getString(ixImg)));
            }while (cursor.moveToNext());
            return filmList;
        }
        return null;
    }

    //son

    //izleyecegım dizi cek

    public List<Dizi> getNewTV() {

        List<Dizi> diziList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + NEW_TV_TABLE, null);
        int ixID = cursor.getColumnIndex(TV_ID);
        int ixTitle = cursor.getColumnIndex(TV_TITLE);
        int ixImg = cursor.getColumnIndex(TV_IMG);

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            while(cursor.moveToNext()){
                diziList.add(new Dizi(cursor.getInt(ixID),cursor.getString(ixTitle),cursor.getString(ixImg)));
                cursor.moveToNext();
            }
            return diziList;
        }
        return null;
    }

    //son

    //izledigim dizi cek

    public List<Dizi> getOldTV() {

        List<Dizi> diziList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + OLD_TV_TABLE, null);
        int ixID = cursor.getColumnIndex(TV_ID);
        int ixTitle = cursor.getColumnIndex(TV_TITLE);
        int ixImg = cursor.getColumnIndex(TV_IMG);

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            while(cursor.moveToNext()){
                diziList.add(new Dizi(cursor.getInt(ixID),cursor.getString(ixTitle),cursor.getString(ixImg)));
                cursor.moveToNext();
            }
            return diziList;
        }
        return null;
    }

    //son

    //new book cek

    public List<Kitap> getNewBook() {

        List<Kitap> kitapList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + NEW_BOOK_TABLE, null);
        int ixID = cursor.getColumnIndex(BOOK_ID);
        int ixTitle = cursor.getColumnIndex(BOOK_TITLE);
        int ixImg = cursor.getColumnIndex(BOOK_IMG);

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            while(cursor.moveToNext()){
                kitapList.add(new Kitap(cursor.getInt(ixID),cursor.getString(ixTitle),cursor.getString(ixImg)));
                cursor.moveToNext();
            }
            return kitapList;
        }
        return null;
    }

    //son


    //old book cek

    public List<Kitap> getOldBook() {

        List<Kitap> kitapList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + OLD_BOOK_TABLE, null);
        int ixID = cursor.getColumnIndex(BOOK_ID);
        int ixTitle = cursor.getColumnIndex(BOOK_TITLE);
        int ixImg = cursor.getColumnIndex(BOOK_IMG);

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            while(cursor.moveToNext()){
                kitapList.add(new Kitap(cursor.getInt(ixID),cursor.getString(ixTitle),cursor.getString(ixImg)));
                cursor.moveToNext();
            }
            return kitapList;
        }
        return null;
    }

    //son





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}