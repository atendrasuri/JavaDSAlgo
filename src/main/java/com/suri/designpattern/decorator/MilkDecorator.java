package com.suri.designpattern.decorator;

public class MilkDecorator extends CoffeeDecorator{

    MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription()+", MILK";
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost()+1.5;
    }
}
