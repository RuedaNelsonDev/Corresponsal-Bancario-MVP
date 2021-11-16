package com.example.corresponsalwpossmvp.presenter.interfaces;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.models.Correspondent;

public interface RegisCorresPresenter {
    void showRegisCorres();
    void readCredentials(Correspondent correspondent, String confirmPassword, Context context);
    void message(String msg);
    void nextClass(String nameClass);
}
