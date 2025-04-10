package com.suri.designpattern.decorator;

public class SugarDecorator extends CoffeeDecorator{

    SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {

        return decoratedCoffee.getDescription()+", SUGAR";
    }

    @Override
    public double cost() {

        return decoratedCoffee.cost()+1.5;
    }
}
