package com.xxxmkxxx.timecontrol.client;

import com.xxxmkxxx.timecontrol.TimeControl;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class TimeControlClient implements ClientModInitializer {
    public static final TimeControl CLIENT_SIDE_TIME_CONTROL = new TimeControl(new ClientTime());

    @Override
    public void onInitializeClient() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            CLIENT_SIDE_TIME_CONTROL.tick();
        });
    }
}
