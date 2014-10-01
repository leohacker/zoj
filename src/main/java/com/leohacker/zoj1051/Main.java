package com.leohacker.zoj1051;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCase = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numCase; caseIndex++) {
            if ( caseIndex != 0 ) {
                System.out.println();
            }
            // Input
            int day = scanner.nextInt();
            int[] dna = new int[16];
            int[][] square = new int[20][20];
            for (int dnaIndex = 0; dnaIndex < 16; dnaIndex++) {
                dna[dnaIndex] = scanner.nextInt();
            }

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    square[i][j] = scanner.nextInt();
                }
            }

            // Calculate
            for (int dayIndex = 0; dayIndex < day; dayIndex++ ) {
                int[][] result = new int[20][20];
                for (int i=0; i < 20; i++ ) {
                    for (int j = 0; j < 20; j++) {
                        int up = (i == 0) ? 0 : square[i - 1][j];
                        int bottom = (i == 19) ? 0 : square[i + 1][j];
                        int left = (j == 0) ? 0 : square[i][j - 1];
                        int right = (j == 19) ? 0 : square[i][j + 1];
                        int sum = up + bottom + left + right + square[i][j];
                        int next = dna[sum] + square[i][j];
                        next = next > 3 ? 3 : (next < 0 ? 0 : next) ;
                        result[i][j] = next;
                    }
                }
                square = result;
            }

            // Print output
            char[] c = {'.', '!', 'X', '#'};
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    System.out.print(c[square[i][j]]);
                }
                System.out.println();
            }
        }
    }
}
