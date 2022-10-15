package com.xxxmkxxx.timecontrol.server;

import com.xxxmkxxx.timecontrol.TimeControl;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class TimeControlServer implements DedicatedServerModInitializer {
    public static final TimeControl SERVER_SIDE_TIME_CONTROL = new TimeControl(new ServerTime());

    @Override
    public void onInitializeServer() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            SERVER_SIDE_TIME_CONTROL.tick();
        });
    }
}
