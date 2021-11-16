package com.example.corresponsalwpossmvp.model;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.AdminConfRegisClientModel;
import com.example.corresponsalwpossmvp.model.methods.Methods;
import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.presenter.interfaces.AdminConfRegisClientPresenter;

public class AdminConfRegisClientModelImpl implements AdminConfRegisClientModel {
    AdminConfRegisClientPresenter presenter;
    Methods mtd;

    public AdminConfRegisClientModelImpl(AdminConfRegisClientPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void registerClient(Client client, Context context) {
        regisClient(client, context);
        presenter.nextActivity("AdminMenu");
        presenter.alert("acceptRegister");

    }

    void regisClient(Client client, Context context) {

        mtd = new Methods(context);

        mtd.addClient(client);

    }
}
