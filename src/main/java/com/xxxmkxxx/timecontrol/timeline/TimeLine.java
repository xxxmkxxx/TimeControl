package com.xxxmkxxx.timecontrol.timeline;

import com.xxxmkxxx.timecontrol.timeline.stamp.TimeStamp;

public interface TimeLine<T extends TimeStamp> {
    void addStamp(T stamp);
    T removeStamp();
    T removeStamp(T stamp);
    boolean isStampActive(long currentTick);
}
