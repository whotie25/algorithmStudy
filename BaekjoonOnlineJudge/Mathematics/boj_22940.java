//22940. 선형 연립 방정식
package BaekjoonOnlineJudge.Mathematics;
import java.util.Scanner;

public class boj_22940 {
    final static double EPSILON = 0.000001;

    public static void main(String[] args) {
        // INPUT
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        double[][] matrix = new double[size+1][size+1];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size+1; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        sc.close();

        // GAUSS ELIMINATION
        for(int i = 0; i < size - 1; i++) {
            // PIVOT SET
            matrix[i][i] = fix(matrix[i][i]);

            if(matrix[i][i] == 0.0) {
                for(int j = i+1; j < size; j++) {
                    matrix[j][i] = fix(matrix[j][i]);
                    if(matrix[j][i] != 0.0) {
                        rowSwap(matrix, i, j);
                        break;
                    }
                }
            }

            if(matrix[i][i] != 1.0) {
                boolean isExist = false;
                for(int j = i+1; j < size-1; j++) {
                    matrix[j][i] = fix(matrix[j][i]);
                    if(matrix[j][i] == 1.0) {
                        rowSwap(matrix, i, j);
                        isExist = true;
                        break;
                    }
                }

                if(isExist == false) {
                    rowScala(matrix, i, 1/matrix[i][i]);
                }
            }

            // ELIMINATE DOWN
            for(int j = i+1; j < size; j++) {
                //ROW COPY
                for(int k = 0; k < size+1; k++) {
                    matrix[size][k] = matrix[i][k]; 
                }

                // ELIMINATION
                matrix[j][i] = fix(matrix[j][i]);
                if(matrix[j][i] == 0.0) continue;

                rowScala(matrix, size, -1 * matrix[j][i]);
                rowSum(matrix, j, size);
            }
        }

        // FIND SOLUTION
        int[] solutionSet = new int[size];

        for(int i = size - 1; i >= 0; i--) {
            rowScala(matrix, i, 1/matrix[i][i]);

            double sol = matrix[i][size];
            for(int j = size-1; j > i; j--) {
                sol -= solutionSet[j] * matrix[i][j];
            }

            sol = fix(sol);

            solutionSet[i] = (int)sol;
        }

        // OUTPUT
        for(int i = 0; i < size; i++) {
            System.out.print(solutionSet[i] + " ");
        }
    }

    // ELEMENTARY ROW OPERATIONS
    public static void rowSwap(double[][] matrix, int row1, int row2) {
        double[] tmp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = tmp;
    }

    public static void rowScala(double[][] matrix, int row, double scala) {
        int size = matrix.length;

        for(int i = 0; i < size; i++) {
            matrix[row][i] *= scala;
        }
    }

    public static void rowSum(double[][] matrix, int row1, int row2) {
        int size = matrix.length;

        for(int i = 0; i < size; i++) {
            matrix[row1][i] += matrix[row2][i];
        }
    }

    // SOME UTILITIES
    public static double fix(double num) {
        int fixed;

        if(num >= 0) {
            fixed = (int)(num + EPSILON);
        } else {
            fixed = (int)(num - EPSILON);
        }

        double diff = (num-fixed >= 0)?(num-fixed):(fixed-num);

        return (diff < 10*EPSILON)?((double)fixed):num;
    }
}
