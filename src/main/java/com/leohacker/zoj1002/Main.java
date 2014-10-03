package com.leohacker.zoj1002;


import java.util.Scanner;

/**
 * Created by leojiang on 10/1/14.
 * 在这个解法中，输入的墙理解为一个mask矩阵。通过二进制数的方式，枚举所有的可能放置炮台的方案，即使放炮台的这个位置可能是墙。
 * 因为我们评估的是合并后的矩阵，这不是一个问题。基于，任何一种方案，合并mask矩阵，得到候选矩阵。对于候选矩阵进行评估，如果没有炮台的冲突，
 * 就是合理，得到此方案的结果。完成所有的枚举，就可以找到放置最多炮台的方案。
 *
 * 使用目前的二进制模拟枚举的方式，效率较低。改进的方案可以用二进制模拟一行，可能要采用递归的方式。
 * 也可以直接使用递归的方式，不过如果dim较大，可能嵌套层次较多。
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num != 0) {
            int dim = num;
            scanner.nextLine(); // eat up the end of line for the dimension number.
            
            // read the mask matrix.
            int[][] mask = new int[num][num];
            for (int i = 0; i < num; i++) {
                String line = scanner.nextLine();
                mask[i] = convertMask(line, num);
            }
//            printMatrix(mask, num);

            // calculate
            int maxNumGun = 0;
            int numGun = 0;
            for (int i = 0; i < ( 1 << (num*num) ); i++) {
                int[][] candidateMatrix = convertCand(i, num);
//                printMatrix(candidateMatrix, num);
                merge(candidateMatrix, mask, num);
//                printMatrix(candidateMatrix, num);

                numGun = evaluate(candidateMatrix, num);
                if (numGun > maxNumGun) {
                    maxNumGun = numGun;
                }
            }
            System.out.println(maxNumGun);
            num = scanner.nextInt();
        }

    }

    /**
     * Evaluate the candidate matrix whether this matrix is valid, and return the number of gun if valid.
     *
     * Algorithm:
     *      For each line or column, set a flag for conflict. If a fire gun is found,
     *      set the conflict flag. Read more, if found another gun, conflict and exit the evaluation. If found a
     *      wall, clear the flag. Summarize the number of gun, and return it if no conflict. Just evaluate the
     *      columns, but don't accumulate the number for gun.
     *
     * @param candidateMatrix
     * @param num
     * @return  return 0 if invalid, else return the number of gun.
     */
    private static int evaluate(int[][] candidateMatrix, int num) {
        // check the rows and summarize the number of gun.
        boolean flag = false;
        int numGun = 0;
        for (int i = 0; i < num; i++) {
            flag = false;
            for (int j = 0; j < num; j++) {
                int current = candidateMatrix[i][j];
                if (current == 1) {
                    if (flag) {
                        return 0;
                    } else {
                        flag = true;
                        numGun++;
                    }
                } else if (current == 9) {
                    flag = false;
                }
            }
        }

        // check the columns.
        for (int i = 0; i < num; i++) {
            flag = false;
            for (int j = 0; j < num; j++) {
                int current = candidateMatrix[j][i];
                if (current == 1) {
                    if (flag) {
                        return 0;
                    } else {
                        flag = true;
                    }
                } else if (current == 9) {
                    flag = false;
                }
            }
        }
        return numGun;
    }

    // Merge the candidate matrix and mask matrix ( the wall matrix ).
    private static void merge(int[][] candidateMatrix, int[][] mask, int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (mask[i][j] == 9) {
                    candidateMatrix[i][j] = 9;
                }
            }
        }
    }

    // Convert the integer form of candidate into matrix form. 1 means machine gun, 0 means empty.
    private static int[][] convertCand(int candidate, int num) {
        int[][] matrix = new int[num][num];
        int mask = 1 << ( num*num - 1 );
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                matrix[i][j] = (candidate & mask) > 0 ? 1 : 0;
                candidate = candidate << 1;
            }

        }
        return matrix;
    }

    // Convert the input to mask matrix. 9 means wall, 0 means empty.
    private static int[] convertMask(String line, int num) {
        int[] ret = new int[num];
        for (int i = 0; i < num; i++) {
            ret[i] = (line.charAt(i) == '.') ? 0 : 9;
        }
        return ret;
    }

    private static void printMatrix(int[][] mask, int num) {
        for (int i = 0; i <num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(mask[i][j]);
            }
            System.out.println();
        }
    }
}
