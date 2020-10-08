package com.janhen.coding.leetcode.other.solution381;

import java.util.*;

class RandomizedCollection {

    private List<Integer> vals;
    private int N;
    private Map<Integer, Set<Integer>> valIdxsMap;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        vals = new ArrayList<>();
        N = 0;
        valIdxsMap = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        vals.add(val);
        N ++;
        Set<Integer> idxs = valIdxsMap.getOrDefault(val, new HashSet<>());
        idxs.add(N - 1);
        valIdxsMap.put(val, idxs);
        return valIdxsMap.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!valIdxsMap.containsKey(val) || valIdxsMap.get(val).size() == 0) {
            return false;
        }
        Set<Integer> idxs = valIdxsMap.get(val);
        int removeIdx = idxs.iterator().next();
        idxs.remove(removeIdx);

        int lastVal = vals.get(N - 1);
        vals.set(removeIdx, lastVal);
        Set<Integer> lastIdxs = valIdxsMap.get(lastVal);
        if(removeIdx != N - 1){
            lastIdxs.remove(N - 1);
            lastIdxs.add(removeIdx);
        }

        vals.remove(N - 1);
        N --;
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        if(N <= 0) throw new RuntimeException("空");
        int randomIdx = (int)Math.floor(Math.random() * N);
        return vals.get(randomIdx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */