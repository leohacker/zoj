package com.leohacker.zoj1037;

import java.util.Scanner;

/**
 * Created by leojiang on 10/1/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] dimension = new int[num][2];
        double[] result = new double[num];

        for (int i = 0; i < num; i++ ) {
            dimension[i][0] = scanner.nextInt();
            dimension[i][1] = scanner.nextInt();
            int m = dimension[i][0];
            int n = dimension[i][1];
            if (( m % 2 == 0) || (n % 2 == 0)) {
                result[i] = (double) (m * n);
            } else {
                result[i] = (double)(m * n - 1) + Math.sqrt(2);
            }
        }

        for (int i = 0; i < num; i++ ) {
            System.out.println("Scenario #" + (i+1) + ":");
            System.out.println(String.format("%.2f", result[i]));
            System.out.println();
        }
    }
}
