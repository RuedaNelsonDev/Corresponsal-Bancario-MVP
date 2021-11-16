package com.example.corresponsalwpossmvp.presenter;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.ConfRegisCorresModel;
import com.example.corresponsalwpossmvp.model.ConfRegisCorresModelImpl;
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.example.corresponsalwpossmvp.presenter.interfaces.ConfRegisCorresPresenter;
import com.example.corresponsalwpossmvp.view.ViewInterface;

public class ConfRegisCorresPresenterImpl implements ConfRegisCorresPresenter {
private ViewInterface view;
private ConfRegisCorresModel model;

    public ConfRegisCorresPresenterImpl(ViewInterface view) {
        this.view = view;
        this.model = new ConfRegisCorresModelImpl(this);
    }

    @Override
    public void showConfRegisCorres() {
        if (view != null) {
            view.showConfRegisCorres();
        }
    }

    @Override
    public void regisCorresponsal(Correspondent correspondent, Context context) {
        model.regisCorrespondent(correspondent,context);
    }


    @Override
    public void alert(String btn) {
        view.alertConfRegisCorres(btn);
    }

    @Override
    public void nextActivity(String nameActivity) {
        view.navigateToActivity(nameActivity);
    }
}
