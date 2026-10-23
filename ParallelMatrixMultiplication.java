class RowMultiplier extends Thread {
    int[][] A, B, C;
    int row;

    RowMultiplier(int[][] A, int[][] B, int[][] C, int row) {
        this.A = A; this.B = B; this.C = C; this.row = row;
    }

    public void run() {
        for (int j = 0; j < B[0].length; j++) {
            for (int k = 0; k < A[0].length; k++) {
                C[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}

public class ParallelMatrixMultiplication {
    public static void main(String[] args) throws InterruptedException {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int rowsA = A.length, colsB = B[0].length;
        int[][] C = new int[rowsA][colsB];

        Thread[] threads = new Thread[rowsA];

        // Create and start a thread for each row of the result matrix
        for (int i = 0; i < rowsA; i++) {
            threads[i] = new RowMultiplier(A, B, C, i);
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread t : threads) t.join();

        // Print Result Matrix C
        System.out.println("Result Matrix C:");
        for (int[] row : C) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}