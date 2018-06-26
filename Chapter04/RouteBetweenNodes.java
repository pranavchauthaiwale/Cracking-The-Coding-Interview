package Chapter04;

import Chapter04.GraphUtils.GraphUtils;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {

    /*
     * Chapter 04 Question 01
     * Given a directed graph, design an algorithm to find out whether there is route between two nodes
     */

    public static void main(String[] args) {
        int[][] graph = GraphUtils.getDirectedGraphAsAdjacencyMatrix();
        boolean result = solution(graph, 0, 5);
        System.out.println(String.format("Path exists between start %d and end %d: %s", 0, 5, result));
        result = solution(graph, 2, 6);
        System.out.println(String.format("Path exists between start %d and end %d: %s", 2, 6, result));
    }

    private static boolean solution(int[][] graph, int start, int end) {
        //Using simple breadth first search traversal to find route
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            if(currentNode == end){
                return true;
            }
            for(int i = 0; i < graph.length; i++){
                if(graph[currentNode][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}
