public class Fibonacci {
    // Non-Recursive (Iterative) - O(n) time, O(1) space
    public static long fibIterative(int n) {
        if (n <= 1) return n;
        long a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Recursive - O(2^n) time, O(n) space
    public static long fibRecursive(int n) {
        return (n <= 1) ? n : fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Iterative Fib(" + n + "): " + fibIterative(n));
        System.out.println("Recursive Fib(" + n + "): " + fibRecursive(n));
    }
}