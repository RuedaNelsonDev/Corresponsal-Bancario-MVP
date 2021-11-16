package com.example.corresponsalwpossmvp.presenter;

import android.content.Context;

import com.example.corresponsalwpossmvp.model.interfaces.MenuModel;
import com.example.corresponsalwpossmvp.model.MenuModelImpl;
import com.example.corresponsalwpossmvp.presenter.interfaces.MenuAdminPresenter;
import com.example.corresponsalwpossmvp.view.ViewInterface;

public class MenuAdminPresenterImpl implements MenuAdminPresenter {
    private MenuAdminPresenter menuAdminPresenter;
    private ViewInterface view;
    private MenuModel menuModel;

    public MenuAdminPresenterImpl(Context context, ViewInterface view){
        this.view = view;
        MenuModel menuModel;
        this.menuModel = new MenuModelImpl(this);
    }
    @Override
    public void showMenuAdmin() {
        if (view != null) {
            view.showMenuAdmin();
        }
    }
}
