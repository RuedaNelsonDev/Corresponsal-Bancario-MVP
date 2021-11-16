package com.example.corresponsalwpossmvp.model;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.ShowClientModel;
import com.example.corresponsalwpossmvp.model.methods.Methods;
import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.presenter.interfaces.ShowClientPresenter;

import java.util.ArrayList;

public class ShowClientModelImpl implements ShowClientModel {
    ShowClientPresenter presenter;
    Methods mtd;

    public ShowClientModelImpl(ShowClientPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void readClient(Client client, Context context) {

        mtd = new Methods(context);
        ArrayList lisClient = mtd.readClient();

        presenter.listClient(lisClient);
    }
}
