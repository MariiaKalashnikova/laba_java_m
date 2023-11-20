package org.example;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public final class matrix_im {
    private boolean Filled;
    Scanner val_im = new Scanner(System.in);

    private final double[][] matr;
    private final int row, col;


    public int getRow (){
        return row;
    }
    public int getCol (){
        return col;
    }
    public double[][] getMatr (double[][] userMatr){
        return userMatr;
    }
    public double getVal(int row, int col){
        return matr[row][col];
    }


    public matrix_im(){
        this.Filled = true;
        //this.Filled = false;
        this.row = 0;
        this.col = 0;
        this.matr = new double[row][col];
        //порожня матриця якa має розмірність 0 на 0
    }
    public matrix_im(int r, int c){
        this.Filled = true;
        //this.Filled = false;
        this.row = r;
        this.col = c;
        this.matr = new double[row][col];
    }

    public int[] size_1(){
        int [] arr = new int[2];
        if(matr.length == 0){arr[0] = 0; arr[1] = 0;}
        else{
            arr[0] = matr.length;
            arr[1] = matr[matr.length-1].length;}
        System.out.print("\nРозмірність: " + arr[0]+"*"+arr[1] + "\n");
        return arr;
    }

    public matrix_im(Object obj) {
        double[][] matr_1 = null;
        int Row = 0;
        int Col = 0;

        if (obj instanceof matrix_im) {
            matrix_im matr_2 = (matrix_im) obj;
            Row = matr_2.row;
            Col = matr_2.col;
            matr_1 = new double[Row][Col];
            for (int i = 0; i < Row; i++) {
                for (int k = 0; k < Col; k++) {
                    matr_1[i][k] = matr_2.matr[i][k];
                }
            }
        }
        else if (obj instanceof Matrix) {
            Matrix matr_3 = (Matrix) obj;
            int rows = matr_3.getRow();
            int cols = matr_3.getCol();
            matr_1 = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matr_1[i][j] = matr_3.getVal(i, j);
                }
            }
            Row = rows;
            Col = cols;
            //this.Filled = false;
            //this.Filled = true;
        } else {
            System.out.println("Такий клас конструктор не приймає");
        }
        this.row = Row;
        this.col = Col;
        this.matr = matr_1;
        this.Filled = true;
    }

    public void fill_user (){
        throw new IllegalStateException("Ви не можете змінити цю матрицю");
    }
    public void fill (double [][] matr_10){
        throw new IllegalStateException("Ви не можете змінити цю матрицю");
    }
    public void fill_random (){
        throw new IllegalStateException("Ви не можете змінити цю матрицю");
    }


    public double val(int val_2, int val_3){
        val_2-=1;
        if(val_2 < 0 || val_2 >= row){
            throw new IllegalStateException("Не коректна кількість рядків");
        }
        val_3-=1;
        if(val_3 < 0 || val_3 >= col){
            throw new IllegalStateException("Не коректна кількість стовпців");
        }
        System.out.println("\nЕлемент матриці: "+matr[val_2][val_3]);
        return matr[val_2][val_3];
    }

    public double[] row_1(int val_2){
        val_2=val_2-1;
        if(0 > val_2 || val_2 >= row){
            throw new IllegalStateException("У вас не коректна кількість рядків");
        }
        double [] arr = new double[col];
        for(int i =0; i < col; i++){
            arr[i] = matr[val_2][i];
        }
        System.out.print("\nРядок: ");
        for(int j = 0; j < col; j++){
            System.out.print(arr[j]+" ");
        }

        return arr;
    }

    public double[] col_1(int val_4){
        val_4=val_4-1;
        if(0 > val_4 || val_4 >= col){
            throw new IllegalStateException("Не коректна кількість стовпців");
        }
        double [] arr = new double[row];
        for(int i =0; i < row; i++){
            arr[i] = matr[i][val_4];
        }
        System.out.print("\nСтовпець: \n");
        for(int j = 0; j < row; j++){
            System.out.print(arr[j]+"\n");
        }
        return arr;
    }



    @Override
    public boolean equals(Object oj) {
        if (this == oj) {
            return true;
        }

        if (getClass() != oj.getClass() || oj == null) {
            return false;
        }
        matrix_im matr_3 = (matrix_im) oj;
        if (matr.length != matr_3.getRow() || matr[matr.length-1].length != matr_3.getCol()) {
            return false;
        }
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[matr.length-1].length; j++) {
                if (matr[i][j] != matr_3.getVal(i,j)) {
                    return false;
                }
            }
        }
        return true;
    }
    @Override
    public int hashCode() {
        final int code = 37;
        int st_1 = 1;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[matr.length-1].length; j++) {
                st_1 =  (int)matr[i][j]+ code * st_1;
            }
        }
        return st_1;}
    //public int hashCode() {
    //return Arrays.deepHashCode(matr);
    //}

    public matrix_im addit(Object obj) {
        double[][] matr_3 = new double[row][col];
        if (obj instanceof matrix_im) {
            matrix_im matr_2 = (matrix_im) obj;
            int[] b = matr_2.size_1();
            int[] a = new int[2];
            a[0] = row;
            a[1] = col;
            if(a[0] == b[0] && a[1] == b[1]){
                for(int i = 0; i<a[0]; i++){
                    for (int k=0; k<a[1]; k++){
                        matr_3[i][k] = matr[i][k] + matr_2.getVal(i,k);
                    }
                }
                System.out.println("\n\nНова матриця:");
                for (int i = 0; i < a[0]; i++) {
                    for (int k = 0; k < a[1]; k++) {
                        System.out.print(matr_3[i][k] + " ");
                    }
                    System.out.println();
                }
            }
            else{
                throw new IllegalStateException("Вибачте, але через розмірність, ваші матриці не додаються");
            }

        } else if (obj instanceof Matrix){
            Matrix matr_1 = (Matrix) obj;
            matrix_im matr_2 = new matrix_im(matr_1);
            int[] b = matr_2.size_1();
            int[] a = new int[2];
            a[0] = row;
            a[1] = col;
            if(a[0] == b[0] && a[1] == b[1]){
                for(int i = 0; i<a[0]; i++){
                    for (int k=0; k<a[1]; k++){
                        matr_3[i][k] = matr[i][k] + matr_2.getVal(i,k);
                    }
                }
                System.out.println("\n\nНова матриця:");
                for (int i = 0; i < a[0]; i++) {
                    for (int k = 0; k < a[1]; k++) {
                        System.out.print(matr_3[i][k] + " ");
                    }
                    System.out.println();
                }
            }
            else{
                throw new IllegalStateException("Вибачте, але через розмірність, ваші матриці не додаються");
            }
        }
        else {
            System.out.println("Такий клас конструктор не приймає");
        }
        Matrix matr_new_mutable = new Matrix(row, col);
        matr_new_mutable.fill(matr_3);
        matrix_im matr_new_1 = new matrix_im(matr_new_mutable);
        return matr_new_1;

    }

    //множення матриці на скаляр
    public matrix_im numb(matrix_im matr_1, double number){
        int[] a = matr_1.size_1();
        double[][] matr_3 = new double[a[0]][a[1]];

        for(int i = 0; i<a[0]; i++){
            for (int k=0; k<a[1]; k++){
                matr_3[i][k] = number * matr_1.getVal(i,k);
            }
        }
        System.out.println("\n\nНова матриця:");
        for (int i = 0; i < a[0]; i++) {
            for (int k = 0; k < a[1]; k++) {
                System.out.print(matr_3[i][k] + " ");
            }
            System.out.println();
        }
        Matrix matr_new_mutable = new Matrix(a[0], a[1]);
        matr_new_mutable.fill(matr_3);
        matrix_im matr_new_1 = new matrix_im(matr_new_mutable);
        return matr_new_1;
    }

    public matrix_im mult(Object obj) {
        int[] a = new int[2];
        int[] b = new int[2];
        if (obj instanceof Matrix) {
            Matrix matr_1_p = (Matrix) obj;
            b = matr_1_p.size_1();
        }
        if (obj instanceof matrix_im) {
            matrix_im matr_im_p = (matrix_im) obj;
            b = matr_im_p.size_1();
        }
        double[][] matr_3 = new double[row][b[1]];
        if (obj instanceof matrix_im) {
            matrix_im matr_2 = (matrix_im) obj;
            a[0] = row;
            a[1] = col;
            if(a[1] == b[0]){
                for (int i = 0; i < a[0]; i++) {
                    for (int k = 0; k < b[1]; k++) {
                        for (int r = 0; r <a[1]; r++) {
                            matr_3[i][k] += matr[i][r] * matr_2.getVal(r,k);
                            matr_3[i][k] = Math.round(matr_3[i][k]*100.0)/100.0;} } }
                System.out.println("\n\nНова матриця:");
                for (int i = 0; i < a[0]; i++) {
                    for (int k = 0; k < b[1]; k++) {
                        System.out.print(matr_3[i][k] + " ");
                    }
                    System.out.println();
                }
            }
            else{
                throw new IllegalStateException("Вибачте, але через розмірність, ваші матриці не можна помножити");
            }

        } else if (obj instanceof Matrix){
            Matrix matr_1 = (Matrix) obj;
            matrix_im matr_2 = new matrix_im(matr_1);
            a[0] = row;
            a[1] = col;
            if(a[1] == b[0]){
                for (int i = 0; i < a[0]; i++) {
                    for (int k = 0; k < b[1]; k++) {
                        for (int r = 0; r <a[1]; r++) {
                            matr_3[i][k] += matr[i][r] * matr_2.getVal(r,k);
                            matr_3[i][k] = Math.round(matr_3[i][k]*100.0)/100.0;} } }
                System.out.println("\n\nНова матриця:");
                for (int i = 0; i < a[0]; i++) {
                    for (int k = 0; k < b[1]; k++) {
                        System.out.print(matr_3[i][k] + " ");
                    }
                    System.out.println();
                }
            }
            else{
                throw new IllegalStateException("Вибачте, але через розмірність, ваші матриці не можна помножити");
            }
        }
        else {
            System.out.println("Такий клас конструктор не приймає");
        }
        Matrix matr_new_mutable = new Matrix(row, b[1]);
        matr_new_mutable.fill(matr_3);
        matrix_im matr_new_1 = new matrix_im(matr_new_mutable);
        return matr_new_1;

    }


    //транспонування
    public matrix_im transp(matrix_im matr_3){
        int[] a = matr_3.size_1();
        double[][] matr_6 = new double[a[0]][a[1]];
        if(a[0]==a[1]){
            double[][] matr_5 = new double[a[0]][a[1]];
            for(int i = 0; i<a[0]; i++){
                for (int k=0; k<a[1]; k++){
                    matr_5[i][k] = matr_3.getVal(i,k);
                }
            }
            for(int i = 0; i<a[0]; i++){
                for (int k=0; k<a[1]; k++){
                    matr_6[i][k] = matr_5[k][i];
                }
            }
            System.out.println("Транспонована матриця:");
            for (int i = 0; i < a[0]; i++) {
                for (int k = 0; k < a[1]; k++) {
                    System.out.print(matr_6[i][k] + " ");
                }System.out.println();}}
        else{
            throw new IllegalStateException("Вибачте, але через розмірність ваша матриця не транспонувалася");
        }
        Matrix matr_new_mutable = new Matrix(a[0], a[1]);
        matr_new_mutable.fill(matr_6);
        matrix_im matr_new_1 = new matrix_im(matr_new_mutable);
        return matr_new_1;
    }

    public matrix_im diag(double [] vec){
        double[][] matr_3 = new double[vec.length][vec.length];
        for(int i = 0; i <vec.length; i++){
            for (int k=0; k<vec.length; k++){
                if (i==k){
                    matr_3[i][k] = vec[i];}
                else{
                    matr_3[i][k] = 0;
                }
            }
        }
        System.out.print("\nДіагональна матриця: \n");
        for (int i = 0; i < vec.length; i++) {
            for (int k = 0; k < vec.length; k++) {
                System.out.print(matr_3[i][k] + " ");
            }System.out.println();}

        Matrix matr_new_mutable = new Matrix(vec.length, vec.length);
        matr_new_mutable.fill(matr_3);
        matrix_im matr_new_1 = new matrix_im(matr_new_mutable);
        return matr_new_1;
    }


    //одинична матриця
    public matrix_im one(int rows, int cols){
        double[][] matr_3;
        if(rows<0 || cols<0){
            throw new IllegalStateException("Кількість рядків та стовпчиков не може бути менше за нуль");
        }
        else{
            matr_3 = new double[rows][cols];
            for(int i = 0; i<rows; i++){
                for (int k=0; k< cols; k++){
                    matr_3[i][k] = 1;
                }}
            System.out.print("\nОдинична матриця: \n");
            for (int i = 0; i < rows ; i++) {
                for (int k = 0; k < cols ; k++) {
                    System.out.print(matr_3[i][k] + " ");
                }System.out.println();}}
        Matrix matr_new_mutable = new Matrix(rows, cols);
        matr_new_mutable.fill(matr_3);
        matrix_im matr_new_1 = new matrix_im(matr_new_mutable);
        return matr_new_1;
    }

    public matrix_im r_matr(int col, int count){
        double[][] arr;
        if(col>0){
            arr = new double[1][col];
            Random val__ = new Random();
            int ran = val__.nextInt();
            for(int i = 0; i<col; i++){
                arr[0][i] = val__.nextDouble(count);
                arr[0][i] = Math.round((val__.nextDouble() * 2 * count - count)*100.0)/100.0;

            }
            System.out.print("\nРандомний рядок-матриця: \n");
            for(int i = 0; i<col; i++){
                System.out.print(arr[0][i] + " ");
            }}
        else{
            throw new IllegalStateException("Помилка!!! Ви увели від'ємне значення стовпця");
        }
        Matrix matr_new_mutable = new Matrix(1, col);
        matr_new_mutable.fill(arr);
        matrix_im matr_new_1 = new matrix_im(matr_new_mutable);
        return matr_new_1;
    }

    public matrix_im c_matr(int row, int count){
        double[][] arr;
        if(row>0){
            arr = new double[row][1];
            Random val__ = new Random();
            int ran = val__.nextInt();
            for(int i = 0; i<row; i++){
                arr[i][0] = val__.nextDouble(count);
                arr[i][0] = Math.round((val__.nextDouble() * 2 * count - count)*100.0)/100.0;
            }
            System.out.print("\nРандомний стовпець-матриця: \n");
            for(int i = 0; i<row; i++){
                System.out.println(arr[i][0] + " ");
            }}
        else{
            throw new IllegalStateException("Помилка!!! Ви увели від'ємне значення рядка");
        }
        Matrix matr_new_mutable = new Matrix(row, 1);
        matr_new_mutable.fill(arr);
        matrix_im matr_new_1 = new matrix_im(matr_new_mutable);
        return matr_new_1;
    }

    public matrix_im lower(matrix_im matr_3){
        int[] a = matr_3.size_1();
        //matrix_im matr_5 =new matrix_im(a[0], a[1]);
        double [][] matr_4 = new double[a[0]][a[1]];
        for (int i = 0; i < a[0]; i++) {
            for(int j = 0; j < a[1]; j++){
                matr_4[i][j] = matr_3.getVal(i, j);
            }}
        if(a[0]==a[1]){
            for (int i = 0; i < a[0]; i++) {
                for(int j = 0; j < a[1]; j++){
                    //System.out.println(j+"\n");
                    if(j < i && matr_4[i][j]!=0){
                        int h = i-1;
                        if(matr_4[i-1][j]!=0){
                            double m = matr_4[i][j]/matr_4[i-1][j];
                            for(int k = 0; k < a[1]; k++){
                                double m_1 = matr_4[i][k]-matr_4[i-1][k]*m;
                                matr_4[i][k] = Math.round(m_1 * 100.0) / 100.0;}
                        }
                        if(matr_4[h][j]==0){

                            while(matr_4[h][j]==0 && h != 0){
                                h=h-1;
                            }
                            if(matr_4[h][j] != 0){
                                double m = matr_4[i][j]/matr_4[h][j];
                                for(int k = 0; k < a[1]; k++){
                                    double m_1 = matr_4[i][k]-matr_4[h][k]*m;

                                    matr_4[i][k] = Math.round(m_1 * 100.0) / 100.0;}
                            }
                            if(matr_4[h][j] == 0) {
                                double[] t = new double[a[1]];
                                for(int p = 0; p<a[0];p++){
                                    for(int f = 0; f<a[1]; f++){
                                        matr_4[p][f] = matr_3.getVal(p,f);
                                    }
                                }
                                for (int y = 0; y < a[1]; y++) {
                                    t[y] = matr_4[i][y];
                                }
                                for (int e = 0; e < a[1]; e++) {
                                    matr_4[i][e] = matr_4[h][e];
                                }
                                for (int r = 0; r < a[1]; r++) {
                                    matr_4[h][r] = t[r];
                                }
                                i=-1;
                                j = -1;

                            }
                        }
                    }
                }
            }
            //matr_5.fill(matr_4);

        }
        else{
            throw new IllegalStateException("Помилка!!! Матриця не квадратна");
        }
        Matrix matr_new_mutable = new Matrix(a[0], a[1]);
        matr_new_mutable.fill(matr_4);
        matrix_im matr_new_1 = new matrix_im(matr_new_mutable);
        return matr_new_1;

    }

    public matrix_im up(matrix_im matr_3) {
        int[] a = matr_3.size_1();
        //matrix_im matr_5 =new matrix_im(a[0], a[1]);
        double [][] matr_4 = new double[a[0]][a[1]];
        for (int i = 0; i < a[0]; i++) {
            for(int j = 0; j < a[1]; j++){
                matr_4[i][j] = matr_3.getVal(i, j);
            }}
        if(a[0]==a[1]){
            for (int i = a[0]-1; i > 0 || i == 0; i--) {
                for(int j = a[1]-1; j > 0 || j == 0; j--){
                    if(j > i && matr_4[i][j]!=0){
                        int h = i+1;
                        if(matr_4[i+1][j]!=0){
                            double m = matr_4[i][j]/matr_4[i+1][j];
                            for(int k = a[1]-1; k > 0 || k == 0; k--){
                                double m_1 = matr_4[i][k]-matr_4[i+1][k]*m;


                                matr_4[i][k] = Math.round(m_1 * 100.0) / 100.0;}
                        }
                        if(matr_4[h][j]==0){

                            while(matr_4[h][j]==0 && h != a[0]-1){
                                h=h+1;
                            }
                            if(matr_4[h][j] != 0){
                                double m = matr_4[i][j]/matr_4[h][j];
                                for(int k = a[1]-1; k > 0 || k == 0; k--){
                                    double m_1 = matr_4[i][k]-matr_4[h][k]*m;

                                    matr_4[i][k] = Math.round(m_1 * 100.0) / 100.0;}
                            }
                            if(matr_4[h][j] == 0) {
                                double[] t = new double[a[1]];
                                for(int p = 0; p<a[0];p++){
                                    for(int f = 0; f<a[1]; f++){
                                        matr_4[p][f] = matr_3.getVal(p,f);
                                    }
                                }
                                for (int y = a[1]-1; y >0||y==0; y--) {
                                    t[y] = matr_4[i][y];
                                }
                                for (int e = a[1]-1; e >0||e==0; e--) {
                                    matr_4[i][e] = matr_4[h][e];
                                }
                                for (int r = a[1]-1; r >0||r==0; r--) {
                                    matr_4[h][r] = t[r];
                                }
                                i = a[0];
                                j = a[1];
                            }
                        }
                    }
                }
            }
            //matr_5.fill(matr_4);
        }
        else{
            throw new IllegalStateException("Помилка!!! Матриця не квадратна");
        }
        Matrix matr_new_mutable = new Matrix(a[0], a[1]);
        matr_new_mutable.fill(matr_4);
        matrix_im matr_new_1 = new matrix_im(matr_new_mutable);
        return matr_new_1;
    }
    public void additionally(){
        System.out.println("\n\nМетод виведення матриці\n");
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                System.out.print(matr[i][k] + " ");
            }
            System.out.println();
        }
    }
}





