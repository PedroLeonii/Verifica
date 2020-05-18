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

    public static void main(String[] args) throws Exception {
        

    }

    private static void producer(){
        
        while (true) {
            if (product.size() < maxSize) {
                
            } else {
                
            }
        }
    }
    private static void consumer(){
        
    }

}