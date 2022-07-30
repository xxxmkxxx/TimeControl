package com.xxxmkxxx.timecontrol.scheduler;

import com.xxxmkxxx.timecontrol.common.Task;
import com.xxxmkxxx.timecontrol.common.Ticked;
import com.xxxmkxxx.timecontrol.timeline.stamp.ImmutableTimeStamp;

public interface Scheduler extends Ticked {
    ImmutableTimeStamp addTask(int seconds, Task task);
}
