package com.example.corresponsalwpossmvp.presenter.interfaces;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.model.models.Correspondent;

import java.util.ArrayList;

public interface ShowClientPresenter {
    void showAdminClient();
    void readClient(Client client, Context context);
    void listClient(ArrayList listClient);

}
