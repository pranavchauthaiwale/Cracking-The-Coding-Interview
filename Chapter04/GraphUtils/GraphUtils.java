package Chapter04.GraphUtils;

public class GraphUtils {
    private static final int MAX_ELEMENTS = 9;
    public static int[][] getUndirectedGraphAsAdjacencyMatrix(){
        int[][] adjMatrix = new int[MAX_ELEMENTS][MAX_ELEMENTS];

        addUndirectedEdge(adjMatrix, 0, 1);
        addUndirectedEdge(adjMatrix, 1, 2);
        addUndirectedEdge(adjMatrix, 1, 3);
        addUndirectedEdge(adjMatrix, 2, 4);
        addUndirectedEdge(adjMatrix, 3, 4);
        addUndirectedEdge(adjMatrix, 3, 6);
        addUndirectedEdge(adjMatrix, 4, 5);
        addUndirectedEdge(adjMatrix, 4, 7);
        return adjMatrix;
    }

    private static void addUndirectedEdge(int[][] adjMatrix, int start, int end){
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public static int[][] getDirectedGraphAsAdjacencyMatrix(){
        int[][] adjMatrix = new int[MAX_ELEMENTS][MAX_ELEMENTS];

        addDirectedEdge(adjMatrix, 0, 1);
        addDirectedEdge(adjMatrix, 1, 2);
        addDirectedEdge(adjMatrix, 1, 3);
        addDirectedEdge(adjMatrix, 2, 4);
        addDirectedEdge(adjMatrix, 3, 4);
        addDirectedEdge(adjMatrix, 3, 6);
        addDirectedEdge(adjMatrix, 4, 5);
        addDirectedEdge(adjMatrix, 4, 7);
        return adjMatrix;
    }

    private static void addDirectedEdge(int[][] adjMatrix, int start, int end){
        adjMatrix[start][end] = 1;
    }

    public static void printAdjacencyMatrix(int[][] graph) {
        int rows = graph.length;
        int cols = graph[0].length;
        // number of rows and columns will always be same

        for (int i = 0; i < rows; i++) {
            System.out.print(i + " [ ");
            for (int j = 0; j < cols; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
