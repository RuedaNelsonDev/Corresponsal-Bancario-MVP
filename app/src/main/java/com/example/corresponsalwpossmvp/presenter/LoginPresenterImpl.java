package com.example.corresponsalwpossmvp.presenter;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.LoginModel;
import com.example.corresponsalwpossmvp.model.LoginModelImpl;
import com.example.corresponsalwpossmvp.presenter.interfaces.LoginPresenter;
import com.example.corresponsalwpossmvp.view.ViewInterface;


public class LoginPresenterImpl implements LoginPresenter {
    private ViewInterface view;
    private LoginModel loginModel;

    public LoginPresenterImpl(Context context, ViewInterface view) {
        this.view = view;
        this.loginModel = new LoginModelImpl(context, this);
    }

    @Override
    public void showLogin() {
        if (view != null) {
            view.showLogin();
        }
    }

    @Override
    public void valideCredentials(String mail, String password, Context context) {
        loginModel.login(mail, password, context);

    }


    @Override
    public void message(String message) {
        view.message(message);

    }

    @Override
    public void navigateToClass(String nameClass) {
        if (view != null) {
            view.navigateToActivity(nameClass);
        }
    }
}
