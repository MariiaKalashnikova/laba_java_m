package org.example;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Matrix matr_m1_empty = new Matrix();
        Matrix matr_m2_empty = new Matrix();
        //створення порожніх матриць змінюваного класу
        Matrix matr_m1_rc = new Matrix(3,3);
        Matrix matr_m2_rc = new Matrix(2,2);
        //створення матриць змінюваного класу заданого розміру
        matrix_im matr_im1_empty = new matrix_im();
        matrix_im matr_im2_empty = new matrix_im();
        //створення порожніх матриць незмінюваного класу
        matrix_im matr_im1_rc = new matrix_im(2, 2);
        matrix_im matr_im2_rc = new matrix_im(2,2);
        //створення матриць незмінюваного класу заданого розміру


        double[][] matr_1 = {
                {3, 9},
                {6, 0}
        };
        double[][] matr_2 = {
                {7, 2, 3},
                {4.5, 0, 9},
                {13, 8, 9}

        };
        double[][] matr_3 = {
                {2, 7.5},
                {6, 8}
        };
        double[][] matr_4 = {
                {1, 2, 3},
                {4, 5, 6},
                {3, 8, 4}

        };


        //matr_m1_rc.fill(matr_2);
        //matr_m1_rc.additionally();
        //matr_m2_rc.fill(matr_3);
        //matr_m2_rc.additionally();
        //matr_m1_rc.additionally();
        //int[] s = matr_m1_rc.size_1();
        //заповнення матриць заданими елементами та дізнаємося розмірність

        matr_im1_rc.fill(matr_3);
        matr_im2_rc.fill(matr_1);
        //int[] s = matr_im2_rc.size_1();
        //заповнюємо незмінюваної матриці елементами та дивимося розмірність
        //matr_im1_rc.fill_user();
        //matr_im2_rc.fill_random();
        //показані приклади, що ж буде, якщо спробуємо перезаповнити НЕЗМІНЮВАНУ матрицю


        //Matrix matr_m2_copy = new Matrix(matr_m1_rc);
        //matr_m2_copy.additionally();
        //демонстрація можливості конструктора, що копіює


        //matr_im1_empty = new matrix_im(matr_im1_rc);
        //matrix_im matr_im2_copy = new matrix_im(matr_im1_rc);
        //matr_im1_empty.additionally();
        //matr_im2_copy.additionally();
        //демонструємо копіювання незмінної матриці
        //matr_im1_empty.fill(matr_3);
        //що буде, якщо спробуємо заповнити цю матрицю ще раз


        //int[] size_1 = matr_m2_copy.size_1();
        //double val_matr_m1_fill = matr_m1_rc.val(3, 1);
        //double[] str = matr_m1_rc.row_1(2);
        //double[] col = matr_m1_rc.col_1(3);
        //double[] str = matr_m1_rc.row_1(2);
        //double[] col_ = matr_m1_rc.col_1(2);
        //double val_matr_m1_copy = matr_m1_rc.val(2,3);
        //виведення елементу, рядку, стовпця

        //double val_matr_im1_fill = matr_im2_rc.val(2, 3);
        //double[] str = matr_im2_rc.row_1(3);
        //double[] col_ = matr_im2_rc.col_1(3);
        //double val_matr_im1_copy = matr_im2_rc.val();
        //виведення елементу, рядку та стовпця незмінюваного класу

        //matr_m1_rc.fill_user();
        //matr_m1_rc.additionally();
        //так як матриця змінна, то спробуємо її змінити й вивести
        //matr_m1_empty.fill_user();
        //matr_m1_empty.fill_random();
        //matr_m1_rc.fill_random();
        //змінюємо раніше заповнені матриці, спочатку заповненням користувача, потім рандомним

        //Matrix matr_m1_copy_1 = new Matrix(matr_m1_empty);
        //Matrix matr_m2_copy_1 = new Matrix(matr_m1_rc);
        //double[] row_1 = matr_m2_copy.row_1();
        //виведення рядка
        //double[] col_1 = matr_m1_rc.col_1();
        //виведення стовпця

        /*if (matr_im2_rc.equals(matr_im1_rc)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        System.out.println("Результат 1 матриці: " + matr_im2_rc.hashCode());
        System.out.println("Результат 2 матриці: " + matr_im1_rc.hashCode());*/
        //порівняння матриць одного класу

        //Matrix matr_add = matr_m1_rc.addit(matr_m2_rc, matr_m1_rc);
        //додаємо 2 матриці

        //matrix_im matr_im_add = matr_im1_rc.addit(matr_im1_rc, matr_im2_rc);
        //matr_im1_rc.additionally();
        //matr_im2_rc.additionally();
        //matr_im_add.additionally();
        //додаємо матриці незмінювані

        //Matrix matr_number = matr_m1_rc.numb(matr_m1_rc, 2);
        //множимо матрицю на скаляр

        //matrix_im matr_im_number = matr_im1_rc.numb(matr_im1_rc, 5);
        //matr_im1_rc.additionally();
        //matr_im_number.additionally();
        //matr_im_number.fill_random();
        //множимо на скаляр незмінювану матрицю

        //Matrix matr_mult = matr_m1_rc.mult (matr_m2_rc, matr_m1_rc);
        //множимо 2 матриці

        //matrix_im matr_im_mult = matr_im1_rc.mult (matr_im2_rc, matr_im1_rc);
        //matr_im2_rc.additionally();
        //matr_im1_rc.additionally();
        //matr_im_mult.additionally();
        //множимо 2 матриці незмінюваного класу
        //matr_im_mult.fill(matr_1);
        //matr_im_mult.additionally();


        //Matrix matr_transp = matr_m1_rc.transp(matr_m1_rc);
        //matr_transp.additionally();
        //транспонуємо змінювану матрицю

        //matrix_im matr_im_transp = matr_im_mult.transp(matr_im_mult);
        //matr_im_mult.additionally();
        //matr_im_transp.additionally();
        //транспонуємо незмінювану матрицю

        //double[] d = {4, 5, 6, 7};
        //Matrix diagonal = matr_m1_rc.diag(d);
        //diagonal.additionally();
        //створюємо діагональну матрицю за допомогою вектора
        //Matrix one_1 = matr_m1_rc.one(3,3);
        //one_1.additionally();
        //створюємо одиничну матрицю

        //double[] d_im = {-2,4,5,6};
        //matrix_im diagonal_im = matr_im1_rc.diag(d_im);
        //створюємо діагональну незмінювальну матрицю
        //matrix_im one_im_1 = matr_im1_rc.one(3,3);
        //створюємо одиничну незмінювальну матрицю

        //Matrix row_1 = matr_m1_rc.r_matr(3, 5);
        //matr_m1_rc.additionally();
        //row_1.additionally();
        //створюємо рядок-матрицю, що заповнена рандомно
        //Matrix col_1 = matr_m1_rc.c_matr(-2, 5);
        //matr_m1_rc.additionally();
        //col_1.additionally();
        //створюємо стовпчик-матрицю, що рандомно заповнена

        //matrix_im row_1 = matr_im1_rc.r_matr(4, 5);
        //створюємо рядок-матрицю, що заповнена рандомно - клас незмінюваний
        //matrix_im col_1 = matr_im1_rc.c_matr(4, 5);
        //створюємо стовпчик-матрицю, що рандомно заповнена - клас незмінюваний


        //Matrix matr_1_low = matr_m1_rc.lower(matr_m1_rc);
        //робимо нулі нижче за головну діагональ методом Гаусса
        //Matrix matr_1_up = matr_m1_rc.up(matr_m2_rc);
        //matr_m2_rc.additionally();
        //робимо нулі вище за головну діагональ методом Гаусса

        //matrix_im matr_1_im_low = matr_im1_rc.lower(matr_im1_rc);
        //нижче за діагональ будуть нулі
        //matrix_im matr_1_im_up = matr_im1_rc.up(matr_im1_rc);
        //matr_im1_rc.additionally();
        //робимо нулі вище за головну діагональ методом Гаусса


    }
}

