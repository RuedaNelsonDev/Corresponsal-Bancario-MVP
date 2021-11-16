package com.example.corresponsalwpossmvp.model;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.ShowCorresModel;
import com.example.corresponsalwpossmvp.model.methods.Methods;
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.example.corresponsalwpossmvp.presenter.interfaces.ShowCorresPresenter;

import java.util.ArrayList;

public class ShowCorresModelImpl implements ShowCorresModel {
    ShowCorresPresenter presenter;
    Methods mtd;

    public ShowCorresModelImpl(ShowCorresPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void readCorrespondent(Correspondent correspondent, Context context) {
        mtd = new Methods(context);

        ArrayList listCorrespondent = mtd.readCorrespondent();

        presenter.listCorrespondet( listCorrespondent);
    }

}
