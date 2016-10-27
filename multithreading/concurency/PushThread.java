package com.sudheer.hakers.rank.multithreading.concurency;

import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sudheer Babu Gutha.
 */
public class PushThread extends Thread {

    private final ReentrantLock lock = new ReentrantLock();
    int[] arr;
    private final Queue<Integer> queue;

    public PushThread(int[] arr, Queue<Integer> queue) {
        this.arr = arr;
        this.queue = queue;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < arr.length; i++) {
                queue.add(arr[i]);
            }
        } finally {
            lock.unlock();
        }
    }
}
