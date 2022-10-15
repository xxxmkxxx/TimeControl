package com.xxxmkxxx.timecontrol.scheduler;

import com.xxxmkxxx.timecontrol.common.*;
import com.xxxmkxxx.timecontrol.timeline.stamp.ImmutableTimeStamp;

public record SchedulerController(Scheduler SCHEDULER) {
    public ImmutableTimeStamp scheduleTask(long tick, Task task) {
        return SCHEDULER.addTask(tick, task);
    }
}
