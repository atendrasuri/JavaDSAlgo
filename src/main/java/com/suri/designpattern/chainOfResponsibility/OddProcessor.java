package com.suri.designpattern.chainOfResponsibility;

/**

 */
public class OddProcessor implements Chain {

  private Chain nextChain;
  @Override
  public void setNext(Chain chain) {

    nextChain = chain;
  }

  @Override
  public void process(Number request) {

    if(request.getNumber()%2!=0){
      System.out.println("Odd Processor "+request.getNumber());
    }else{
      nextChain.process(request);
    }

  }
}