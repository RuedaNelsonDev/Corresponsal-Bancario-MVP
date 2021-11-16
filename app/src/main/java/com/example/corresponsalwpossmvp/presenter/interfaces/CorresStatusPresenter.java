package com.example.corresponsalwpossmvp.presenter.interfaces;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.models.Correspondent;

public interface CorresStatusPresenter {
    void showCorresStatus(Correspondent correspondent);

    void disableCorres(String id, Context context);
    void nextActivity(String activity);
}
