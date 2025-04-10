package com.suri.designpattern.strategy;

/**

 * Define a family of algorithms, encapsulate each one, and make them interchangeable.
 * Strategy lets the algorithm vary independently of the clients that use it.
 * Capture the abstraction in an interface, bury implementation details in derived classes.
 */
public class ShoppingCartStrategy {
  public static void main(String[] args) {
    ShoppingCart cart = new ShoppingCart();

    Item item1 = new Item("1234", 10);
    Item item2 = new Item("5678", 40);

    cart.addItem(item1);
    cart.addItem(item2);

    //pay by paypal
    cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));

    //pay by credit card
    cart.pay(new CreditCardStrategy("A Kumar", "1234567890123456", "786", "12/15"));
  }
}



