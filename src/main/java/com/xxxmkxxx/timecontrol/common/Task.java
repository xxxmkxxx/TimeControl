package com.xxxmkxxx.timecontrol.common;

public interface Task {
    String name();
    void changeAction(Runnable runnable);
    void execute();
}
