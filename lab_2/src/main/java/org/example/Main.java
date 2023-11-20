package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[][] matr_1 = {
                {3, 9},
                {6, 7}
        };
        double[][] matr_2 = {
                {17, 2},
                {4.5, 65},
                {1, 7}

        };
        double[][] matr_3 = {
                {8, 7.5},
                {6, 8}
        };
        double[][] matr_4 = {
                {0, 2, 4, 2},
                {4, 0, 6, 4},
                {3, 8, 0, 6},
                {2, 5, 6, 0}

        };
        Matrix matrix_1 = new Matrix(4,4);
        matrix_1.fill(matr_4);
        Matrix matrix_copy = new Matrix(matrix_1);
        Matrix matrix_5 = matrix_1.lower(matrix_1);
        Matrix matrix_6 = matrix_copy.up(matrix_copy);
        System.out.println("-------");
        matrix_5.additionally();
        System.out.println("-------");
        matrix_6.additionally();
        /*if (matrix_5.equals(matrix_2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        System.out.println("Результат 1 матриці: " + matrix_5.hashCode());
        System.out.println("Результат 2 матриці: " + matrix_2.hashCode());*/

    }
}


