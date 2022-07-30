package com.xxxmkxxx.timecontrol.server;

import com.xxxmkxxx.timecontrol.timeline.*;
import com.xxxmkxxx.timecontrol.scheduler.Scheduler;
import com.xxxmkxxx.timecontrol.scheduler.SchedulerController;
import com.xxxmkxxx.timecontrol.scheduler.SimpleScheduler;
import com.xxxmkxxx.timecontrol.stopwatch.StopWatchController;
import com.xxxmkxxx.timecontrol.stopwatch.StopWatches;
import com.xxxmkxxx.timecontrol.ticker.SimpleTicker;
import com.xxxmkxxx.timecontrol.ticker.Ticker;
import com.xxxmkxxx.timecontrol.ticker.TickerController;
import com.xxxmkxxx.timecontrol.timer.TimerController;
import com.xxxmkxxx.timecontrol.timer.Timers;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

@Environment(EnvType.SERVER)
public class TimeControlServer implements DedicatedServerModInitializer {
    private static final ServerTime SERVER_TIME = new ServerTime();
    private static final AbstractChangeableTimeLine MUTABLE_TIME_LINE = new MutableTimeLine();
    private static final AbstractTimeLine IMMUTABLE_TIME_LINE = new ImmutableTimeLine();
    private static final Scheduler SCHEDULER = new SimpleScheduler(IMMUTABLE_TIME_LINE, SERVER_TIME);
    private static final Ticker TICKER = new SimpleTicker();
    private static final StopWatches STOP_WATCHES = new StopWatches();
    private static final Timers TIMERS = new Timers(MUTABLE_TIME_LINE, SERVER_TIME);

    public static final SchedulerController SCHEDULER_CONTROLLER = new SchedulerController(SCHEDULER);
    public static final TickerController TICKER_CONTROLLER = new TickerController(TICKER);
    public static final StopWatchController STOP_WATCH_CONTROLLER = new StopWatchController(STOP_WATCHES);
    public static final TimerController TIMER_CONTROLLER = new TimerController(TIMERS, SERVER_TIME);

    @Override
    public void onInitializeServer() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            SERVER_TIME.update();
            SCHEDULER.tick();
            TICKER.tick();
            STOP_WATCHES.tick();
            TIMERS.tick();
        });
    }
}
