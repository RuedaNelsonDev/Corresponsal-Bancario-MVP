package com.example.corresponsalwpossmvp.model.dataBase;

import static com.example.corresponsalwpossmvp.tools.Constant.COLUMNA_CLIENT_LAST_NAME;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_ADMIN_ID;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_ADMIN_MAIL;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_ADMIN_PASSWORD;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_BALANCE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_CARD;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_CARD_CVV;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_CARD_TYPE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_CARD_VEN;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_ID;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_IDENTIFICATION;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_NAME;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_PIN;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_STATUS;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_ACCOUNT;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_ADDRESS;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_BALANCE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_ID;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_IDENTIFICATION;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_LAST_NAME;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_MAIL;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_NAME;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_PASSWORD;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_PHONE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_STATUS;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_ACCOUNT_CORRESPONAL;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_CARD;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_COMISION;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_DATE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_HOUR;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_ID;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_QUOTAS;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_RECEIVER;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_SENDER;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_TIPE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_TOTAL_VALUE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_TRANSACTION_VALUE;
import static com.example.corresponsalwpossmvp.tools.Constant.DATABASE_NAME;
import static com.example.corresponsalwpossmvp.tools.Constant.DATABASE_VERSION;
import static com.example.corresponsalwpossmvp.tools.Constant.TABLE_ADMIN;
import static com.example.corresponsalwpossmvp.tools.Constant.TABLE_CLIENT;
import static com.example.corresponsalwpossmvp.tools.Constant.TABLE_CORRESPONDENT;
import static com.example.corresponsalwpossmvp.tools.Constant.TABLE_TRANSACTION;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String querryAdmin =
                "CREATE TABLE " + TABLE_ADMIN +
                        " (" + COLUMN_ADMIN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_ADMIN_MAIL + " TEXT, " +
                        COLUMN_ADMIN_PASSWORD + " TEXT); ";
        db.execSQL(querryAdmin);

        String querryCorrespondent =
                "CREATE TABLE " + TABLE_CORRESPONDENT +
                        " (" + COLUMN_CORRESPONDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_CORRESPONDENT_ACCOUNT + " TEXT, " +
                        COLUMN_CORRESPONDENT_BALANCE + " TEXT, " +
                        COLUMN_CORRESPONDENT_NAME + " TEXT, " +
                        COLUMN_CORRESPONDENT_LAST_NAME + " TEXT, " +
                        COLUMN_CORRESPONDENT_IDENTIFICATION + " TEXT, " +
                        COLUMN_CORRESPONDENT_MAIL + " TEXT, " +
                        COLUMN_CORRESPONDENT_PASSWORD + " TEXT, " +
                        COLUMN_CORRESPONDENT_PHONE + " TEXT, " +
                        COLUMN_CORRESPONDENT_ADDRESS + " TEXT, " +
                        COLUMN_CORRESPONDENT_STATUS + " TEXT); ";
        db.execSQL(querryCorrespondent);

        String querryClient =
                "CREATE TABLE " + TABLE_CLIENT +
                        " (" + COLUMN_CLIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_CLIENT_BALANCE + " TEXT, " +
                        COLUMN_CLIENT_IDENTIFICATION + " TEXT, " +
                        COLUMN_CLIENT_NAME + " TEXT, " +
                        COLUMNA_CLIENT_LAST_NAME + " TEXT, " +
                        COLUMN_CLIENT_CARD + " TEXT, " +
                        COLUMN_CLIENT_CARD_TYPE + " TEXT, " +
                        COLUMN_CLIENT_CARD_CVV + " TEXT, " +
                        COLUMN_CLIENT_CARD_VEN + " TEXT, " +
                        COLUMN_CLIENT_PIN + " TEXT, " +
                        COLUMN_CLIENT_STATUS + " TEXT); ";
        db.execSQL(querryClient);

        String querryTransaction =
                " CREATE TABLE " + TABLE_TRANSACTION +
                        "(" + COLUMN_TRANSACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TRANSACTION_DATE + "TEXT, " +
                        COLUMN_TRANSACTION_HOUR + "TEXT, " +
                        COLUMN_TRANSACTION_TIPE + "TEXT, " +
                        COLUMN_TRANSACTION_TOTAL_VALUE + "TEXT, " +
                        COLUMN_TRANSACTION_VALUE + "TEXT, " +
                        COLUMN_TRANSACTION_COMISION + "TEXT, " +
                        COLUMN_TRANSACTION_ACCOUNT_CORRESPONAL + "TEXT, " +
                        COLUMN_TRANSACTION_SENDER + "TEXT, " +
                        COLUMN_TRANSACTION_RECEIVER + "TEXT, " +
                        COLUMN_TRANSACTION_CARD + "TEXT, " +
                        COLUMN_TRANSACTION_QUOTAS + "TEXT )";
        db.execSQL(querryTransaction);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CORRESPONDENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION);
    }
/*
    public boolean addAdmin(Admin admin) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ADMIN_MAIL, admin.getMailAdmin());
        cv.put(COLUMN_ADMIN_PASSWORD, admin.getPasswordaAdmin());

        long result = db.insert(TABLE_ADMIN, null, cv);

        if (result != -1) {
            return true;
        } else {
            return false;
        }

    }
    public boolean validateAdmin(Admin admin) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ADMIN_MAIL, admin.getMailAdmin());
        cv.put(COLUMN_ADMIN_PASSWORD, admin.getPasswordaAdmin());


        String query = "SELECT * FROM " + TABLE_ADMIN + " WHERE " + COLUMN_ADMIN_MAIL + " = '" + admin.getMailAdmin() +
                "' and " + COLUMN_ADMIN_PASSWORD + " = '" + admin.getPasswordaAdmin() + "' ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            return true;
        }
        return false;
    }



    public boolean validarCaracteresCorreo(TextInputEditText regisCorreo) {
        String loginInput = regisCorreo.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(loginInput).matches()) {
            regisCorreo.setError("correo invalido");
            return false;
        } else {
            return true;
        }
    }

    public boolean validateIdentificationCorres (Correspondent correspondent) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CORRESPONDENT + " WHERE " + COLUMN_CORRESPONDENT_IDENTIFICATION + " = '" + correspondent.getIdentification() + "' ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            return true;
        }
        return false;
    }


    public boolean validateMailCorres (Correspondent correspondent) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CORRESPONDENT + " WHERE " + COLUMN_CORRESPONDENT_MAIL + " = '" +correspondent.getMail() + "' ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            return true;
        }
        return false;
    }

    public boolean addCorrespondent(Correspondent correspondent) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CORRESPONDENT_ACCOUNT, correspondent.getAccount());
        cv.put(COLUMN_CORRESPONDENT_BALANCE, correspondent.getBalance());
        cv.put(COLUMN_CORRESPONDENT_NAME, correspondent.getName());
        cv.put(COLUMN_CORRESPONDENT_LAST_NAME, correspondent.getLastName());
        cv.put(COLUMN_CORRESPONDENT_IDENTIFICATION, correspondent.getIdentification());
        cv.put(COLUMN_CORRESPONDENT_MAIL, correspondent.getPhone());
        cv.put(COLUMN_CORRESPONDENT_PASSWORD, correspondent.getPassword());
        cv.put(COLUMN_CORRESPONDENT_PHONE, correspondent.getPhone());
        cv.put(COLUMN_CORRESPONDENT_ADDRESS, correspondent.getAddress());
        cv.put(COLUMN_CORRESPONDENT_STATUS, correspondent.getStatus());

        long result = db.insert(TABLE_CORRESPONDENT, null, cv);

        if (result != -1) {
            return true;
        } else {
            return false;
        }

    }
    public boolean addClient (Client client) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CLIENT_BALANCE, client.getBalance());
        cv.put(COLUMN_CLIENT_IDENTIFICATION, client.getIdentification());
        cv.put(COLUMN_CLIENT_NAME, client.getName());
        cv.put(COLUMNA_CLIENT_LAST_NAME, client.getLastName());
        cv.put(COLUMN_CLIENT_CARD, client.getCard());
        cv.put(COLUMN_CLIENT_CARD_TYPE, client.getCardType());
        cv.put(COLUMN_CLIENT_CARD_CVV, client.getCvv());
        cv.put(COLUMN_CLIENT_CARD_VEN, client.getVen());
        cv.put(COLUMN_CLIENT_PIN, client.getPin());
        cv.put(COLUMN_CLIENT_STATUS, client.getStatus());

        long result = db.insert(TABLE_CLIENT, null, cv);

        if (result != -1) {
            return true;
        } else {
            return false;
        }

    }
    public boolean validateIdentificationClient (Client client) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CLIENT + " WHERE " + COLUMN_CLIENT_IDENTIFICATION + " = '" + client.getIdentification() + "' ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            return true;
        }
        return false;
    }*/
}
