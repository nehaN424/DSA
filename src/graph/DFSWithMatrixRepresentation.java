package graph;

import java.util.Stack;

/*
* This program stores the graph data using matrix representation and perform
* DFS traversal on that.
*
* */
public class DFSWithMatrixRepresentation {

    public  static void main(String[] args){

        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.dfsTraversal(2);
    }

}
class Graph{

    public Graph(int vertices){
        this.vertices = vertices;
        this. adjMatrix = new int[vertices][vertices];
    }
    private int vertices;
    private int[][] adjMatrix;

    public void addEdge(int row, int col){
        adjMatrix[row][col] = 1;
    }

    public void dfsTraversal(int start){
        boolean[] visited = new boolean[4];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()){
            int current = stack.pop();
            visited[current] = true;
            System.out.println(current);

            for(int i = 0; i < vertices; i++){
                if(adjMatrix[current][i] == 1 && !visited[i]){
                    stack.push(i);
                }
            }
        }
    }
}
