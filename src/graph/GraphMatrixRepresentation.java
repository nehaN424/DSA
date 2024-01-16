package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GraphMatrixRepresentation {

    public GraphMatrixRepresentation(int vertices){
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


    public void bfsTraversal(int start){
        boolean[] visited = new boolean[4];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            visited[current] = true;
            System.out.println(current);

            for(int i = 0; i < vertices; i++){
                if(adjMatrix[current][i] == 1 && !visited[i]){
                    queue.add(i);
                }
            }
        }

    }
}