package com.example.corresponsalwpossmvp.model.interfaces;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.models.Correspondent;

public interface RegisCorresModel {
    void registerCorres(Correspondent correspondent, String confirmPassword, Context context);

}
