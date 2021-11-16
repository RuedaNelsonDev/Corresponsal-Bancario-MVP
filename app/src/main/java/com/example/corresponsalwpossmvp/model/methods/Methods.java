package com.example.corresponsalwpossmvp.model.methods;

import static com.example.corresponsalwpossmvp.tools.Constant.COLUMNA_CLIENT_LAST_NAME;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_ADMIN_MAIL;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_ADMIN_PASSWORD;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_BALANCE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_CARD;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_CARD_CVV;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_CARD_TYPE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_CARD_VEN;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_IDENTIFICATION;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_NAME;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_PIN;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CLIENT_STATUS;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_ACCOUNT;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_ADDRESS;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_BALANCE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_IDENTIFICATION;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_LAST_NAME;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_MAIL;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_NAME;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_PASSWORD;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_PHONE;
import static com.example.corresponsalwpossmvp.tools.Constant.COLUMN_CORRESPONDENT_STATUS;
import static com.example.corresponsalwpossmvp.tools.Constant.TABLE_ADMIN;
import static com.example.corresponsalwpossmvp.tools.Constant.TABLE_CLIENT;
import static com.example.corresponsalwpossmvp.tools.Constant.TABLE_CORRESPONDENT;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Patterns;

import com.example.corresponsalwpossmvp.model.dataBase.DataBase;
import com.example.corresponsalwpossmvp.model.models.Admin;
import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Methods {
   SQLiteDatabase myDB;
    Context context;
    SQLiteOpenHelper sqLiteOpenHelper;

    public Methods(Context context) {
        this.context = context;
        sqLiteOpenHelper = new DataBase(context);
        myDB = sqLiteOpenHelper.getWritableDatabase();
    }

    public boolean addAdmin(Admin admin) {
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
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
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
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

    public boolean validateIdentificationCorres(Correspondent correspondent) {
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CORRESPONDENT + " WHERE " + COLUMN_CORRESPONDENT_IDENTIFICATION + " = '" + correspondent.getIdentification() + "' ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            return true;
        }
        return false;
    }


    public boolean validateMailCorres(Correspondent correspondent) {
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CORRESPONDENT + " WHERE " + COLUMN_CORRESPONDENT_MAIL + " = '" + correspondent.getMail() + "' ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            return true;
        }
        return false;
    }

    public boolean addCorrespondent(Correspondent correspondent) {
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
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

    public boolean addClient(Client client) {
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
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

    public boolean validateIdentificationClient(Client client) {
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_CLIENT + " WHERE " + COLUMN_CLIENT_IDENTIFICATION + " = '" + client.getIdentification() + "' ";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.getCount() != 0) {
            return true;
        }
        return false;
    }

    public ArrayList<Correspondent> readCorrespondent() {
        ArrayList<Correspondent> list = new ArrayList<>();
        String query =
                "SELECT * FROM " + TABLE_CORRESPONDENT;
        SQLiteDatabase db = this.sqLiteOpenHelper. getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()) {
                Correspondent correspondent = new Correspondent();
                correspondent.setId(cursor.getString(0));
                correspondent.setAccount(cursor.getString(1));
                correspondent.setBalance(cursor.getString(2));
                correspondent.setName(cursor.getString(3));
                correspondent.setLastName(cursor.getString(4));
                correspondent.setIdentification(cursor.getString(5));
                correspondent.setMail(cursor.getString(6));
                correspondent.setPassword(cursor.getString(7));
                correspondent.setPhone(cursor.getString(8));
                correspondent.setAddress(cursor.getString(9));
                correspondent.setStatus(cursor.getString(10));

                list.add(correspondent);
            }
        }
        return list;
    }
    public ArrayList<Client> readClient() {
        ArrayList<Client> list = new ArrayList<>();
        String query =
                "SELECT * FROM " + TABLE_CLIENT;
        SQLiteDatabase db = this.sqLiteOpenHelper. getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
            while (cursor.moveToNext()) {
                Client client = new Client();
                client.setId(cursor.getString(0));
                client.setBalance(cursor.getString(1));
                client.setIdentification(cursor.getString(2));
                client.setName(cursor.getString(3));
                client.setLastName(cursor.getString(4));
                client.setCard(cursor.getString(5));
                client.setCardType(cursor.getString(6));
                client.setCvv(cursor.getString(7));
                client.setVen(cursor.getString(8));
                client.setPin(cursor.getString(9));
                client.setStatus(cursor.getString(10));

                list.add(client);
            }
        }
        return list;
    }
    public boolean upgradeStatusCorrespondent(Correspondent correspondent) {
        SQLiteDatabase db = this.sqLiteOpenHelper. getReadableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(COLUMN_CORRESPONDENT_STATUS, correspondent.getStatus());

        long result = db.update(TABLE_CORRESPONDENT, cv, "corresponsal_id=?", new String[]{correspondent.getId()});
        if (result == -1) {
            return true;
        } else {
            return false;
        }

    }
}
