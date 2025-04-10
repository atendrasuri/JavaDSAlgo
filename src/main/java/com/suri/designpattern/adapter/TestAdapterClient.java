package com.suri.designpattern.adapter;

public class TestAdapterClient {
    public static void main(String[] args) {
        OldCharger oldCharger = new OldCharger();
        TypeCCharger typeCCharger = new ChargerAdapter(oldCharger);
        typeCCharger.chargeWithTypeC();
    }
}
