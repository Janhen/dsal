package com.janhen.structures.unionfind;

class UnionFind implements UF {

  int[] parent;
  int[] rank;

  public UnionFind(int n) {
    parent = new int[n];
    rank = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }

  @Override
  public int size() {
    return parent.length;
  }

  @Override
  public boolean isConnected(int p, int q) {
    return find(p) == find(q);
  }

  private int find(int p) {
    if (p < 0 || p >= parent.length)
      throw new IllegalArgumentException();

    while (parent[p] != p) {
      parent[p] = parent[parent[p]];
      p = parent[p];
    }
    return parent[p];
  }

  @Override
  public void unionElements(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot != qRoot) {
      if (rank[pRoot] < rank[qRoot])
        parent[pRoot] = qRoot;
      else if (rank[pRoot] > rank[qRoot])
        parent[qRoot] = pRoot;
      else {
        parent[pRoot] = qRoot;
        rank[qRoot]++;
      }
    }
  }
}