package com.xxxmkxxx.timecontrol.scheduler;

import com.xxxmkxxx.timecontrol.common.*;
import com.xxxmkxxx.timecontrol.timeline.stamp.AbstractTimeStamp;
import com.xxxmkxxx.timecontrol.timeline.stamp.ImmutableTimeStamp;
import com.xxxmkxxx.timecontrol.timeline.TimeLine;
import com.xxxmkxxx.timecontrol.timeline.stamp.TimeStampEvent;

public record SimpleScheduler(TimeLine TIME_LINE, GameTime GAME_TIME) implements Scheduler {
    @Override
    public ImmutableTimeStamp addTask(int seconds, Task task) {
        ImmutableTimeStamp stamp = new ImmutableTimeStamp(seconds, GAME_TIME.getCurrentTick());
        stamp.addTimeStampListener(() -> task.execute());

        TIME_LINE.addStamp(stamp);

        return stamp;
    }

    @Override
    public void tick() {
        boolean isActivationTime = TIME_LINE.isStampActive(GAME_TIME.getCurrentTick());

        if (isActivationTime) {
            ImmutableTimeStamp stamp = (ImmutableTimeStamp) TIME_LINE.removeStamp();
            stamp.appriseTimeStampListeners();
        }
    }
}
