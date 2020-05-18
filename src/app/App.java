package app;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    private static ArrayList<Integer> product = new ArrayList<>(10);
    private static int maxSize = 10;
    private static Lock lock = new ReentrantLock();
    private static Condition cond = lock.newCondition();

    public static void main(String[] args) {
        Thread th1 = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    producer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        });
        Thread th2 = new Thread(new Runnable() {

            @Override
            public void run() {

                try {
                    consumer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               
			}

        });

        th1.start();
        th2.start();

    }

    private static void producer() throws InterruptedException {
        Random random = new Random();
       
        lock.lock();
        try{
            while (true) {
                if (product.size() < maxSize) {

                    product.add(random.nextInt(100));
            
                } else {
                    System.out.println("magazzino pieno....");
                    
                    cond.signal();
                    cond.await();
                    
                }
            }
        }
        finally{
            lock.unlock();
        }
       
    }
    private static void consumer() throws InterruptedException {

       
        lock.lock();
        try{
            while (true) {
                if (product.size() > 0) {

                    product.remove(product.size()-1);
                
                } else {
                    System.out.println("magazzino vuoto....");
                    
                    cond.signal();
                    cond.await();
   
                }
            }
        }
        finally{
            lock.unlock();
        }

    }

}