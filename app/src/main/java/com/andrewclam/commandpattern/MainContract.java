package com.andrewclam.commandpattern;

public class MainContract {

  interface View {

    void showResultMsg(String msg);

  }

  interface Presenter{

    void setView(View view);

    void dropView();

    void onLightOffButtonClicked();

    void onLightOnButtonClicked();

  }
}
