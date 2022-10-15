package com.xxxmkxxx.timecontrol.ticker;

import com.xxxmkxxx.timecontrol.common.Task;

import java.util.HashMap;
import java.util.Map;

public class SimpleTicker implements Ticker {
    private final Map<String, Task> TASKS;

    public SimpleTicker() {
        this.TASKS = new HashMap();
    }

    @Override
    public void tick() {
        TASKS.forEach((s, task) -> task.execute());
    }

    @Override
    public void addTask(Task task) {
        TASKS.put(task.name(), task);
    }

    @Override
    public void removeTask(String name) {
        TASKS.remove(name);
    }

    @Override
    public void changeTask(String task, Runnable runnable) {
        TASKS.get(task).changeAction(runnable);
    }
}