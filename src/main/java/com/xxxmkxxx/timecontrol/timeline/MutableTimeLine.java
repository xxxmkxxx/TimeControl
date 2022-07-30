package com.xxxmkxxx.timecontrol.timeline;

import com.xxxmkxxx.timecontrol.timeline.stamp.AbstractChangeableTimeStamp;
import com.xxxmkxxx.timecontrol.timeline.stamp.MutableTimeStamp;
import com.xxxmkxxx.timecontrol.timeline.stamp.comparators.AscendingMutableTimeStampComparator;

import java.util.NavigableSet;
import java.util.TreeSet;

public class MutableTimeLine extends AbstractChangeableTimeLine {
    private final NavigableSet<AbstractChangeableTimeStamp> LINE;
    private static final AbstractChangeableTimeStamp EMPTY_TIME_STAMP = new MutableTimeStamp(0, 0);

    public MutableTimeLine() {
        this.LINE = new TreeSet<>(new AscendingMutableTimeStampComparator());
    }

    @Override
    public void changeStamp(AbstractChangeableTimeStamp oldStamp, AbstractChangeableTimeStamp newStamp) {
        removeStamp(oldStamp);
        LINE.add(newStamp);
    }

    @Override
    public void addStamp(AbstractChangeableTimeStamp stamp) {
        if (stamp != null) {
            LINE.add(stamp);
        }
    }

    @Override
    public AbstractChangeableTimeStamp removeStamp() {
        return LINE.isEmpty() ? EMPTY_TIME_STAMP : LINE.pollFirst();
    }

    @Override
    public AbstractChangeableTimeStamp removeStamp(AbstractChangeableTimeStamp stamp) {
        return LINE.remove(stamp) ? stamp : EMPTY_TIME_STAMP;
    }

    @Override
    public boolean isStampActive(long currentTick) {
        return !LINE.isEmpty() && currentTick >= LINE.first().activationTick();
    }
}
