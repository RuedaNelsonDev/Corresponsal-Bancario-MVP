package com.example.corresponsalwpossmvp.model;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.ConfRegisCorresModel;
import com.example.corresponsalwpossmvp.model.methods.Methods;
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.example.corresponsalwpossmvp.presenter.interfaces.ConfRegisCorresPresenter;

public class ConfRegisCorresModelImpl implements ConfRegisCorresModel {

    ConfRegisCorresPresenter presenter;
    Methods mtd;


    public ConfRegisCorresModelImpl(ConfRegisCorresPresenter confRegisCorresPresenter) {

        presenter = confRegisCorresPresenter;
    }

    @Override
    public void regisCorrespondent(Correspondent correspondent, Context context) {

        registerCorrespondent(correspondent, context);
        presenter.nextActivity("AdminMenu");
        presenter.alert("acceptRegister");
    }

    void registerCorrespondent(Correspondent correspondent, Context context) {

        mtd = new Methods(context);

        mtd.addCorrespondent(correspondent);
    }
}
