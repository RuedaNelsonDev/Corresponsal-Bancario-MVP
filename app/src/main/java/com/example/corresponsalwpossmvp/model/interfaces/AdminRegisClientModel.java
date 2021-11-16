package com.example.corresponsalwpossmvp.model.interfaces;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.models.Client;

public interface AdminRegisClientModel {
    void readCredentials(Client client, String confirmPin, Context context);
}
