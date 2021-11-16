package com.example.corresponsalwpossmvp.model.models;

public class Menu {
    String funcionMenu;
    String imagenMenu;


    public Menu(String funcionMenu, String imagenMenu) {
        this.funcionMenu = funcionMenu;
        this.imagenMenu = imagenMenu;
    }

    public String getFuncionMenu() {
        return funcionMenu;
    }

    public void setFuncionMenu(String funcionMenu) {
        this.funcionMenu = funcionMenu;
    }

    public String getImagenMenu() {
        return imagenMenu;
    }

    public void setImagenMenu(String imagenMenu) {
        this.imagenMenu = imagenMenu;
    }
}
