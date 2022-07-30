package com.xxxmkxxx.timecontrol.timeline;

import com.xxxmkxxx.timecontrol.timeline.stamp.AbstractTimeStamp;
import com.xxxmkxxx.timecontrol.timeline.stamp.comparators.AscendingImmutableTimeStampComparator;
import com.xxxmkxxx.timecontrol.timeline.stamp.ImmutableTimeStamp;

import java.util.NavigableSet;
import java.util.TreeSet;

public class ImmutableTimeLine extends AbstractTimeLine {
    private final NavigableSet<AbstractTimeStamp> LINE;
    private static final AbstractTimeStamp EMPTY_TIME_STAMP = new ImmutableTimeStamp(0, 0);

    public ImmutableTimeLine() {
        this.LINE = new TreeSet<>(new AscendingImmutableTimeStampComparator());
    }

    @Override
    public void addStamp(AbstractTimeStamp stamp) {
        if (stamp != null) {
            LINE.add(stamp);
        }
    }

    @Override
    public AbstractTimeStamp removeStamp() {
        return LINE.isEmpty() ? EMPTY_TIME_STAMP : LINE.pollFirst();
    }

    @Override
    public AbstractTimeStamp removeStamp(AbstractTimeStamp stamp) {
        return LINE.remove(stamp) ? stamp : EMPTY_TIME_STAMP;
    }

    @Override
    public boolean isStampActive(long currentTick) {
        return !LINE.isEmpty() && currentTick >= LINE.first().activationTick();
    }
}
