package com.example.corresponsalwpossmvp.presenter.interfaces;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.models.Client;

public interface AdminConfRegisClientPresenter {
    void showConfirmRegisClient();
    void registerClient(Client client, Context context);
    void alert(String btn);
    void nextActivity(String nextActivity);

}
