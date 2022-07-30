package com.xxxmkxxx.timecontrol.timeline.stamp;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MutableTimeStamp extends AbstractChangeableTimeStamp {
    private final List<TimeStampListener> LISTENERS;
    private long TICK;

    public MutableTimeStamp(int seconds, long currentTick) {
        this.TICK = seconds * 20L + currentTick;
        this.LISTENERS = new LinkedList<>();
    }

    @Override
    public boolean increaseActivationTick(int seconds) {
        TICK += seconds * 20;

        return true;
    }

    @Override
    public boolean decreaseActivationTick(int seconds) {
        TICK -= seconds * 20;

        return true;
    }

    @Override
    public long activationTick() {
        return TICK;
    }

    @Override
    public void addTimeStampListener(TimeStampListener listener) {
        LISTENERS.add(listener);
    }

    @Override
    public void removeTimeStampListener(TimeStampListener listener) {
        LISTENERS.remove(listener);
    }

    @Override
    public void appriseTimeStampListeners() {
        LISTENERS.forEach(TimeStampListener::react);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableTimeStamp that = (MutableTimeStamp) o;
        return TICK == that.TICK;
    }

    @Override
    public int hashCode() {
        return Objects.hash(TICK);
    }
}
