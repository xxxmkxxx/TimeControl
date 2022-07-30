package com.xxxmkxxx.timecontrol.stopwatch;

import com.xxxmkxxx.timecontrol.common.Ticked;

import java.util.HashMap;
import java.util.Map;

public class StopWatches implements Ticked {
    private final Map<String, StopWatch> STOP_WATCH_MAP = new HashMap<>(10);

    public void addStopWatch(String name, StopWatch stopWatch) {
        STOP_WATCH_MAP.putIfAbsent(name, stopWatch);
    }

    public StopWatch deleteStopWatch(String name) {
        return STOP_WATCH_MAP.remove(name);
    }

    public StopWatch getStopWatch(String name) {
        return STOP_WATCH_MAP.get(name);
    }

    @Override
    public void tick() {
        STOP_WATCH_MAP.entrySet().forEach(entry -> entry.getValue().tick());
    }
}
