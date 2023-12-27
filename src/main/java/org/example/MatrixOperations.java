package org.example;

public class MatrixOperations {
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] matrixC;

    public MatrixOperations(int[][] matrixA, int[][] matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }

    // Метод для додавання матриць A і B
    public void addMatrices() throws IllegalArgumentException {
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            throw new IllegalArgumentException("Розміри матриць не співпадають");
        }

        matrixC = new int[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
    }

    // Метод для знаходження середнього значення елементів матриці C
    public double findAverage() {
        int sum = 0;
        int count = 0;
        for (int[] row : matrixC) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }
        return (double) sum / count;
    }

    public static void main(String[] args) {
        try {
            // Ініціалізація матриць A і B
            int[][] A = {{1, 2}, {3, 4}};
            int[][] B = {{5, 6}, {7, 8}};

            MatrixOperations matrixOps = new MatrixOperations(A, B);

            // Додавання матриць і знаходження середнього
            matrixOps.addMatrices();
            double average = matrixOps.findAverage();

            // Виведення результатів
            System.out.println("Матриця C (A + B):");
            for (int[] row : matrixOps.matrixC) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
            System.out.println("Середнє значення елементів матриці C: " + average);
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
