package com.xxxmkxxx.timecontrol.timeline.stamp;

public interface ChangeableTimeStamp extends TimeStamp {
    boolean increaseActivationTick(long tick);
    boolean decreaseActivationTick(long tick);
}
