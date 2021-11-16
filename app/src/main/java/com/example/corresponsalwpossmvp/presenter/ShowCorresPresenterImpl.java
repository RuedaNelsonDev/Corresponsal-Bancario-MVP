package com.example.corresponsalwpossmvp.presenter;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.ShowCorresModel;
import com.example.corresponsalwpossmvp.model.ShowCorresModelImpl;
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.example.corresponsalwpossmvp.presenter.interfaces.ShowCorresPresenter;
import com.example.corresponsalwpossmvp.view.ViewInterface;

import java.util.ArrayList;

public class ShowCorresPresenterImpl implements ShowCorresPresenter {
    ViewInterface view;
    ShowCorresModel model;

    public ShowCorresPresenterImpl(ViewInterface view) {
        this.view = view;
        this.model = new ShowCorresModelImpl(this);
    }

    @Override
    public void showCorres() {
        view.showAdminCorres();
    }

    @Override
    public void readCorrespondent(Correspondent correspondent, Context context) {
        model.readCorrespondent(correspondent, context);
    }

    @Override
    public void listCorrespondet(ArrayList listCorrespondent) {
        view.readCorrespondent(listCorrespondent);
    }
}
