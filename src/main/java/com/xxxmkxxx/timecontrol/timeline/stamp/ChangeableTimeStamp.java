package com.xxxmkxxx.timecontrol.timeline.stamp;

public interface ChangeableTimeStamp extends TimeStamp {
    boolean increaseActivationTick(int seconds);
    boolean decreaseActivationTick(int seconds);
}
