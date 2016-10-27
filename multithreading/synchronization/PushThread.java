package com.sudheer.hakers.rank.multithreading.synchronization;

import java.util.Queue;

/**
 * Created by Sudheer Babu Gutha.
 */
public class PushThread extends Thread {

    int[] arr;
    private final Queue<Integer> queue;

    public PushThread(int[] arr, Queue<Integer> queue) {
        this.arr = arr;
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Push Thread");
        for (int i = 0; i < arr.length; i++) {
            synchronized (queue) {
                while (queue.size() >= 1) {
                    try {
                        queue.add(arr[i]);
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                queue.add(arr[i]);
                queue.notify();
            }
        }
    }
}
