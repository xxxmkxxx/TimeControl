package com.xxxmkxxx.timecontrol;

import com.xxxmkxxx.timecontrol.common.GameTime;
import com.xxxmkxxx.timecontrol.scheduler.Scheduler;
import com.xxxmkxxx.timecontrol.scheduler.SchedulerController;
import com.xxxmkxxx.timecontrol.scheduler.SimpleScheduler;
import com.xxxmkxxx.timecontrol.stopwatch.StopWatchController;
import com.xxxmkxxx.timecontrol.stopwatch.StopWatches;
import com.xxxmkxxx.timecontrol.ticker.SimpleTicker;
import com.xxxmkxxx.timecontrol.ticker.Ticker;
import com.xxxmkxxx.timecontrol.ticker.TickerController;
import com.xxxmkxxx.timecontrol.timeline.AbstractChangeableTimeLine;
import com.xxxmkxxx.timecontrol.timeline.AbstractTimeLine;
import com.xxxmkxxx.timecontrol.timeline.ImmutableTimeLine;
import com.xxxmkxxx.timecontrol.timeline.MutableTimeLine;
import com.xxxmkxxx.timecontrol.timer.TimerController;
import com.xxxmkxxx.timecontrol.timer.Timers;
import lombok.Getter;

@Getter
public class TimeControl {
    private final GameTime gameTime;
    private final AbstractChangeableTimeLine mutableTimeLine;
    private final AbstractTimeLine immutableTimeLine;
    private final Scheduler scheduler;
    private final Ticker ticker;
    private final StopWatches stopWatches;
    private final Timers timers;

    private final SchedulerController schedulerController;
    private final TickerController tickerController;
    private final StopWatchController stopWatchController;
    private final TimerController timerController;

    public TimeControl(GameTime gameTime) {
        this.gameTime = gameTime;
        this.mutableTimeLine = new MutableTimeLine();
        this.immutableTimeLine = new ImmutableTimeLine();
        this.scheduler = new SimpleScheduler(immutableTimeLine, gameTime);
        this.ticker = new SimpleTicker();
        this.stopWatches = new StopWatches();
        this.timers = new Timers(mutableTimeLine, gameTime);
        this.schedulerController = new SchedulerController(scheduler);
        this.tickerController = new TickerController(ticker);
        this.stopWatchController = new StopWatchController(stopWatches);
        this.timerController = new TimerController(timers, gameTime);
    }

    public void tick() {
        gameTime.update();
        scheduler.tick();
        ticker.tick();
        stopWatches.tick();
        timers.tick();
    }
}
