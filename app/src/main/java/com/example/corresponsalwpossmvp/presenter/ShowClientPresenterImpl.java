package com.example.corresponsalwpossmvp.presenter;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.ShowClientModel;
import com.example.corresponsalwpossmvp.model.ShowClientModelImpl;
import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.presenter.interfaces.ShowClientPresenter;
import com.example.corresponsalwpossmvp.view.ViewInterface;

import java.util.ArrayList;

public class ShowClientPresenterImpl implements ShowClientPresenter {
    ViewInterface view;
    ShowClientModel model;

    public ShowClientPresenterImpl(ViewInterface view) {
        this.view = view;
        this.model = new ShowClientModelImpl(this);
    }

    @Override
    public void showAdminClient() {
        view.showAdminClient();
    }

    @Override
    public void readClient(Client client, Context context) {
        model.readClient(client, context);
    }

    @Override
    public void listClient(ArrayList listClient) {
        view.readClient(listClient);
    }
}
