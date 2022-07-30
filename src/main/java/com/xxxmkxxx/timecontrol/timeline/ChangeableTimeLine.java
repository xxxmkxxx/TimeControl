package com.xxxmkxxx.timecontrol.timeline;

import com.xxxmkxxx.timecontrol.timeline.stamp.AbstractChangeableTimeStamp;

public interface ChangeableTimeLine extends TimeLine<AbstractChangeableTimeStamp> {
    void changeStamp(AbstractChangeableTimeStamp oldStamp, AbstractChangeableTimeStamp newStamp);
}
