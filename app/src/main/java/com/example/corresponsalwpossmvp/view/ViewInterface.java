package com.example.corresponsalwpossmvp.view;

import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.model.models.Correspondent;

import java.util.ArrayList;

public interface ViewInterface {
    void showLogin();
    void message(String msg);
    void navigateToActivity(String nameActivity);
    void showMenuAdmin();
    void showRegisCorres();
    void showConfRegisCorres();
    void alertConfRegisCorres(String btn);
    void showAdminRegisClient();
    void showAdminConfirmRegisClient();
    void showAdminCorres();
    void readCorrespondent(ArrayList listCorrespondent);
    void showCorresStatus(Correspondent correspondent);
    void showAdminClient();
    void readClient(ArrayList listClient);
    void showClientStatus(Client client);

}
