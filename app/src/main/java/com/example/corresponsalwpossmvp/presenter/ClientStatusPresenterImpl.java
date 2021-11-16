package com.example.corresponsalwpossmvp.presenter;

import com.example.corresponsalwpossmvp.model.ClientStatusModelImpl;
import com.example.corresponsalwpossmvp.model.interfaces.ClientStatusModel;
import com.example.corresponsalwpossmvp.presenter.interfaces.ClientStatusPresenter;
import com.example.corresponsalwpossmvp.view.ViewInterface;

public class ClientStatusPresenterImpl implements ClientStatusPresenter {
    ViewInterface view;
    ClientStatusModel model;

    public ClientStatusPresenterImpl(ViewInterface view) {
        this.view = view;
        this.model = new ClientStatusModelImpl(this);
    }
}
