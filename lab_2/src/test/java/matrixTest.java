import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.example.Matrix;
import org.example.matrix_im;

public class matrixTest {
    @Test
    void test_1() {
        Matrix test__1 = new Matrix(2,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9}
        };
        test__1.fill(matr_t1);
        double val_t = test__1.val(2, 2);
        assertEquals(2, val_t);

    }

    @Test
    void test_2() {
        Matrix test__1 = new Matrix(3,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        test__1.fill(matr_t1);
        double val_t = test__1.val(1, 1);
        assertEquals(3, val_t);
    }

    @Test
    public void testInvalid() {
        Matrix test__1 = new Matrix(3,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        test__1.fill(matr_t1);
        assertThrows(IllegalStateException.class, () -> {
            test__1.val(4, 1);
        });
    }

    @Test
    void test_3() {
        Matrix test__1 = new Matrix(3,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        test__1.fill(matr_t1);
        double[] row_t = test__1.row_1(1);
        double[] res = {3.0, 9.0, 12.0};
        assertArrayEquals(res, row_t, 0.0001);
    }

    @Test
    void test_4() {
        Matrix test__1 = new Matrix(3,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        test__1.fill(matr_t1);
        double[] row_t = test__1.row_1(3);
        double[] res = {2.0, 4.0, 5.0};
        assertArrayEquals(res, row_t, 0.0001);
    }

    @Test
    void test_5() {
        Matrix test__1 = new Matrix(3,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        test__1.fill(matr_t1);
        double[] row_t = test__1.col_1(3);
        double[] res = {12.0, -9.0, 5.0};
        assertArrayEquals(res, row_t, 0.0001);
    }

    @Test
    void test_6() {
        Matrix test__1 = new Matrix(3,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        test__1.fill(matr_t1);
        double[] row_t = test__1.col_1(1);
        double[] res = {3.0, 6.0, 2.0};
        assertArrayEquals(res, row_t, 0.0001);
    }

    @Test
    public void testInvalid_1() {
        Matrix test__1 = new Matrix(3,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        test__1.fill(matr_t1);

        assertThrows(IllegalStateException.class, () -> {
            test__1.col_1(4);
        });
    }

    @Test
    public void testInvalid_2() {
        Matrix test__1 = new Matrix(3,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        test__1.fill(matr_t1);
        assertThrows(IllegalStateException.class, () -> {
            test__1.row_1(4);
        });
    }

    @Test
    void test_7() {
        Matrix test__1 = new Matrix(3,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        test__1.fill(matr_t1);
        int[] size_t = test__1.size_1();
        int[] res = {3, 3};
        assertArrayEquals(res, size_t);
    }

    @Test
    void test_8() {
        Matrix test__1 = new Matrix(1,3);
        double[][] matr_t1 = {
                {3, 9, 12}
        };
        test__1.fill(matr_t1);
        int[] size_t = test__1.size_1();
        int[] res = {1, 3};
        assertArrayEquals(res, size_t);
    }

    @Test
    void test_9() {
        Matrix test__1 = new Matrix(2,2);

        double[][] matr_t1 = {
                {3, 9},
                {25, -4}
        };
        test__1.fill(matr_t1);
        Matrix test__2 = new Matrix(test__1);
        boolean eq = test__1.equals(test__2);
        assertTrue(eq);
    }

    @Test
    void test_10() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__2 = new Matrix(2, 2);

        double[][] matr_t1 = {
                {3, 9},
                {25, -4}
        };
        double[][] matr_t2 = {
                {3, 9},
                {25, -4}
        };
        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        boolean eq = test__1.equals(test__2);
        assertTrue(eq);
    }
    @Test
    void test_11() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__2 = new Matrix(2, 2);

        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {3, 9},
                {25, -4}
        };
        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        boolean eq = test__1.equals(test__2);
        assertFalse(eq);
    }



    @Test
    void test_13() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__2 = new Matrix(2, 2);

        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {3, 10},
                {25, -4}
        };
        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        assertEquals(test__1.hashCode(), test__2.hashCode());
    }

    @Test
    void test_14() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__2 = new Matrix(2, 2);

        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {3, 10},
                {25, 4}
        };
        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        assertNotEquals(test__1.hashCode(), test__2.hashCode());
    }

    @Test
    void test_15() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__2 = new Matrix(2, 2);

        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 10},
                {25, -4}
        };
        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        assertNotEquals(test__1.hashCode(), test__2.hashCode());
    }

    @Test
    void test_16() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__2 = new Matrix(2, 2);
        Matrix test__3 = new Matrix(2, 2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 10},
                {-25, -4}
        };
        double[][] matr_t3 = {
                {5, 20},
                {0, -8}
        };
        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        test__3.fill(matr_t3);
        Matrix test = test__1.addit(test__2);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_17() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__2 = new Matrix(2, 2);
        Matrix test__3 = new Matrix(2, 2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 10},
                {-25, -4}
        };
        double[][] matr_t3 = {
                {5, 20},
                {0, 8}
        };
        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        test__3.fill(matr_t3);
        Matrix test = test__1.addit(test__2);
        boolean eq = test__3.equals(test);
        assertFalse(eq);
    }
    @Test
    void test_17_1() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__3 = new Matrix(2, 2);
        Matrix test__2_m = new Matrix(2,2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 10},
                {-25, -4}
        };
        double[][] matr_t3 = {
                {5, 20},
                {0, -8}
        };
        test__1.fill(matr_t1);

        test__2_m.fill(matr_t2);
        matrix_im test__2 = new matrix_im(test__2_m);
        test__3.fill(matr_t3);
        Matrix test = test__1.addit(test__2);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    public void testInvalid_3() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__2 = new Matrix(2, 1);

        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2},
                {-25}
        };

        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        assertThrows(IllegalStateException.class, () -> {
            test__1.addit(test__2);
        });
    }
    @Test
    void test_18() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__2 = new Matrix(2, 2);
        Matrix test__3 = new Matrix(2, 2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 10},
                {-25, -4}
        };
        double[][] matr_t3 = {
                {-244, -10},
                {150, 266}
        };
        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        test__3.fill(matr_t3);
        Matrix test = test__1.mult(test__2);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_19() {
        Matrix test__1 = new Matrix(2,3);
        Matrix test__2 = new Matrix(3, 2);
        Matrix test__3 = new Matrix(2, 2);
        double[][] matr_t1 = {
                {3, 10, 9},
                {25, -4, 7}
        };
        double[][] matr_t2 = {
                {2, 10},
                {-25, -4},
                {1, 2}
        };
        double[][] matr_t3 = {
                {-235, 8},
                {157, 280}
        };
        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        test__3.fill(matr_t3);
        Matrix test = test__1.mult(test__2);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    public void testInvalid_4() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__2 = new Matrix(1, 2);

        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 3},
        };

        test__1.fill(matr_t1);
        test__2.fill(matr_t2);
        assertThrows(IllegalStateException.class, () -> {
            test__1.mult(test__2);
        });

    }

    @Test
    void test_20() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__3 = new Matrix(2, 2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };

        double[][] matr_t3 = {
                {3, 25},
                {10, -4}
        };
        test__1.fill(matr_t1);
        test__3.fill(matr_t3);
        Matrix test = test__1.transp(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }
    @Test
    public void testInvalid_5() {
        Matrix test__1 = new Matrix(2,3);


        double[][] matr_t1 = {
                {3, 10, 7},
                {25, -4, 9}
        };

        test__1.fill(matr_t1);
        assertThrows(IllegalStateException.class, () -> {
            test__1.transp(test__1);
        });

    }

    @Test
    void test_21() {
        Matrix test__1 = new Matrix();
        Matrix test__3 = new Matrix(2, 2);

        double[][] matr_t3 = {
                {3, 0},
                {0, -4}
        };
        test__3.fill(matr_t3);
        double[] vector_t = {3, -4};
        Matrix test = test__1.diag(vector_t);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_22() {
        Matrix test__1 = new Matrix();
        Matrix test__3 = new Matrix(2, 2);

        double[][] matr_t3 = {
                {1, 1},
                {1, 1}
        };
        test__3.fill(matr_t3);

        Matrix test = test__1.one(2, 2);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_23() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__3 = new Matrix(2, 2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };

        double[][] matr_t3 = {
                {3, 10},
                {0, -87.33}
        };
        test__1.fill(matr_t1);
        test__3.fill(matr_t3);
        Matrix test = test__1.lower(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_24() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__3 = new Matrix(2, 2);
        double[][] matr_t1 = {
                {0, 10},
                {25, -4}
        };

        double[][] matr_t3 = {
                {25, -4},
                {0, 10}
        };
        test__1.fill(matr_t1);
        test__3.fill(matr_t3);
        Matrix test = test__1.lower(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_25() {
        Matrix test__1 = new Matrix(3,3);
        Matrix test__3 = new Matrix(3, 3);
        double[][] matr_t1 = {
                {5, 10, 8},
                {25, 0, 9},
                {11, -5, 6}
        };

        double[][] matr_t3 = {
                {5, 10, 8},
                {0, -50, -31},
                {0, 0, 5.14}
        };
        test__1.fill(matr_t1);
        test__3.fill(matr_t3);
        Matrix test = test__1.lower(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_26() {
        Matrix test__1 = new Matrix(3,3);
        Matrix test__3 = new Matrix(3, 3);
        double[][] matr_t1 = {
                {5, 10, 8},
                {25, 0, 9},
                {11, -5, 6}
        };

        double[][] matr_t3 = {
                {-28.56, 0, 0},
                {8.5, 7.5, 0},
                {11, -5, 6}
        };
        test__1.fill(matr_t1);
        test__3.fill(matr_t3);
        Matrix test = test__1.up(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_27() {
        Matrix test__1 = new Matrix(2,2);
        Matrix test__3 = new Matrix(2, 2);
        double[][] matr_t1 = {
                {5, 10},
                {25, 3}
        };

        double[][] matr_t3 = {
                {-78.33, 0},
                {25, 3}
        };
        test__1.fill(matr_t1);
        test__3.fill(matr_t3);
        Matrix test = test__1.up(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }
    @Test
    public void testInvalid_9() {
        Matrix test__1 = new Matrix(3,2);
        double[][] matr_t1 = {
                {3, 9},
                {6, 2},
                {2, 4}
        };
        test__1.fill(matr_t1);
        assertThrows(IllegalStateException.class, () -> {
            test__1.lower(test__1);
        });
    }

    @Test
    public void testInvalid_10() {
        Matrix test__1 = new Matrix(2,3);
        double[][] matr_t1 = {
                {3, 9, 1},
                {6, 2, 12}
        };
        test__1.fill(matr_t1);
        assertThrows(IllegalStateException.class, () -> {
            test__1.up(test__1);
        });
    }
    @Test
    void test_im1() {
        Matrix matr = new Matrix(2, 3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        double val_t = test__1.val(2, 2);
        assertEquals(2, val_t);

    }

    @Test
    void test_im2() {
        Matrix matr = new Matrix(3, 3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        double val_t = test__1.val(1, 1);
        assertEquals(3, val_t);
    }


    @Test
    void test_3_im() {
        Matrix matr = new Matrix(3, 3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        double[] row_t = test__1.row_1(1);
        double[] res = {3.0, 9.0, 12.0};
        assertArrayEquals(res, row_t, 0.0001);
    }

    @Test
    void test_4_im() {
        Matrix matr = new Matrix(3, 3);

        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        double[] row_t = test__1.row_1(3);
        double[] res = {2.0, 4.0, 5.0};
        assertArrayEquals(res, row_t, 0.0001);
    }

    @Test
    void test_5_im() {
        Matrix matr = new Matrix(3, 3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        double[] row_t = test__1.col_1(3);
        double[] res = {12.0, -9.0, 5.0};
        assertArrayEquals(res, row_t, 0.0001);
    }

    @Test
    void test_6_im() {
        Matrix matr = new Matrix(3, 3);

        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        double[] row_t = test__1.col_1(1);
        double[] res = {3.0, 6.0, 2.0};
        assertArrayEquals(res, row_t, 0.0001);
    }

    @Test
    public void testInvalid_1_im() {
        Matrix matr = new Matrix(3, 3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);

        assertThrows(IllegalStateException.class, () -> {
            test__1.col_1(4);
        });
    }

    @Test
    public void testInvalid_2_im() {
        Matrix matr = new Matrix(3, 3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        assertThrows(IllegalStateException.class, () -> {
            test__1.row_1(4);
        });
    }

    @Test
    void test_7_im() {
        Matrix matr = new Matrix(3,3);
        double[][] matr_t1 = {
                {3, 9, 12},
                {6, 2, -9},
                {2, 4, 5}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        int[] size_t = test__1.size_1();
        int[] res = {3, 3};
        assertArrayEquals(res, size_t);
    }

    @Test
    void test_8_im() {
        matrix_im test__1 = new matrix_im(1,3);
        int[] size_t = test__1.size_1();
        int[] res = {1, 3};
        assertArrayEquals(res, size_t);
    }

    @Test
    void test_9_im() {
        Matrix matr = new Matrix(2,2);
        double[][] matr_t1 = {
                {3, 9},
                {25, -4}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matrix_im test__2 = new matrix_im(test__1);
        boolean eq = test__1.equals(test__2);
        assertTrue(eq);
    }

    @Test
    void test_10_im() {
        Matrix matr = new Matrix(2,2);

        double[][] matr_t1 = {
                {3, 9},
                {25, -4}
        };
        double[][] matr_t2 = {
                {3, 9},
                {25, -4}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr);
        boolean eq = test__1.equals(test__2);
        assertTrue(eq);
    }
    @Test
    void test_11_im() {
        Matrix matr = new Matrix(2,2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {3, 9},
                {25, -4}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr);
        boolean eq = test__1.equals(test__2);
        assertFalse(eq);
    }

    @Test
    void test_12_im() {
        Matrix test__2 = new Matrix(2, 2);

        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {3, 10},
                {25, -4}
        };
        test__2.fill(matr_t2);
        matrix_im test__1 = new matrix_im(test__2);
        boolean eq = test__1.equals(test__2);
        assertFalse(eq);
    }

    @Test
    void test_13_im() {
        Matrix matr = new Matrix(2,2);

        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {3, 10},
                {25, -4}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr);
        assertEquals(test__1.hashCode(), test__2.hashCode());
    }

    @Test
    void test_14_im() {
        Matrix matr = new Matrix(2,2);

        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {3, 10},
                {25, 4}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr);
        assertNotEquals(test__1.hashCode(), test__2.hashCode());
    }

    @Test
    void test_15_im() {
        Matrix matr = new Matrix(2,2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 10},
                {25, -4}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr);
        assertNotEquals(test__1.hashCode(), test__2.hashCode());
    }

    @Test
    void test_16_im() {
        Matrix matr = new Matrix(2,2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 10},
                {-25, -4}
        };
        double[][] matr_t3 = {
                {5, 20},
                {0, -8}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr);
        matr.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr);
        matrix_im test = test__1.addit(test__2);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_17_im() {
        Matrix matr = new Matrix(2,2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 10},
                {-25, -4}
        };
        double[][] matr_t3 = {
                {5, 20},
                {0, 8}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr);
        matr.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr);
        matrix_im test = test__1.addit(test__2);
        boolean eq = test__3.equals(test);
        assertFalse(eq);
    }

    @Test
    public void testInvalid_3_im() {
        Matrix matr_1 = new Matrix(2, 2);
        Matrix matr_2 = new Matrix(2, 1);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2},
                {-25}
        };

        matr_1.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr_1);
        matr_2.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr_2);
        assertThrows(IllegalStateException.class, () -> {
            test__1.addit(test__2);
        });
    }
    @Test
    void test_18_im() {
        Matrix matr = new Matrix(2,2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 10},
                {-25, -4}
        };
        double[][] matr_t3 = {
                {-244, -10},
                {150, 266}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr);
        matr.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr);
        matrix_im test = test__1.mult(test__2);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_19_im() {
        Matrix matr_1 = new Matrix(2,3);
        Matrix matr_2 = new Matrix(3, 2);
        Matrix matr_3 = new Matrix(2, 2);
        double[][] matr_t1 = {
                {3, 10, 9},
                {25, -4, 7}
        };
        double[][] matr_t2 = {
                {2, 10},
                {-25, -4},
                {1, 2}
        };
        double[][] matr_t3 = {
                {-235, 8},
                {157, 280}
        };
        matr_1.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr_1);
        matr_2.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr_2);
        matr_3.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr_3);
        matrix_im test = test__1.mult(test__2);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    public void testInvalid_4_im() {
        Matrix matr_1 = new Matrix(2, 2);
        Matrix matr_2 = new Matrix(1,2);

        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };
        double[][] matr_t2 = {
                {2, 3},
        };

        matr_1.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr_1);
        matr_2.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr_2);
        assertThrows(IllegalStateException.class, () -> {
            test__1.mult(test__2);
        });

    }

    @Test
    void test_20_im() {
        Matrix matr = new Matrix(2,2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };

        double[][] matr_t3 = {
                {3, 25},
                {10, -4}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t3);
        matrix_im test__2 = new matrix_im(matr);
        matrix_im test = test__1.transp(test__1);
        boolean eq = test__2.equals(test);
        assertTrue(eq);
    }
    @Test
    public void testInvalid_5_im() {
        Matrix matr = new Matrix(2,3);


        double[][] matr_t1 = {
                {3, 10, 7},
                {25, -4, 9}
        };

        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        assertThrows(IllegalStateException.class, () -> {
            test__1.transp(test__1);
        });

    }

    @Test
    void test_21_im() {
        Matrix test__3 = new Matrix(2, 2);
        double[][] matr_t3 = {
                {3, 0},
                {0, -4}
        };
        test__3.fill(matr_t3);
        double[] vector_t = {3, -4};
        matrix_im test__1 = new matrix_im();
        matrix_im test__2 = new matrix_im(test__3);
        matrix_im test = test__1.diag(vector_t);
        boolean eq = test__2.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_22_im() {
        matrix_im test__1 = new matrix_im();
        Matrix test__3 = new Matrix(2, 2);
        double[][] matr_t3 = {
                {1, 1},
                {1, 1}
        };
        test__3.fill(matr_t3);
        matrix_im test__2 = new matrix_im(test__3);
        matrix_im test = test__1.one(2, 2);
        boolean eq = test__2.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_23_im() {
        Matrix matr = new Matrix(2,2);
        double[][] matr_t1 = {
                {3, 10},
                {25, -4}
        };

        double[][] matr_t3 = {
                {3, 10},
                {0, -87.33}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr);

        matrix_im test = test__1.lower(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_24_im() {
        Matrix matr = new Matrix (2,2);
        double[][] matr_t1 = {
                {0, 10},
                {25, -4}
        };

        double[][] matr_t3 = {
                {25, -4},
                {0, 10}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr);
        matrix_im test = test__1.lower(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_25_im() {
        Matrix matr = new Matrix(3,3);
        double[][] matr_t1 = {
                {5, 10, 8},
                {25, 0, 9},
                {11, -5, 6}
        };

        double[][] matr_t3 = {
                {5, 10, 8},
                {0, -50, -31},
                {0, 0, 5.14}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr);
        matrix_im test = test__1.lower(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_26_im() {
        Matrix matr = new Matrix(3,3);
        double[][] matr_t1 = {
                {5, 10, 8},
                {25, 0, 9},
                {11, -5, 6}
        };

        double[][] matr_t3 = {
                {-28.56, 0, 0},
                {8.5, 7.5, 0},
                {11, -5, 6}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr);
        matrix_im test = test__1.up(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_27_im() {
        Matrix matr = new Matrix(2,2);
        double[][] matr_t1 = {
                {5, 10},
                {25, 3}
        };

        double[][] matr_t3 = {
                {-78.33, 0},
                {25, 3}
        };
        matr.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr);
        matr.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr);
        matrix_im test = test__1.up(test__1);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }
    @Test
    public void testInvalid_9_im() {
        Matrix test__2 = new Matrix(3,2);
        double[][] matr_t1 = {
                {3, 9},
                {6, 2},
                {2, 4}
        };
        test__2.fill(matr_t1);
        matrix_im test__1 = new matrix_im(test__2);
        assertThrows(IllegalStateException.class, () -> {
            test__1.lower(test__1);
        });
    }

    @Test
    public void testInvalid_10_im() {
        Matrix test__2 = new Matrix(2,3);
        double[][] matr_t1 = {
                {3, 9, 1},
                {6, 2, 12}
        };
        test__2.fill(matr_t1);
        matrix_im test__1 = new matrix_im(test__2);
        assertThrows(IllegalStateException.class, () -> {
            test__1.up(test__1);
        });
    }

    /*@Test
    public void testInvalid_11_im() {
        Matrix test__2 = new Matrix(2,3);
        double[][] matr_t1 = {
                {3, 9, 1},
                {6, 2, 12}
        };
        test__2.fill(matr_t1);
        matrix_im test__1 = new matrix_im(test__2);
        assertThrows(IllegalStateException.class, () -> {
            test__1.fill(matr_t1);
        });
    }*/

    /*@Test
    public void testInvalid_12_im() {
        matrix_im test__1 = new matrix_im(2,3);
        double[][] matr_t1 = {
                {3, 9, 1},
                {6, 2, 12}
        };
        test__1.fill(matr_t1);
        assertThrows(IllegalStateException.class, () -> {
            test__1.fill_random();
        });
    }*/

    /*@Test
    public void testInvalid_13_im() {
        matrix_im test__1 = new matrix_im(2,3);
        matrix_im test__2 = new matrix_im(3, 2);

        double[][] matr_t1 = {
                {3, 10, 9},
                {25, -4, 7}
        };
        double[][] matr_t2 = {
                {2, 10},
                {-25, -4},
                {1, 2}
        };

        test__1.fill(matr_t1);
        test__2.fill(matr_t2);

        matrix_im test = test__1.mult(test__2);
        assertThrows(IllegalStateException.class, () -> {
            test.fill(matr_t1);
        });
    }*/

    @Test
    public void test_im() {
        Matrix matr_1 = new Matrix(4,4);

        double[][] matr_t1 = {
                {3, 10, 9, 3},
                {25, -4, 7, 2},
                {3, 11, 2, 0},
                {5, 2, 1, 3}
        };
        double[][] matr_t2 = {
                {2, 10, 7, 8},
                {-25, -4, 2, 1},
                {1, 2, 2, 9},
                {11, 0, 3, 4}
        };
        double[][] matr_t3 = {
                {-202, 8, 68, 127},
                {179, 280, 187, 267},
                {-267, -10, 47, 53},
                {-6, 44, 50, 63}
        };

        matr_1.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr_1);
        matr_1.fill(matr_t2);
        matrix_im test__2 = new matrix_im(matr_1);
        matr_1.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr_1);
        matrix_im test = test__1.mult(test__2);
        boolean eq = test__3.equals(test);
        assertTrue(eq);
    }

    @Test
    void test_32_im() {
        Matrix matr_1 = new Matrix(3,3);
        double[][] matr_t1 = {
                {5, 10, 8},
                {25, 0, 9},
                {11, -5, 6}
        };

        double[][] matr_t3 = {
                {5, 10, 8},
                {25, 0, 9},
                {11, -5, 6}
        };
        matr_1.fill(matr_t1);
        matrix_im test__1 = new matrix_im(matr_1);
        matr_1.fill(matr_t3);
        matrix_im test__3 = new matrix_im(matr_1);
        matrix_im test = test__1.transp(test__1);
        boolean eq = test__3.equals(test__1);
        assertTrue(eq);
    }




}
