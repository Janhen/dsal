package com.janhen.structures.unionFind.baseNode;

import java.util.HashMap;
import java.util.List;

public class UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		// node --> parent node
		public HashMap<Node, Node> parentMap;
		public HashMap<Node, Integer> sizeMap;

		public UnionFindSet() {
			parentMap = new HashMap<>();
			sizeMap = new HashMap<>();
		}

		// build the union find by collection
		public void makeSets(List<Node> nodes) {
			parentMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				parentMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		// ★★
		private Node findRoot(Node node) {
			Node parent = parentMap.get(node);
			// not root    path compression
			if (parent != node) {
				parent = findRoot(parent);
			}
			// update current parent  --> root
			parentMap.put(node, parent);
			return parent;
		}


		// time : O(logH)?
		public boolean isSameSet(Node a, Node b) {
			return findRoot(a) == findRoot(b);
		}

		public void union(Node p, Node q) {
			if (p == null || q == null) {
				return;
			}
			Node pRoot = findRoot(p);
			Node qRoot = findRoot(q);
			// not union
			if (pRoot != qRoot) {
				int aSetSize= sizeMap.get(pRoot);
				int bSetSize = sizeMap.get(qRoot);
				// optimize height
				if (aSetSize <= bSetSize) {
					// a.parent --> b
					parentMap.put(pRoot, qRoot);
					sizeMap.put(qRoot, aSetSize + bSetSize);
				} else {
					parentMap.put(qRoot, pRoot);
					sizeMap.put(pRoot, aSetSize + bSetSize);
				}
			}
		}

	}
}
