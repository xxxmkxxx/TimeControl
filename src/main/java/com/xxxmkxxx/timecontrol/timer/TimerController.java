package com.xxxmkxxx.timecontrol.timer;

import com.xxxmkxxx.timecontrol.common.GameTime;
import com.xxxmkxxx.timecontrol.common.Task;
import com.xxxmkxxx.timecontrol.timer.state.StartTimerState;

public record TimerController(Timers timers, GameTime GAME_TIME) {
    public AbstractTimer startTimer(String name, int tick, Task task, boolean execConstantly) {
        AbstractTimer timer = new SimpleTimer(GAME_TIME.getCurrentTick(), tick, task, execConstantly, new StartTimerState(task));

        timers.addTimer(name, timer);

        return timer;
    }
}
