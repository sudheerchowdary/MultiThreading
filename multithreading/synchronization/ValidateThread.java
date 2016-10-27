package com.sudheer.hakers.rank.multithreading.synchronization;

import java.util.Queue;

/**
 * Created by Sudheer Babu Gutha.
 */
public class ValidateThread extends Thread {

    private final Queue<Integer> queue;
    int endValue;

    public ValidateThread(Queue<Integer> queue, int endValue) {
        this.queue = queue;
        this.endValue = endValue;
    }

    @Override
    public void run() {
        System.out.println("Validate Thread");
        while (true) {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                int value = queue.poll();
                System.out.println(value + "  " + isPrime(value));
                queue.notify();

                if (value == endValue)
                    break;
            }
        }
    }

    public boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
