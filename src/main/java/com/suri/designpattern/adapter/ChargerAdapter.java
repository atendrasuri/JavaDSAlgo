package com.suri.designpattern.adapter;

public class ChargerAdapter implements TypeCCharger {

    private OldCharger oldCharger;

    public ChargerAdapter(OldCharger oldCharger){
        this.oldCharger = oldCharger;
    }
    @Override
    public void chargeWithTypeC() {
        System.out.println("Adapter converting Type-C request to micro-USB");
        oldCharger.chargeWithMicroUSB();

    }
}
