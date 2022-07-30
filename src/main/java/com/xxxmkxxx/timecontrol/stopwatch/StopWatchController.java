package com.xxxmkxxx.timecontrol.stopwatch;

public record StopWatchController(StopWatches STOP_WATCHES) {
    public StopWatch createStopWatch(String name) {
        StopWatch stopWatch = new SimpleStopWatch();

        STOP_WATCHES.addStopWatch(name, stopWatch);

        return stopWatch;
    }

}
