package com.suri.designpattern.chainOfResponsibility;

/**

 */
public class EvenProcessor implements Chain {
  private Chain nextChain;

  @Override
  public void setNext(Chain chain) {
    nextChain = chain;
  }

  @Override
  public void process(Number request) {
    if (request.getNumber() % 2 == 0) {
      System.out.println(" Even processor " + request.getNumber());
    } else {
      nextChain.process(request);
    }

  }
}