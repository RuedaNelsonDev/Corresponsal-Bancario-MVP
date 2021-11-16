package com.example.corresponsalwpossmvp.presenter.interfaces;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.models.Correspondent;

import java.util.ArrayList;

public interface ShowCorresPresenter {
    void showCorres();
    void readCorrespondent(Correspondent correspondent, Context context);
    void listCorrespondet(ArrayList listCorrespondent);
}
