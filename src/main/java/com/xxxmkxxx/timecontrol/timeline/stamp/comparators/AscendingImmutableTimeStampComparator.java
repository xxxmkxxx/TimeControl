package com.xxxmkxxx.timecontrol.timeline.stamp.comparators;

import com.xxxmkxxx.timecontrol.timeline.stamp.AbstractTimeStamp;

import java.util.Comparator;

public class AscendingImmutableTimeStampComparator implements Comparator<AbstractTimeStamp> {
    @Override
    public int compare(AbstractTimeStamp o1, AbstractTimeStamp o2) {
        return (int) (o1.activationTick() - o2.activationTick());
    }
}
