package com.example.mezbaan;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    private static final String DATABASE_NAME = "Mezbaan.sqlite";
    private static final int DATABASE_VERSION = 1;
    private static final String CustomerTbl = "Customer";
    private static final String FoodItemCategoryTbl= "FoodItemCategory";
    private static final String Order_DetailTbl= "Order_Detail";
    private static final String FoodItemTbl= "FoodItem";
    private static final String Order_MasterTbl= "Order_Master";


    private static final String CREATE_TABLE_CUSTOMER ="CREATE TABLE " + CustomerTbl + "("
            + "Cust_Id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "Name" + "TEXT,"
            + "Address" + " TEXT,"
            + "City" + " TEXT,"
            + "Contact_No" + " TEXT,"
            + "Email_Id" + " TEXT" + ")";

    private static final String CREATE_TABLE_FOOD_ITEM_CATEGORY =
            "CREATE TABLE " + FoodItemCategoryTbl + "("
                    + "Category_Id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "Category_Name" + " TEXT,"
                    + "Description" + " TEXT" + ")";

    private static final String CREATE_TABLE_FOOD_ITEM =
            "CREATE TABLE " + FoodItemTbl + "("
                    + "Item_Id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "Item_Name" + " TEXT,"
                    + "Category_Id" + " INTEGER,"
                    + "Item_Price" + " INTEGER,"
                    + "Item_Description" + " TEXT,"
                    + "FOREIGN KEY(Category_Id) REFERENCES " + FoodItemCategoryTbl + "(Category_Id)" + ")";

    private static final String CREATE_TABLE_ORDER_MASTER =
            "CREATE TABLE " + Order_MasterTbl + "("
                    + "Order_Id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "Cust_Id" + " INTEGER,"
                    + "Payable_Amount" + " INTEGER,"
                    + "Date" + " TEXT,"
                    + "FOREIGN KEY(Cust_Id) REFERENCES " + CustomerTbl + "(Cust_Id)" + ")";

    private static final String CREATE_TABLE_ORDER_DETAIL =
            "CREATE TABLE " + Order_DetailTbl + "("
                    + "Order_Item_Id" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "Order_Id" + " INTEGER,"
                    + "Item_Id" + " INTEGER,"
                    + "Qty" + " INTEGER,"
                    + "Sub_Total" + " INTEGER,"
                    + "FOREIGN KEY(Order_Id) REFERENCES " + Order_MasterTbl + "(Order_Id),"
                    + "FOREIGN KEY(Item_Id) REFERENCES " + FoodItemTbl + "(Item_Id)" + ")";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CUSTOMER);
        db.execSQL(CREATE_TABLE_FOOD_ITEM_CATEGORY);
        db.execSQL(CREATE_TABLE_FOOD_ITEM);
        db.execSQL(CREATE_TABLE_ORDER_MASTER);
        db.execSQL(CREATE_TABLE_ORDER_DETAIL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + CustomerTbl);
        db.execSQL("DROP TABLE IF EXISTS " + FoodItemCategoryTbl);
        db.execSQL("DROP TABLE IF EXISTS " + FoodItemTbl);
        db.execSQL("DROP TABLE IF EXISTS " + Order_MasterTbl);
        db.execSQL("DROP TABLE IF EXISTS " + Order_DetailTbl);
        onCreate(db);

    }

    public void open() {

        sqLiteDatabase = this.getWritableDatabase();
    }

    public void close() {

        sqLiteDatabase.close();
    }


    public long addFoodItemCategory(String[] values){
        ContentValues cv = new ContentValues();
        cv.put("Category_Name", values[0]);
        cv.put("Description", values[1]);
        return sqLiteDatabase.insert(FoodItemCategoryTbl, null, cv);

    }

    public long addFoodItem(String[] values){
        ContentValues cv = new ContentValues();
        cv.put("Item_Name", values[0]);
        cv.put("Category_Id", values[1]);
        cv.put("Item_Price", values[2]);
        cv.put("Item_Description", values[3]);
        return sqLiteDatabase.insert(FoodItemTbl, null, cv);

    }

    public Cursor displayFoodItemCategory(){
        sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.query(FoodItemCategoryTbl,new String[]{"Category_Id", "Category_Name", "Description"},null,null,null,null,null);
    }


    public Cursor displayFoodItem(){
        sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.query(FoodItemTbl,new String[]{"Item_Id", "Item_Name", "Category_Id", "Item_Price", "Item_Description"},null,null,null,null,null);
    }

    @SuppressLint("Range")
    public ArrayList<String> getFoodCategory(){
        ArrayList<String> getFCat = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(FoodItemCategoryTbl,new String[]{"Category_Id", "Category_Name"}, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            getFCat.add(cursor.getString(cursor.getColumnIndex("Category_Name")));
            cursor.moveToNext();
        }
        cursor.close();
        return getFCat;
    }










}
