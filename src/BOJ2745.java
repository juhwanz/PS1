import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            int value;

            if (a >= '0' && a <= '9') value = a - '0';
            else value = a - 'A' + 10;

            sum += value * Math.pow(B, (str.length() - 1 - i)); // 올바른 자릿수 적용
        }

        System.out.println(sum);
    }
}
