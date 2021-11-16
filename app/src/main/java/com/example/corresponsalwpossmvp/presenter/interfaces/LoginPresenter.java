package com.example.corresponsalwpossmvp.presenter.interfaces;

import android.content.Context;

public interface LoginPresenter {
    void showLogin();
    void valideCredentials(String mail, String password, Context context);
    void message(String message);
    void navigateToClass(String nameClass);
}
