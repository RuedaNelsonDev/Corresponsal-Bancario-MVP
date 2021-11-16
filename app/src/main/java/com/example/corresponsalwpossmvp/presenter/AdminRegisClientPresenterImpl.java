package com.example.corresponsalwpossmvp.presenter;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.AdminRegisClientModel;
import com.example.corresponsalwpossmvp.model.AdminRegisClientModelImpl;
import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.presenter.interfaces.AdminRegisClientPresenter;
import com.example.corresponsalwpossmvp.view.ViewInterface;

public class AdminRegisClientPresenterImpl implements AdminRegisClientPresenter {
    ViewInterface view;
    AdminRegisClientModel model;

    public AdminRegisClientPresenterImpl(ViewInterface view) {
        this.view = view;
        this.model = new AdminRegisClientModelImpl(this);
    }

    @Override
    public void readCredentials(Client client, String confirmPin, Context context) {
        model.readCredentials(client, confirmPin, context);
    }

    @Override
    public void message(String msg) {
        view.message(msg);
    }

    @Override
    public void nextActivity(String nameActivity) {
        view.navigateToActivity(nameActivity);
    }

    @Override
    public void alert(String alert) {
        view.alertConfRegisCorres(alert);
    }
}
