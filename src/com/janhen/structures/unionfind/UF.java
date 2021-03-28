package com.janhen.structures.unionfind;

public interface UF {
  int size();
  boolean isConnected(int p, int q);
  void unionElements(int p, int q);
}
