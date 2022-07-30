package com.xxxmkxxx.timecontrol.common;

public abstract class AbstractGameTime implements GameTime {
    protected long currentTick = 0;

    @Override
    public long getCurrentTick() {
        return currentTick;
    }

    @Override
    public void update() {
        currentTick++;
    }
}
