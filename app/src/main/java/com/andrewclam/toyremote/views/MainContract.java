package com.andrewclam.toyremote.views;

public class MainContract {

  interface View {

    void showResultMsg(String msg);

  }

  interface Presenter{

    void setView(View view);

    void dropView();

    void onLightOffButtonClicked();

    void onLightOnButtonClicked();

    void onGarageDoorOpenButtonClicked();

    void onUndoButtonClicked();

  }
}
