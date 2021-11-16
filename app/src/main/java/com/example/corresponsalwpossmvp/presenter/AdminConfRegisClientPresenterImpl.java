package com.example.corresponsalwpossmvp.presenter;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.AdminConfRegisClientModel;
import com.example.corresponsalwpossmvp.model.AdminConfRegisClientModelImpl;
import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.presenter.interfaces.AdminConfRegisClientPresenter;
import com.example.corresponsalwpossmvp.view.ViewInterface;

public class AdminConfRegisClientPresenterImpl implements AdminConfRegisClientPresenter {
    ViewInterface view;
    AdminConfRegisClientModel model;

    public AdminConfRegisClientPresenterImpl(ViewInterface view) {
        this.view = view;
        this.model = new AdminConfRegisClientModelImpl(this);
    }

    @Override
    public void showConfirmRegisClient() {
        if (view != null) {
            view.showAdminConfirmRegisClient();
        }
    }

    @Override
    public void registerClient(Client client, Context context) {

        model.registerClient(client, context);
    }


    @Override
    public void alert(String btn) {

        view.alertConfRegisCorres(btn);
    }


    @Override
    public void nextActivity(String nextActivity) {
        view.navigateToActivity(nextActivity);
    }
}
