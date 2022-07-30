package com.xxxmkxxx.timecontrol.stopwatch;

public class SimpleStopWatch implements StopWatch {
    private long countTicks = 0;

    @Override
    public long getCountTicks() {
        return countTicks;
    }

    @Override
    public void tick() {
        countTicks++;
    }
}
