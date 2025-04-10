package com.suri.designpattern.chainOfResponsibility;

/**

 Definition- Chain-of-Responsibility allows multiple objects(handler) to process a request sequentially.
 Each handler in the chain either process the request ot passes it to the next handler.

 "Use Chain-of-Responsibility design pattern when you want to give more than object a chance to handle a request"

 Each Object in the chain act as a handler and has a successor object . If it can handle the request, it does; otherwise it forward the request to it's successor.
 */
public class TestChainOfRes {
  public static void main(String[] args) {

    Chain c1 = new EvenProcessor();

    Chain c2 = new OddProcessor();

    c1.setNext(c2);

    c1.process(new Number(3));
    c1.process(new Number(5));
  }
}