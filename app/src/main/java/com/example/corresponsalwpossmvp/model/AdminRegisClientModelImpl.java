package com.example.corresponsalwpossmvp.model;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.corresponsalwpossmvp.model.interfaces.AdminRegisClientModel;
import com.example.corresponsalwpossmvp.model.methods.Methods;
import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.presenter.interfaces.AdminRegisClientPresenter;

import java.util.Formatter;

public class AdminRegisClientModelImpl implements AdminRegisClientModel {
    AdminRegisClientPresenter presenter;
    Methods mtd;

    public AdminRegisClientModelImpl(AdminRegisClientPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void readCredentials(Client client, String confirmPin, Context context) {

        if (TextUtils.isEmpty(client.getName()) ||
                TextUtils.isEmpty(client.getLastName()) ||
                TextUtils.isEmpty(client.getIdentification()) ||
                TextUtils.isEmpty(client.getBalance()) ||
                TextUtils.isEmpty(client.getPin()) ||
                TextUtils.isEmpty(confirmPin)) {

            presenter.message("No deje campos vacios");
        } else {

            if (client.getPin().equals(confirmPin)) {

                if (validateIdentifiaction(client, context)) {

                    presenter.message("Identificacion ya registrada");
                } else {
                    if (Integer.parseInt(client.getBalance()) > 10000) {

                        int newBalance = Integer.parseInt(client.getBalance()) - 10000;
                        client.setBalance(String.valueOf(newBalance));

                        client.setCard(generateCard(client, 16));
                        client.setCvv(cvv());
                        client.setVen(ven());
                        cardType(client, context);
                        presenter.nextActivity("AdminConfRegisClient");
                    } else {
                        presenter.alert("noMoney");
                    }
                }
            } else {

                presenter.message("Los Pin no coinciden");
            }
        }
    }

    public boolean validateIdentifiaction(Client client, Context context) {

        mtd = new Methods(context);
        return mtd.validateIdentificationClient(client);
    }

    public static final String cvv() {


        Formatter formatter = new Formatter();
        long cvv = (long) (1000L * Math.random());
        String newCvv = String.valueOf(formatter.format("%02d", cvv));
        return "" + cvv;
    }

    public static String ven( ) {
        Formatter formatter = new Formatter();
        int month = (int) (Math.random() * 12) + 1;
        String newMonth = String.valueOf(formatter.format("%02d", month));
        int year = (int) (22 + Math.round(Math.random() * 8));



        return "" + newMonth + "/" + year;

    }

    String generateCard(Client client, int length) {

        int number = (int) (3 + Math.round(Math.random() * 3));

        String starCard = String.valueOf(number) + client.getIdentification();

        starCard = starCard.trim();
        StringBuilder numberAcoount = new StringBuilder(length);
        int fill = length - starCard.length();
        numberAcoount.append(starCard);
        while (fill-- > 0)
            numberAcoount.append(Math.round(Math.random() * 9));
        return numberAcoount.toString();

    }

    void cardType(Client client, Context context) {
        String numberCard = client.getCard().substring(0, 1);

        String cardType = "";

        switch (numberCard) {
            case "3":
                cardType = "American Express";
                break;
            case "4":
                cardType = "Visa";
                break;
            case "5":
                cardType = "MasterCard";
                break;
            case "6":
                cardType = "UnionPay";
                break;
            default:
                Toast.makeText(context.getApplicationContext(), "Tarjeta Invalida", Toast.LENGTH_SHORT).show();

        }
        client.setCardType(cardType);
    }
}
