package com.suri.designpattern.observer;


public class WeatherStation {

    public static void main(String[] args) {
        ISubject iSubject = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(iSubject);


        ((WeatherData) iSubject).setMeasurement(80, 65, 30.4f);
        ((WeatherData) iSubject).setMeasurement(82, 70, 29.4f);
        ((WeatherData) iSubject).setMeasurement(78, 90, 29.4f);
    }
}