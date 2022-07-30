package com.xxxmkxxx.timecontrol.timer;

import com.xxxmkxxx.timecontrol.common.GameTime;
import com.xxxmkxxx.timecontrol.common.Ticked;
import com.xxxmkxxx.timecontrol.timeline.*;
import com.xxxmkxxx.timecontrol.timeline.stamp.AbstractChangeableTimeStamp;
import com.xxxmkxxx.timecontrol.timeline.stamp.MutableTimeStamp;

import java.util.HashMap;
import java.util.Map;

public class Timers implements Ticked {
    private final Map<String, Timer> TIMER_MAP = new HashMap<>(10);
    private final AbstractChangeableTimeLine TIME_LINE;
    private final GameTime GAME_TIME;

    public Timers(AbstractChangeableTimeLine timeLine, GameTime gameTime) {
        this.TIME_LINE = timeLine;
        this.GAME_TIME = gameTime;
    }

    public void addTimer(String name, AbstractTimer timer) {
        TIMER_MAP.putIfAbsent(name, timer);

        AbstractChangeableTimeStamp stamp = new MutableTimeStamp(timer.activationSecond(), GAME_TIME.getCurrentTick());
        stamp.addTimeStampListener(() -> {
            timer.react();
            deleteTimer(name);
        });

        TIME_LINE.addStamp(stamp);
    }

    public void deleteTimer(String name) {
        TIMER_MAP.remove(name);
    }

    @Override
    public void tick() {
        if (TIME_LINE.isStampActive(GAME_TIME.getCurrentTick())) {
            TIME_LINE.removeStamp().appriseTimeStampListeners();
        }

        TIMER_MAP.entrySet().forEach(entry -> entry.getValue().tick());
    }
}
