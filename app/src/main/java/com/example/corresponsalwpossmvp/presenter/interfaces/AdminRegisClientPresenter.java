package com.example.corresponsalwpossmvp.presenter.interfaces;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.models.Client;

public interface AdminRegisClientPresenter {
    void readCredentials(Client client, String confirmPin, Context context);
    void message(String msg);
    void nextActivity(String nameActivity);
    void alert(String alert);
}
