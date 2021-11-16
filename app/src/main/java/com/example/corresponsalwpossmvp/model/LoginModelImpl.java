package com.example.corresponsalwpossmvp.model;

import android.content.Context;
import android.text.TextUtils;

import com.example.corresponsalwpossmvp.model.interfaces.LoginModel;
import com.example.corresponsalwpossmvp.model.methods.Methods;
import com.example.corresponsalwpossmvp.model.models.Admin;
import com.example.corresponsalwpossmvp.presenter.interfaces.LoginPresenter;

public class LoginModelImpl implements LoginModel {

    LoginPresenter loginPresenter;
    Methods mtd;
    Admin admin = new Admin();

    public LoginModelImpl(Context context, LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void login(String mail, String password, Context context) {
        if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(password)) {
            loginPresenter.message("Requiere llenar todos los espacios");
        } else {

            if (mail.equals(admin.getMailAdmin())
                    && password.equals(admin.getPasswordaAdmin())) {

                if (validateAdmin(admin, context)) {

                    loginPresenter.navigateToClass("AdminMenu");
                    loginPresenter.message("Bienvenido Administrador");
                } else {

                    addAdmin(admin, context);
                    loginPresenter.navigateToClass("AdminMenu");
                    loginPresenter.message("Bienvenido Nuevo Administrador");
                }
            } else {

                loginPresenter.message("Error");
            }
        }
    }

    public void addAdmin(Admin admin, Context context) {
        mtd = new Methods(context);

        mtd.addAdmin(admin);
    }

    public boolean validateAdmin(Admin admin, Context context) {
        mtd = new Methods(context);

        return mtd.validateAdmin(admin);
    }
}

