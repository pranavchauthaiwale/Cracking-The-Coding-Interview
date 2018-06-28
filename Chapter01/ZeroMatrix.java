package Chapter01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class ZeroMatrix {

    public static void main(String[] args){
        int[][] matrix = getSampleMatrix();
        System.out.println("Sample matrix is: ");
        printMatrix(matrix);
        zeroMatrix(matrix);
        System.out.println("Zero matrix is: ");
        printMatrix(matrix);

    }

    private static void zeroMatrix(int[][] matrix){
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i =0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 1){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(int i : rowSet){
            for(int j = 0; j < col; j++){
                matrix[i][j] = 0;
            }
        }
        for(int j : colSet){
            for (int i = 0; i < row; i++){
                matrix[i][j] = 0;
            }
        }
    }

    private static int[][] getSampleMatrix(){
        int[][] matrix = new int[6][5];
        for(int i = 0; i < 6; i++){
            int rowIndex = ThreadLocalRandom.current().nextInt(0, 6);
            int colIndex = ThreadLocalRandom.current().nextInt(0, 5);
            matrix[rowIndex][colIndex] = 1;
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i =0; i < row; i++){
            System.out.print("[ ");
            for(int j = 0; j < col; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
