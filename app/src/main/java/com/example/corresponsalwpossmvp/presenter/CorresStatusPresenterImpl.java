package com.example.corresponsalwpossmvp.presenter;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.CorresStatusModel;
import com.example.corresponsalwpossmvp.model.CorresStatusModelImpl;
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.example.corresponsalwpossmvp.presenter.interfaces.CorresStatusPresenter;
import com.example.corresponsalwpossmvp.view.ViewInterface;

public class CorresStatusPresenterImpl implements CorresStatusPresenter {
    ViewInterface view;
    CorresStatusModel model;

    public CorresStatusPresenterImpl(ViewInterface view) {
        this.view = view;
        this.model = new CorresStatusModelImpl(this);
    }

    @Override
    public void showCorresStatus(Correspondent correspondent) {
        if (view != null) {
            view.showCorresStatus(correspondent);
        }
    }

    @Override
    public void disableCorres(String  id, Context context) {
        model.disableCorres(id, context);
    }

    @Override
    public void nextActivity(String activity) {
        view.navigateToActivity(activity);
    }

}
