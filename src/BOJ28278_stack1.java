import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ28278_stack1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(); // 출력 성능 최적화

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());

            switch (A) {
                case 1:
                    int X = Integer.parseInt(st.nextToken());
                    stack.push(X);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    sb.append(stack.isEmpty() ? "1\n" : "0\n");
                    break;
                case 5:
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek()).append("\n");
                    } else {
                        sb.append("-1\n");
                    }
                    break;
            }
        }

        System.out.print(sb); // 한 번에 출력 (입출력 성능 향상)
    }
}
