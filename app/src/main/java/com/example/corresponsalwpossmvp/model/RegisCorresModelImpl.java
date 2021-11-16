package com.example.corresponsalwpossmvp.model;

import android.content.Context;
import android.text.TextUtils;

import com.example.corresponsalwpossmvp.model.interfaces.RegisCorresModel;
import com.example.corresponsalwpossmvp.model.methods.Methods;
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.example.corresponsalwpossmvp.presenter.interfaces.RegisCorresPresenter;

public class RegisCorresModelImpl implements RegisCorresModel {
    RegisCorresPresenter regisCorresPresenter;
    Methods mtd;


    public RegisCorresModelImpl(RegisCorresPresenter regisCorresPresenter) {
        this.regisCorresPresenter = regisCorresPresenter;
    }

    @Override
    public void registerCorres(Correspondent correspondent, String confirmPassword, Context context) {
        if (TextUtils.isEmpty(correspondent.getName()) ||
                TextUtils.isEmpty(correspondent.getLastName()) ||
                TextUtils.isEmpty(correspondent.getIdentification()) ||
                TextUtils.isEmpty(correspondent.getPhone()) ||
                TextUtils.isEmpty(correspondent.getAddress()) ||
                TextUtils.isEmpty(correspondent.getMail()) ||
                TextUtils.isEmpty(correspondent.getPassword()) ||
                TextUtils.isEmpty(confirmPassword)) {

            regisCorresPresenter.message("No deje campos vacios");
        } else {

            if (correspondent.getPassword().equals(confirmPassword)) {


                if (validateIdentification(correspondent, context)) {

                    regisCorresPresenter.message("Identificación ya registrada");
                } else {

                    if (validateEmail(correspondent, context)) {

                        regisCorresPresenter.message("Correo electronico ya registrado");
                    } else {


                        String numberAccount = addRight(254 + correspondent.getIdentification(), 16);
                        correspondent.setAccount(numberAccount);
                        regisCorresPresenter.nextClass("confRegisCorrres");

                    }
                }
            } else {

                regisCorresPresenter.message("Las contraseñas no coinciden");
            }
        }
    }

    public boolean validateIdentification(Correspondent correspondent, Context context) {
        mtd = new Methods(context);

        return mtd.validateIdentificationCorres(correspondent);

    }

    public boolean validateEmail(Correspondent correspondent, Context context) {
        mtd = new Methods(context);
        return mtd.validateMailCorres(correspondent);
    }

    public static String addRight(String start, int length) {
        start = start.trim();
        StringBuilder numberAcoount = new StringBuilder(length);
        int fill = length - start.length();
        numberAcoount.append(start);
        while (fill-- > 0)
            numberAcoount.append(Math.round(Math.random()*9));
        return numberAcoount.toString();

    }

}
