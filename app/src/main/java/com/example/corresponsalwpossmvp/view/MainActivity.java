package com.example.corresponsalwpossmvp.view;

import static com.example.corresponsalwpossmvp.tools.Constant.REGISTER_CLIENT;
import static com.example.corresponsalwpossmvp.tools.Constant.REGISTER_CLIENT_IMG;
import static com.example.corresponsalwpossmvp.tools.Constant.REGISTER_CORRESPONDENT;
import static com.example.corresponsalwpossmvp.tools.Constant.REGISTER_CORRESPONDENT_IMG;
import static com.example.corresponsalwpossmvp.tools.Constant.SHOW_CLIENT;
import static com.example.corresponsalwpossmvp.tools.Constant.SHOW_CLIENT_IMG;
import static com.example.corresponsalwpossmvp.tools.Constant.SHOW_CORRESPONDENT;
import static com.example.corresponsalwpossmvp.tools.Constant.SHOW_CORRESPONDENT_IMG;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.corresponsalwpossmvp.R;
import com.example.corresponsalwpossmvp.databinding.ActivityDataClientBinding;
import com.example.corresponsalwpossmvp.databinding.ActivityDataCorrespondentBinding;
import com.example.corresponsalwpossmvp.databinding.ActivityLoginBinding;
import com.example.corresponsalwpossmvp.databinding.ActivityMenuBinding;
import com.example.corresponsalwpossmvp.databinding.ActivityRegisterClientBinding;
import com.example.corresponsalwpossmvp.databinding.ActivityRegisterCorrespondentBinding;
import com.example.corresponsalwpossmvp.databinding.ActivityShowCreatedBinding;
import com.example.corresponsalwpossmvp.model.models.Client;
import com.example.corresponsalwpossmvp.model.models.Correspondent;
import com.example.corresponsalwpossmvp.model.models.Menu;
import com.example.corresponsalwpossmvp.presenter.interfaces.AdminConfRegisClientPresenter;
import com.example.corresponsalwpossmvp.presenter.AdminConfRegisClientPresenterImpl;
import com.example.corresponsalwpossmvp.presenter.interfaces.AdminRegisClientPresenter;
import com.example.corresponsalwpossmvp.presenter.AdminRegisClientPresenterImpl;
import com.example.corresponsalwpossmvp.presenter.interfaces.ConfRegisCorresPresenter;
import com.example.corresponsalwpossmvp.presenter.ConfRegisCorresPresenterImpl;
import com.example.corresponsalwpossmvp.presenter.interfaces.CorresStatusPresenter;
import com.example.corresponsalwpossmvp.presenter.CorresStatusPresenterImpl;
import com.example.corresponsalwpossmvp.presenter.interfaces.LoginPresenter;
import com.example.corresponsalwpossmvp.presenter.LoginPresenterImpl;
import com.example.corresponsalwpossmvp.presenter.interfaces.MenuAdminPresenter;
import com.example.corresponsalwpossmvp.presenter.MenuAdminPresenterImpl;
import com.example.corresponsalwpossmvp.presenter.interfaces.RegisCorresPresenter;
import com.example.corresponsalwpossmvp.presenter.RegisCorresPresenterImpl;
import com.example.corresponsalwpossmvp.presenter.interfaces.ShowClientPresenter;
import com.example.corresponsalwpossmvp.presenter.ShowClientPresenterImpl;
import com.example.corresponsalwpossmvp.presenter.interfaces.ShowCorresPresenter;
import com.example.corresponsalwpossmvp.presenter.ShowCorresPresenterImpl;
import com.example.corresponsalwpossmvp.view.adapters.MenuAdminAdapter;
import com.example.corresponsalwpossmvp.view.adapters.ShowClientCreatedsAdapter;
import com.example.corresponsalwpossmvp.view.adapters.ShowCorresCreatedAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ViewInterface, android.view.View.OnClickListener {

    private LoginPresenter loginPresenter;
    private MenuAdminPresenter menuAdminPresenter;
    private RegisCorresPresenter regisCorresPresenter;
    private ConfRegisCorresPresenter confRegisCorresPresenter;
    private AdminRegisClientPresenter adminRegisClientPresenter;
    private AdminConfRegisClientPresenter adminConfRegisClientPresenter;
    private ShowCorresPresenter showCorresPresenter;
    private CorresStatusPresenter corresStatusPresenter;
    private ShowClientPresenter showClientPresenter;
    Correspondent correspondent = new Correspondent();
    Client client = new Client();

    String nameActivity;

    String id;

    ActivityLoginBinding bL;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginPresenter = new LoginPresenterImpl(this, this);
        loginPresenter.showLogin();

    }


    @Override
    public void showLogin() {
        setContentView(R.layout.activity_login);
        bL = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(bL.getRoot());
        nameActivity = "login";
    }

    @Override
    public void message(String msg) {

        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

    }

    public void btnLogin(android.view.View view) {

        loginPresenter.valideCredentials(bL.tietLoginMail.getText().toString(), bL.tietLoginPassword.getText().toString(), MainActivity.this);
    }

    @Override
    public void navigateToActivity(String nameActivity) {
        switch (nameActivity) {
            case "register":/*
                presenter.showRegister();*/
                break;
            case "Login":
                loginPresenter.showLogin();
                break;
            case "confRegisCorrres":
                confRegisCorresPresenter = new ConfRegisCorresPresenterImpl(this);
                confRegisCorresPresenter.showConfRegisCorres();
                break;
            case "AdminMenu":
                menuAdminPresenter = new MenuAdminPresenterImpl(this, this);
                menuAdminPresenter.showMenuAdmin();
                break;
            case "AdminConfRegisClient":
                adminConfRegisClientPresenter = new AdminConfRegisClientPresenterImpl(this);
                adminConfRegisClientPresenter.showConfirmRegisClient();
                break;
            case "AdminShowCorres":
                showCorresPresenter = new ShowCorresPresenterImpl(this);
                showCorresPresenter.showCorres();
                break;
            case "CorresStatus":
                corresStatusPresenter = new CorresStatusPresenterImpl(this);
                corresStatusPresenter.showCorresStatus(correspondent);
                break;
            case "AdminShowClient":
                showClientPresenter = new ShowClientPresenterImpl(this) {
                };
                showClientPresenter.showAdminClient();
                break;

            default:
                break;
        }

    }

    ActivityMenuBinding bM;

    @Override
    public void showMenuAdmin() {
        setContentView(R.layout.activity_menu);
        bM = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(bM.getRoot());
        nameActivity = "MenuAdmin";
        MenuAdminAdapter menuAdminAdapter;
        ArrayList<Menu> listMenu;

        listMenu = new ArrayList<>();

        listMenu.add(new Menu(REGISTER_CORRESPONDENT, REGISTER_CORRESPONDENT_IMG));
        listMenu.add(new Menu(REGISTER_CLIENT, REGISTER_CLIENT_IMG));
        listMenu.add(new Menu(SHOW_CORRESPONDENT, SHOW_CORRESPONDENT_IMG));
        listMenu.add(new Menu(SHOW_CLIENT, SHOW_CLIENT_IMG));

        menuAdminAdapter = new MenuAdminAdapter(MainActivity.this, listMenu, MainActivity.this::clickListener);
        bM.rvMenu.setAdapter(menuAdminAdapter);
        bM.rvMenu.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
    }


    public void clickListener(Menu menu) {
        switch (menu.getFuncionMenu()) {
            case REGISTER_CORRESPONDENT:

                regisCorresPresenter = new RegisCorresPresenterImpl(this);
                showRegisCorres();
                break;
            case REGISTER_CLIENT:
                adminRegisClientPresenter = new AdminRegisClientPresenterImpl(this);
                showAdminRegisClient();
                break;
            case SHOW_CORRESPONDENT:
                showCorresPresenter = new ShowCorresPresenterImpl(this);
                showCorresPresenter.showCorres();
                break;
            case SHOW_CLIENT:
                showClientPresenter = new ShowClientPresenterImpl(this);
                showClientPresenter.showAdminClient();
                break;

            default:

        }
    }

    ActivityRegisterCorrespondentBinding bRC;

    @Override
    public void showRegisCorres() {
        setContentView(R.layout.activity_register_correspondent);
        bRC = ActivityRegisterCorrespondentBinding.inflate(getLayoutInflater());
        setContentView(bRC.getRoot());
        nameActivity = "RegisCorres";
        correspondent = new Correspondent();
    }


    public void btnRegisCorres(android.view.View view) {

        correspondent.setName(bRC.tietCorresName.getText().toString());
        correspondent.setLastName(bRC.tietCorresLastName.getText().toString());
        correspondent.setIdentification(bRC.tietCorresIdentication.getText().toString());
        correspondent.setPhone(bRC.tietCorresPhone.getText().toString());
        correspondent.setAddress(bRC.tietCorresAddress.getText().toString());
        correspondent.setMail(bRC.tietCorresMail.getText().toString());
        correspondent.setPassword(bRC.tietCorresPassword.getText().toString());
        String confirmPassword = bRC.tietCorresConfiPassword.getText().toString();

        regisCorresPresenter.readCredentials(correspondent, confirmPassword, MainActivity.this);


    }

    ActivityDataCorrespondentBinding bCRC;

    @Override
    public void showConfRegisCorres() {
        setContentView(R.layout.activity_data_correspondent);
        bCRC = ActivityDataCorrespondentBinding.inflate(getLayoutInflater());
        setContentView(bCRC.getRoot());
        nameActivity = "ConfRegisCorres";
        bCRC.btnAccountAccept.setVisibility(View.VISIBLE);
        bCRC.btnAccountCancel.setVisibility(View.VISIBLE);

        correspondent.setStatus("HABILITADO");
        correspondent.setBalance("2000000");

        bCRC.tvCorresStatus.setText(correspondent.getStatus());
        bCRC.tvCorresName.setText(correspondent.getName());
        bCRC.tvCorresLastName.setText(correspondent.getLastName());
        bCRC.tvCorresIdentification.setText(correspondent.getIdentification());
        bCRC.tvCorresAccount.setText(correspondent.getAccount());
        bCRC.tvCorresBalance.setText(correspondent.getBalance());
        bCRC.tvCorresPhone.setText(correspondent.getPhone());
        bCRC.tvCorresAddress.setText(correspondent.getAddress());
        bCRC.tvCorresMail.setText(correspondent.getMail());
    }

    @Override
    public void alertConfRegisCorres(String btn) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (btn) {
            case "acceptRegister":
                builder.setView(R.layout.layout_alert_correct);
                break;
            case "cancelRegister":
                builder.setView(R.layout.layout_alert_error);
                break;
            case "noMoney":
                builder.setView(R.layout.layout_alert_no_money);
                break;
            case "alertCorresEnable":
                builder.setView(R.layout.layout_alert_enable);
                break;
            case "alertCorresDisable":
                builder.setView(R.layout.layout_alert_disable);
                break;
        }
        final AlertDialog mDialog = builder.create();
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        if (!btn.equals("alertCorresEnable") || !btn.equals("alertCorresDisable")) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mDialog.isShowing()) mDialog.dismiss();
                }
            }, 4000);

        }
    }


    public void btnCancelRegisCorres(android.view.View view) {
        alertConfRegisCorres("cancelRegister");
        menuAdminPresenter.showMenuAdmin();
    }

    public void btnAccpetRegisCorres(android.view.View view) {
        confRegisCorresPresenter.regisCorresponsal(correspondent, MainActivity.this);
    }


    ActivityRegisterClientBinding bARC;

    @Override
    public void showAdminRegisClient() {
        setContentView(R.layout.activity_register_client);
        bARC = ActivityRegisterClientBinding.inflate(getLayoutInflater());
        setContentView(bARC.getRoot());
        nameActivity = "AdminRegisClient";
        bARC.btnAdminClientRegis.setVisibility(View.VISIBLE);
    }


    public void btnAdminClientRegis(android.view.View view) {

        client.setName(bARC.tietClientName.getText().toString());
        client.setLastName(bARC.tietClientLastName.getText().toString());
        client.setIdentification(bARC.tietClientIdentification.getText().toString());
        client.setBalance(bARC.tietClientBalance.getText().toString());
        client.setPin(bARC.tietClientPin.getText().toString());
        String confirmPin = bARC.tietClientConfPin.getText().toString();

        adminRegisClientPresenter.readCredentials(client, confirmPin, MainActivity.this);
    }

    ActivityDataClientBinding bACRC;

    @Override
    public void showAdminConfirmRegisClient() {

        setContentView(R.layout.activity_data_client);
        bACRC = ActivityDataClientBinding.inflate(getLayoutInflater());
        setContentView(bACRC.getRoot());
        nameActivity = "AdminConfRegisClient";

        bACRC.btnClientAccept.setVisibility(View.VISIBLE);
        bACRC.btnClientCancel.setVisibility(View.VISIBLE);

        client.setStatus("Habilitado");

        bACRC.tvClientStatus.setText(client.getStatus());
        bACRC.tvClientName.setText(client.getName());
        bACRC.tvClientLastName.setText(client.getLastName());
        bACRC.tvClientIdentification.setText(client.getLastName());
        bACRC.tvClientBalance.setText(client.getBalance());
        bACRC.tvCardType.setText(client.getCardType());
        bACRC.tvCardNumber.setText(client.getCard());
        bACRC.tvCardName.setText(client.getName());
        bACRC.tvCardLastName.setText(client.getLastName());
        bACRC.tvCardVen.setText(client.getVen());
        bACRC.tvCardCvv.setText(client.getCvv());
    }


    public void btnClientAccept(android.view.View view) {
        adminConfRegisClientPresenter.registerClient(client, MainActivity.this);
    }

    public void btnClientCancel(android.view.View view) {
        alertConfRegisCorres("cancelRegister");
        showMenuAdmin();
    }

    ActivityShowCreatedBinding bASC;

    @Override
    public void showAdminCorres() {
        setContentView(R.layout.activity_show_created);
        bASC = ActivityShowCreatedBinding.inflate(getLayoutInflater());
        setContentView(bASC.getRoot());
        nameActivity = "AdminShowCorres";

        showCorresPresenter.readCorrespondent(correspondent, MainActivity.this);
    }


    @Override
    public void readCorrespondent(ArrayList listCorrespondent) {

        ShowCorresCreatedAdapter showCorrespondetsAdapter;

        showCorrespondetsAdapter = new ShowCorresCreatedAdapter(MainActivity.this, listCorrespondent, this);
        bASC.rvShowCreateds.setAdapter(showCorrespondetsAdapter);
        bASC.rvShowCreateds.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
    }

    ActivityDataCorrespondentBinding bADCS;

    @Override
    public void showCorresStatus(Correspondent correspondent) {
        setContentView(R.layout.activity_data_correspondent);
        bADCS = ActivityDataCorrespondentBinding.inflate(getLayoutInflater());
        setContentView(bADCS.getRoot());
        corresStatusPresenter = new CorresStatusPresenterImpl(this);
        nameActivity = "AdminDataCorres";

        bADCS.btnAccountEnable.setVisibility(View.VISIBLE);
        bADCS.btnAccountDisable.setVisibility(View.VISIBLE);

        bADCS.tvCorresStatus.setText(correspondent.getStatus());
        bADCS.tvCorresName.setText(correspondent.getName());
        bADCS.tvCorresLastName.setText(correspondent.getLastName());
        bADCS.tvCorresIdentification.setText(correspondent.getIdentification());
        bADCS.tvCorresAccount.setText(correspondent.getAccount());
        bADCS.tvCorresBalance.setText(correspondent.getBalance());
        bADCS.tvCorresPhone.setText(correspondent.getPhone());
        bADCS.tvCorresAddress.setText(correspondent.getAddress());
        bADCS.tvCorresMail.setText(correspondent.getMail());
        id = correspondent.getId();
    }

    //MOSTRAR CLIENTES CREADOS
    @Override
    public void showAdminClient() {
        setContentView(R.layout.activity_data_correspondent);
        bASC = ActivityShowCreatedBinding.inflate(getLayoutInflater());
        setContentView(bASC.getRoot());
        nameActivity = "AdminShowClient";
        showClientPresenter.readClient(client, MainActivity.this);
    }

    @Override
    public void readClient(ArrayList listClient) {
        ShowClientCreatedsAdapter showClientCreatedsAdapter = new ShowClientCreatedsAdapter(MainActivity.this, listClient, this);

        bASC.rvShowCreateds.setAdapter(showClientCreatedsAdapter);
        bASC.rvShowCreateds.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
    }

    @Override
    public void showClientStatus(Client client) {

    }


    public void btnCorresDisable(android.view.View view) {
        alertConfRegisCorres("alertCorresDisable");
    }


    public void btnAlertDisableYes(android.view.View view) {

        corresStatusPresenter.disableCorres(id, MainActivity.this);
    }

    public void btnAlertDisableNo(android.view.View view) {
        navigateToActivity("AdminShowCorres");
    }


    @Override
    public void onClick(android.view.View v) {

    }

    @Override
    public void onBackPressed() {
        switch (nameActivity) {
            case "login":
            case "MenuAdmin":
                super.onBackPressed();
                break;
            case "RegisCorres":
            case "AdminRegisClient":
            case "AdminShowCorres":
            case "AdminShowClient":
                menuAdminPresenter.showMenuAdmin();
                break;
            case "ConfRegisCorres":
                regisCorresPresenter.showRegisCorres();
                break;
            default:
                super.onBackPressed();
                onDestroy();

        }
    }
}