package com.sudheer.multithreading.concurency;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sudheer Babu Gutha.
 */
public class ValidateThread extends Thread {

    private final ReentrantLock lock = new ReentrantLock();
    private final Queue<Integer> queue;
    int endValue;

    public ValidateThread(Queue<Integer> queue, int endValue) {
        this.queue = queue;
        this.endValue = endValue;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (true) {
                int value = queue.poll();
                System.out.println(value + "  " + isPrime(value));
                if (value == endValue)
                    break;
            }
        } finally {
            lock.unlock();
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
