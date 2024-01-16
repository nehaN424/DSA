package graph;

public class BFSWithListRepresentation {

    public static void main(String[] args){

        GraphListRepresentation graphListRepresentation = new GraphListRepresentation(4);
        graphListRepresentation.addEdge(0, 1);
        graphListRepresentation.addEdge(0, 2);
        graphListRepresentation.addEdge(1, 2);
        graphListRepresentation.addEdge(2, 0);
        graphListRepresentation.addEdge(2, 3);
        graphListRepresentation.addEdge(3, 3);

        graphListRepresentation.bfsTraversal(2);
    }
}
