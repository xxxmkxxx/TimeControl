package com.xxxmkxxx.timecontrol.client;

import com.xxxmkxxx.timecontrol.common.SimpleTask;
import com.xxxmkxxx.timecontrol.timeline.*;
import com.xxxmkxxx.timecontrol.scheduler.Scheduler;
import com.xxxmkxxx.timecontrol.scheduler.SchedulerController;
import com.xxxmkxxx.timecontrol.scheduler.SimpleScheduler;
import com.xxxmkxxx.timecontrol.stopwatch.StopWatchController;
import com.xxxmkxxx.timecontrol.stopwatch.StopWatches;
import com.xxxmkxxx.timecontrol.ticker.SimpleTicker;
import com.xxxmkxxx.timecontrol.ticker.Ticker;
import com.xxxmkxxx.timecontrol.ticker.TickerController;
import com.xxxmkxxx.timecontrol.timer.Timer;
import com.xxxmkxxx.timecontrol.timer.TimerController;
import com.xxxmkxxx.timecontrol.timer.Timers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

@Environment(EnvType.CLIENT)
public class TimeControlClient implements ClientModInitializer {
    private static final ClientTime CLIENT_TIME = new ClientTime();
    private static final AbstractChangeableTimeLine MUTABLE_TIME_LINE = new MutableTimeLine();
    private static final AbstractTimeLine IMMUTABLE_TIME_LINE = new ImmutableTimeLine();
    public static final Scheduler SCHEDULER = new SimpleScheduler(IMMUTABLE_TIME_LINE, CLIENT_TIME);
    public static final Ticker TICKER = new SimpleTicker();
    private static final StopWatches STOP_WATCHES = new StopWatches();
    public static final Timers TIMERS = new Timers(MUTABLE_TIME_LINE, CLIENT_TIME);

    public static final SchedulerController SCHEDULER_CONTROLLER = new SchedulerController(SCHEDULER);
    public static final TickerController TICKER_CONTROLLER = new TickerController(TICKER);
    public static final StopWatchController STOP_WATCH_CONTROLLER = new StopWatchController(STOP_WATCHES);
    public static final TimerController TIMER_CONTROLLER = new TimerController(TIMERS, CLIENT_TIME);

    @Override
    public void onInitializeClient() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            CLIENT_TIME.update();
            SCHEDULER.tick();
            TICKER.tick();
            STOP_WATCHES.tick();
            TIMERS.tick();
        });
    }
}
