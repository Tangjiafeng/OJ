package com.ecnu.leetcode.array;

/**
 * https://leetcode-cn.com/problems/rotate-image/
 */
public class MatrixRotate {
    // Algor 1: �ռ临�Ӷ�O(1)��ά��һ���͵��滻�ĳ���Ϊ4����ʱ�б�
    public void rotate(int[][] matrix) {
        int len = matrix.length;
//        int[] tempList = new int[4];
        for (int i = 0; i < len / 2; i ++) {
            for (int j = 0; j < len - 1 - i * 2; j ++) {
                int temp = matrix[i][j + i];
                matrix[i][j + i] = matrix[len - 1 - i - j][i];
                matrix[len - 1 - i - j][i] = matrix[len - 1 - i][len - 1 - i - j];
                matrix[len - 1 - i][len - 1 - i - j] = matrix[j + i][len - 1 - i];
                matrix[j + i][len - 1 - i] = temp;

                /*tempList[0] = matrix[i][j + i];
                tempList[1] = matrix[j + i][len - 1 - i];
                tempList[2] = matrix[len - 1 - i][len - 1 - i - j];
                tempList[3] = matrix[len - 1 - i - j][i];

                matrix[j + i][len - 1 - i] = tempList[0];
                matrix[len - 1 - i][len - 1 - i - j] = tempList[1];
                matrix[len - 1 - i - j][i] = tempList[2];
                matrix[i][j + i] = tempList[3];
                this.print(matrix);
                System.out.println("====");*/
            }
            this.print(matrix);
            System.out.println("====");
        }
    }

    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
