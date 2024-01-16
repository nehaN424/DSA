package graph;

import java.util.LinkedList;
import java.util.Stack;

public class DFSWithListRepresentation {

    public static void main(String[] args){

    GraphListRepresentation graphListRepresentation = new GraphListRepresentation(4);
        graphListRepresentation.addEdge(0, 1);
        graphListRepresentation.addEdge(0, 2);
        graphListRepresentation.addEdge(1, 2);
        graphListRepresentation.addEdge(2, 0);
        graphListRepresentation.addEdge(2, 3);
        graphListRepresentation.addEdge(3, 3);

        graphListRepresentation.dfsTraversal(2);
    }
}
class GraphListRepresentation{

    public GraphListRepresentation(int vertices){
        this.vertices = vertices;
        this.adj = new LinkedList[vertices];
        for(int i = 0; i < vertices ; i++){
            adj[i] = new LinkedList();
        }
    }
    private int vertices;
    private LinkedList<Integer> adj[];

    public void addEdge(int node, int connectedNode){
        adj[node].add(connectedNode);
    }

    public void dfsTraversal(int start){
        boolean[] visited = new boolean[4];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()){
            int current = stack.pop();
            System.out.println(current);
            visited[current] = true;
            LinkedList<Integer> adjList = adj[current];

            for(Integer next : adjList){
                if(visited[next] != true){
                  stack.push(next);
                }
            }
        }
    }
}
