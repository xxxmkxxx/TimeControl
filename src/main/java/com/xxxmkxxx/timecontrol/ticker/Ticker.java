package com.xxxmkxxx.timecontrol.ticker;

import com.xxxmkxxx.timecontrol.common.Task;
import com.xxxmkxxx.timecontrol.common.Ticked;

public interface Ticker  extends Ticked {
    void addTask(Task task);
    void removeTask(String name);
}
