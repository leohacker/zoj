package com.leohacker.zoj1049;

import java.util.Scanner;

/**
 * Created by leojiang on 10/1/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        double[][] dim = new double[num][2];
//        double [] radius = new double[num];
        int year[] = new int[num];

        double x;
        double y;
        for (int i = 0; i < num; i++) {
            dim[i][0] = scanner.nextDouble();
            dim[i][1] = scanner.nextDouble();
            x = dim[i][0];
            y = dim[i][1];
            double area = Math.PI * ( x*x + y*y ) / (double)2;
            year[i] = (int)(Math.floor( area / (double) 50 )) + 1;
        }

        for (int i = 0; i < num; i++) {
            System.out.println(String.format("Property %d: This property will begin eroding in year %d.", i+1,
                    year[i]));
        }
        System.out.println("END OF OUTPUT.");
    }
}
