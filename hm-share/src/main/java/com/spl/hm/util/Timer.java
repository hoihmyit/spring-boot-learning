package com.spl.hm.util;

import java.util.concurrent.TimeUnit;

public class Timer {

    private final long startNS;

    private Timer() {
        startNS = System.nanoTime();
    }

    public static Timer start() {
        return new Timer();
    }

    public int getElapsedMS() {
        return (int) TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNS);
    }
}
