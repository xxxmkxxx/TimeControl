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
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TimeControl {
    private final GameTime gameTime;
    private final AbstractChangeableTimeLine mutableTimeLine = new MutableTimeLine();
    private final AbstractTimeLine immutableTimeLine = new ImmutableTimeLine();
    private final Scheduler scheduler = new SimpleScheduler(immutableTimeLine, gameTime);
    private final Ticker ticker = new SimpleTicker();
    private final StopWatches stopWatches = new StopWatches();
    private final Timers timers = new Timers(mutableTimeLine, gameTime);

    private final SchedulerController schedulerController = new SchedulerController(scheduler);
    private final TickerController tickerController = new TickerController(ticker);
    private final StopWatchController stopWatchController = new StopWatchController(stopWatches);
    private final TimerController timerController = new TimerController(timers, gameTime);

    public void tick() {
        gameTime.update();
        scheduler.tick();
        ticker.tick();
        stopWatches.tick();
        timers.tick();
    }
}
