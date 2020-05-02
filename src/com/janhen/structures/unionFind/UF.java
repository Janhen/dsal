package com.janhen.structures.unionFind;

public interface UF {
  int size();
  boolean isConnected(int p, int q);
  void unionElements(int p, int q);
}
