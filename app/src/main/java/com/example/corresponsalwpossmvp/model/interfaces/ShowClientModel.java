package com.example.corresponsalwpossmvp.model.interfaces;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.model.models.Correspondent;

public interface ShowClientModel {
    void readClient(Client client, Context context);
}
