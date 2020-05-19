package com.janhen.design.minutehourcount;

import java.util.Date;
import java.util.List;

/**
 * 最近一分钟和最近1小时的数量<br>
 * 
 * 时间桶设计方案<br>
 * 1h 的时间插入到 60 个离散的桶中
 * 
 */
public class TrailingBucketCounter {

  public TrailingBucketCounter(int numBuckets, int secsPerBucket) {

  }

  static class Event {
    int count;
    Date time;

    public Event(int count, Date time) {
      this.count = count;
      this.time = time;
    }
  }

  void add(int count, int timeSec) {

  }

  int minuteCount() {
    return -1;
  }

  int trailingCount() {
    return -1;
  }
}
