import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

        arr.add(A);
        visited.add(A);

        while (true) {
            int new_number = nextNum(A, P);

            if (visited.contains(new_number)) { // 이미 등장한 숫자라면
                System.out.println(arr.indexOf(new_number)); // 반복 시작 전 길이 출력
                break;
            }

            arr.add(new_number);
            visited.add(new_number);
            A = new_number; // A 갱신
        }
    }

    public static int nextNum(int A, int P) {
        int new_number = 0;
        while (A != 0) {
            new_number += (int) Math.pow(A % 10, P); // Math.pow() 형 변환 필요
            A /= 10;
        }
        return new_number;
    }
}
