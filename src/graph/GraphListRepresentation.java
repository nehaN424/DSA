package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GraphListRepresentation {

    public GraphListRepresentation(int vertices) {
        this.vertices = vertices;
        this.adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList();
        }
    }

    private int vertices;
    private LinkedList<Integer> adj[];

    public void addEdge(int node, int connectedNode) {
        adj[node].add(connectedNode);
    }

    public void dfsTraversal(int start) {
        boolean[] visited = new boolean[4];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.println(current);
            visited[current] = true;
            LinkedList<Integer> adjList = adj[current];

            for (Integer next : adjList) {
                if (visited[next] != true) {
                    stack.push(next);
                }
            }
        }
    }

    public void bfsTraversal(int start){
        boolean[] visited = new boolean[4];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(current);
            visited[current] = true;
            LinkedList<Integer> adjList = adj[current];
            for (Integer next : adjList) {
                if (visited[next] != true) {
                    queue.add(next);
                }
            }

        }

    }
}
