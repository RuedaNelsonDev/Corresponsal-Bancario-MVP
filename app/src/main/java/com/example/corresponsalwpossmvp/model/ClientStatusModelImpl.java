package com.example.corresponsalwpossmvp.model;

import com.example.corresponsalwpossmvp.model.interfaces.ClientStatusModel;
import com.example.corresponsalwpossmvp.presenter.interfaces.ClientStatusPresenter;

public class ClientStatusModelImpl implements ClientStatusModel {
    ClientStatusPresenter presenter;

    public ClientStatusModelImpl(ClientStatusPresenter presenter) {
        this.presenter = presenter;
    }
}
