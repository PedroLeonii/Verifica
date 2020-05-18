package app;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    
    private int[] list = new int[10]; 
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }



}