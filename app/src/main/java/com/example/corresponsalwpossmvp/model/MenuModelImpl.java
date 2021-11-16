package com.example.corresponsalwpossmvp.model;

import com.example.corresponsalwpossmvp.model.interfaces.MenuModel;
import com.example.corresponsalwpossmvp.presenter.interfaces.MenuAdminPresenter;

public class MenuModelImpl implements MenuModel {

    MenuAdminPresenter menuPresenter;


    public MenuModelImpl(MenuAdminPresenter menuPresenter) {
        this.menuPresenter = menuPresenter;
    }
}
