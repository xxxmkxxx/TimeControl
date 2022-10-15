package com.xxxmkxxx.timecontrol.ticker;

import com.xxxmkxxx.timecontrol.common.SimpleTask;
import com.xxxmkxxx.timecontrol.common.Task;

public record TickerController(Ticker TICKER) {
    public void createTickerTask(String name, Runnable runnable) {
        Task task = new SimpleTask(name, runnable);

        TICKER.addTask(task);
    }

    public void changeTask(String name, Runnable runnable) {
        TICKER.changeTask(name, runnable);
    }
}
