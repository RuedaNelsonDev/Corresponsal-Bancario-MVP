package com.example.corresponsalwpossmvp.model;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.CorresStatusModel;
import com.example.corresponsalwpossmvp.model.methods.Methods;
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.example.corresponsalwpossmvp.presenter.interfaces.CorresStatusPresenter;

public class CorresStatusModelImpl implements CorresStatusModel {
    CorresStatusPresenter presenter;
    Methods mtd;

    public CorresStatusModelImpl(CorresStatusPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void disableCorres(String id, Context context) {
        mtd = new Methods(context);
        Correspondent correspondent = new Correspondent();
        correspondent.setId(id);
        correspondent.setStatus("DESHABILITADO");
        mtd.upgradeStatusCorrespondent(correspondent);
        presenter.nextActivity("AdminShowCorres");

    }
}
