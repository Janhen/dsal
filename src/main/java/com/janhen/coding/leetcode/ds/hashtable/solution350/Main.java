package com.janhen.coding.leetcode.ds.hashtable.solution350;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(1, 2, 2, 1);
    List<Integer> list2 = Arrays.asList(2, 2);
    Collection<Integer> intersection = CollectionUtils.intersection(list1, list2);
  }
}
