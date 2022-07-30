package com.xxxmkxxx.timecontrol.timeline.stamp.comparators;

import com.xxxmkxxx.timecontrol.timeline.stamp.AbstractChangeableTimeStamp;

import java.util.Comparator;

public class AscendingMutableTimeStampComparator implements Comparator<AbstractChangeableTimeStamp> {
    @Override
    public int compare(AbstractChangeableTimeStamp o1, AbstractChangeableTimeStamp o2) {
        return (int) (o1.activationTick() - o2.activationTick());
    }
}
