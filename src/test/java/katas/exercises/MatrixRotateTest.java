package katas.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixRotateTest {

    @Test
    void testRotateMatrix_3x3() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}

        };

        MatrixRotate.rotateMatrix(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotateMatrix_4x4() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] expected = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };

        MatrixRotate.rotateMatrix(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotateMatrix_1x1() {
        int[][] matrix = {
                {1}
        };

        int[][] expected = {
                {1}
        };

        MatrixRotate.rotateMatrix(matrix);

        assertArrayEquals(expected, matrix);
    }

    @Test
    void testRotateMatrix_2x2() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int[][] expected = {
                {3, 1},
                {4, 2}
        };

        MatrixRotate.rotateMatrix(matrix);

        assertArrayEquals(expected, matrix);
    }


    @Test
    void testRotateMatrix_EmptyMatrix() {
        int[][] matrix = {};

        int[][] expected = {};

        MatrixRotate.rotateMatrix(matrix);

        assertArrayEquals(expected, matrix);
    }
}
