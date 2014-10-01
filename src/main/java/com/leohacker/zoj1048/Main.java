package com.leohacker.zoj1048;

import java.util.Scanner;

/**
 * Created by leojiang on 10/1/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] moneys = new double[12];
        double sum = 0;
        for (int i = 0; i < 12; i++) {
            moneys[i] = scanner.nextFloat();
            sum += moneys[i];
        }
        double average = Math.round(sum / 12 * 100) / (double)100;
        System.out.println(String.format("$%.2f", average));
    }
}
