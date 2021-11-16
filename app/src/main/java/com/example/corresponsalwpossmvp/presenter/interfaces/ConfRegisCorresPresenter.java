package com.example.corresponsalwpossmvp.presenter.interfaces;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.models.Correspondent;

public interface ConfRegisCorresPresenter {
    void showConfRegisCorres();
    void regisCorresponsal(Correspondent correspondent, Context context);
    void alert(String btn);
    void nextActivity(String nameActivity);

}
