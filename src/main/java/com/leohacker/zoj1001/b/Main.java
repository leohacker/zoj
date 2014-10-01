package com.leohacker.zoj1001.b;

import java.util.Scanner;

/**
 * Created by leojiang on 10/1/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int sum = a + b;
            System.out.println(sum);
        }
    }
}
