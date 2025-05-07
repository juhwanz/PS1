public class Fibonacci {
    // 재귀 방식 (O(2^n))
    static int fibonacci_recur(int n) {
        if (n < 2) return n;
        return fibonacci_recur(n - 1) + fibonacci_recur(n - 2);
    }

    // 반복문 방식 (O(n))
    static int fibonacci_iter(int n) {
        if (n < 2) return n;

        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = prev + curr;
            prev = curr;
            curr = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Fibonacci (재귀) [" + n + "]: " + fibonacci_recur(n));
        System.out.println("Fibonacci (반복) [" + n + "]: " + fibonacci_iter(n));
    }
}
