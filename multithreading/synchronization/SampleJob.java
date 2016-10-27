package com.sudheer.multithreading.synchronization;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sudheer Babu Gutha.
 */
public class SampleJob {

    public static void main(String args[]) {
        Queue pushQueue = new LinkedList();

        int arr[] = {2, 3, 4, 7, 8, 9};
        int endValue = arr[arr.length-1];

        Thread pushThread = new PushThread(arr, pushQueue);
        Thread validateThread = new ValidateThread(pushQueue, endValue);

        pushThread.start();
        validateThread.start();

    }


}
