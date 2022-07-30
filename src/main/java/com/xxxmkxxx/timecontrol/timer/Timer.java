package com.xxxmkxxx.timecontrol.timer;

import com.xxxmkxxx.timecontrol.common.Ticked;
import com.xxxmkxxx.timecontrol.timer.state.TimerState;

public interface Timer extends Ticked {
    void changeState(TimerState state);
    int activationSecond();
}
