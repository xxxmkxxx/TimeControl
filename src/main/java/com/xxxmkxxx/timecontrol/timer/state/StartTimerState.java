package com.xxxmkxxx.timecontrol.timer.state;

import com.xxxmkxxx.timecontrol.common.Task;

public record StartTimerState(Task TASK) implements TimerState {
    @Override
    public void execute() {
        TASK.execute();
    }
}
