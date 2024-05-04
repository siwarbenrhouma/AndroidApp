package com.example.mesuredeniveaudeglycmie.controller;

import com.example.mesuredeniveaudeglycmie.Model.Patient;

public class Controller {
    private static Patient patient;
    private static Controller instance =null;
    private Controller(){
        super();
    }
    public static final Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;

    }
    public void createPatient(int age, float valeurMesuree, boolean isFasting){
        patient= new Patient(age ,valeurMesuree,isFasting);
    }
    public String getResult(){
        return patient.getResult();
    }
}
