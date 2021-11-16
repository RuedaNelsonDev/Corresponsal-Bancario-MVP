package com.example.corresponsalwpossmvp.presenter;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.RegisCorresModel;
import com.example.corresponsalwpossmvp.model.RegisCorresModelImpl;
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.example.corresponsalwpossmvp.presenter.interfaces.RegisCorresPresenter;
import com.example.corresponsalwpossmvp.view.ViewInterface;

public class RegisCorresPresenterImpl implements RegisCorresPresenter {
    private RegisCorresPresenter regisCorresPresenter;
    private ViewInterface view;
    private RegisCorresModel regisCorresModel;

    public RegisCorresPresenterImpl( ViewInterface view ) {
        this.view = view;
        this.regisCorresModel = new RegisCorresModelImpl(this);

    }

    @Override
    public void showRegisCorres() {

    }

    @Override
    public void readCredentials(Correspondent correspondent, String confirmPassword, Context context) {
        regisCorresModel.registerCorres(correspondent, confirmPassword, context);

    }

    @Override
    public void message(String msg) {
        view.message(msg);
    }

    @Override
    public void nextClass(String nameClass) {
        view.navigateToActivity(nameClass);
    }


}
