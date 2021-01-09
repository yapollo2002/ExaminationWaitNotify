package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Waiter v = new Waiter();
        Starter s = new Starter(v);
        s.start();
        Finisher f = new Finisher(v);
        f.start();

    }
}

class Waiter  {
      
    synchronized void locker() {
        System.out.println("Loking on wait");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Unloked after wait state");
    }

    synchronized void unlocker() {
        System.out.println("Unloking state");
        notify();
        System.out.print("");

    }


}
 class Starter extends Thread{
    Waiter w;
     Starter(Waiter w){
         this.w = w;

     }
    public void run(){
        w.locker();
        System.out.print("Unlocked");

    }
 }

 class Finisher extends Thread{
    Waiter w;
    Finisher(Waiter w){
        this.w =w;
    }
    public void run(){
        w.unlocker();
    }
 }