package com.xxxmkxxx.timecontrol.common;

public class SimpleTask implements Task {
    private final String name;
    private Runnable runnable;

    public SimpleTask(String name, Runnable runnable) {
        this.name = name;
        this.runnable = runnable;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public void execute() {
        runnable.run();
    }
}
