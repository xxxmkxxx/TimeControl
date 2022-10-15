package com.xxxmkxxx.timecontrol.timeline.stamp;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ImmutableTimeStamp extends AbstractTimeStamp {
    private final List<TimeStampListener> LISTENERS;
    private final long TICK;

    public ImmutableTimeStamp(long tick, long currentTick) {
        this.TICK = tick + currentTick;
        this.LISTENERS = new LinkedList<>();
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
        ImmutableTimeStamp stamp = (ImmutableTimeStamp) o;
        return TICK == stamp.TICK;
    }

    @Override
    public int hashCode() {
        return Objects.hash(TICK);
    }
}
