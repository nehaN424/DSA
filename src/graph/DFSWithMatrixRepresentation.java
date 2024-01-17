package graph;

/*
* This program stores the graph data using matrix representation and perform
* DFS traversal on that.
*
* */
public class DFSWithMatrixRepresentation {

    public  static void main(String[] args){

        GraphMatrixRepresentation graph = new GraphMatrixRepresentation(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.dfsTraversal(2);
    }

}