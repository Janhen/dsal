package com.janhen.design.minutehourcount;

import java.util.Date;
import java.util.List;

/**
 * 最近一分钟和最近1小时的数量<br>
 * 
 * 传送带设计方案<br>
 */
public class MinuteHourCounter {
  List<Event> minuteEvents;
  List<Event> hourEvents;
  int minuteCount;
  int hourCount;

  static class Event {
    int count;
    Date time;

    public Event(int count, Date time) {
      this.count = count;
      this.time = time;
    }
  }

  void add(int count) {

  }

  int minuteCount() {
    return -1;
  }

  int hourCount() {
    return -1;
  }
}
