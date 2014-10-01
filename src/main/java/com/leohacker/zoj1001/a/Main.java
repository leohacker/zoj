package com.leohacker.zoj1001.a;

import java.util.Scanner;

/**
 * Created by leojiang on 10/1/14.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] nums = line.split("\\s+");
            int numA = Integer.parseInt(nums[0]);
            int numB = Integer.parseInt(nums[1]);
            int sum = numA + numB;
            System.out.println(sum);
        }
    }
}

