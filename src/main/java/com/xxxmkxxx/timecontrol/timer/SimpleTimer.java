package com.xxxmkxxx.timecontrol.timer;

import com.xxxmkxxx.timecontrol.common.Task;
import com.xxxmkxxx.timecontrol.timer.state.StopTimerState;
import com.xxxmkxxx.timecontrol.timer.state.TimerState;

import java.util.Objects;

public class SimpleTimer extends AbstractTimer {
    private final long START_TICK;
    private long stopTick;
    private final Task TASK;
    private final boolean EXEC_CONSTANTLY;
    private TimerState timerState;
    private long ticks;

    public SimpleTimer(long currentTick, int tick, Task task, boolean execConstantly, TimerState state) {
        this.START_TICK = currentTick;
        this.stopTick = currentTick + tick;
        this.TASK = task;
        this.EXEC_CONSTANTLY = execConstantly;
        this.timerState = state;
        this.ticks = tick;
    }

    @Override
    public void changeState(TimerState state) {
        timerState = state;
    }

    @Override
    public int activationSecond() {
        return (int) (ticks / 20);
    }

    @Override
    public void tick() {
        if (EXEC_CONSTANTLY)
            timerState.execute();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTimer that = (SimpleTimer) o;
        return START_TICK == that.START_TICK && stopTick == that.stopTick && EXEC_CONSTANTLY == that.EXEC_CONSTANTLY && Objects.equals(TASK, that.TASK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(START_TICK, stopTick, TASK, EXEC_CONSTANTLY);
    }

    @Override
    public void react() {
        timerState = new StopTimerState();
    }
}
