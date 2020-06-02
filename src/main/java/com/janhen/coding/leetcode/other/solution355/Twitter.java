package com.janhen.coding.leetcode.other.solution355;

import java.util.*;

class Twitter {
  public static class User {
    public int id;
    public Set<Integer> followed;
    // user push first node
    public Tweet head;

    public User(int userId) {
      followed = new HashSet<>();
      this.id = userId;
      this.head = null;
      // init to follow self
      follow(id);
    }

    public void follow(int userId) {
      followed.add(userId);
    }

    public void unfollow(int userId) {
      // not can unfollow self
      if (userId != this.id)
        followed.remove(userId);
    }

    public void post(int tweetId) {
      Tweet twt = new Tweet(tweetId, sequence);
      sequence++;
      // 将新建的推文插入链表头
      // 越靠前的推文 time 值越大
      twt.next = head;
      head = twt;
    }
  }

  public static class Tweet {
    public int id;
    public int time;
    public Tweet next;

    // 需要传入推文内容（id）和发文时间
    public Tweet(int id, int time) {
      this.id = id;
      this.time = time;
      this.next = null;
    }
  }

  // timestamp to bigger
  private static int sequence = 0;


  // 我们需要一个映射将 userId 和 User 对象对应起来
  private HashMap<Integer, User> userMap = new HashMap<>();

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    // 若 userId 不存在，则新建
    if (!userMap.containsKey(userId))
      userMap.put(userId, new User(userId));
    User u = userMap.get(userId);
    u.post(tweetId);
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    // 若 follower 不存在，则新建
    if (!userMap.containsKey(followerId)) {
      User u = new User(followerId);
      userMap.put(followerId, u);
    }
    // 若 followee 不存在，则新建
    if (!userMap.containsKey(followeeId)) {
      User u = new User(followeeId);
      userMap.put(followeeId, u);
    }
    userMap.get(followerId).follow(followeeId);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if (userMap.containsKey(followerId)) {
      User flwer = userMap.get(followerId);
      flwer.unfollow(followeeId);
    }
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed.
   *  Each item in the news feed must be posted by users who the user followed or by the user herself.
   *  Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> res = new ArrayList<>();
    if (!userMap.containsKey(userId))
      return res;
    // 关注列表的用户 Id
    Set<Integer> users = userMap.get(userId).followed;
    // 自动通过 time 属性从大到小排序，容量为 users 的大小
    PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

    // 先将所有链表头节点插入优先级队列
    for (int id : users) {
      Tweet twt = userMap.get(id).head;
      if (twt == null)
        continue;
      pq.add(twt);
    }

    while (!pq.isEmpty()) {
      // 最多返回 10 条就够了
      if (res.size() == 10)
        break;
      // 弹出 time 值最大的（最近发表的）
      Tweet twt = pq.poll();
      res.add(twt.id);
      // 将下一篇 Tweet 插入进行排序
      if (twt.next != null)
        pq.add(twt.next);
    }
    return res;
  }
}
