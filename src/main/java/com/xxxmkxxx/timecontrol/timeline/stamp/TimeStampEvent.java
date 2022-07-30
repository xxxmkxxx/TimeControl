package com.xxxmkxxx.timecontrol.timeline.stamp;

public interface TimeStampEvent {
    void addTimeStampListener(TimeStampListener listener);
    void removeTimeStampListener(TimeStampListener listener);
    void appriseTimeStampListeners();
}
