package com.janhen.structures.graph;

import java.util.ArrayList;

public class GraphDFS {

    private final Graph G;
    private final boolean[] visited;

    private final ArrayList<Integer> pre = new ArrayList<>();
    private final ArrayList<Integer> post = new ArrayList<>();

    public GraphDFS(Graph G) {

        this.G = G;
        visited = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!visited[v])
                dfs(v);
    }

    public static void main(String[] args) {

        Graph g = new Graph("g.txt");
        GraphDFS graphDFS = new GraphDFS(g);
        System.out.println("DFS preOrder : " + graphDFS.pre());
        System.out.println("DFS postOrder : " + graphDFS.post());
    }

    private void dfs(int v) {

        visited[v] = true;
        pre.add(v);
        for (int w : G.adj(v))
            if (!visited[w])
                dfs(w);
        post.add(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }
}
