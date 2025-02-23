import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) A[i] = Integer.parseInt(st.nextToken());

        //합 배열 만들기 S[i] = S[i-1]+A[i]
        int[] sA = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            sA[i] = sA[i - 1] + A[i];
        }

        //구간 합 공식 : S[j] - S[i-1]
        while(M>0){
            st= new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            System.out.println(sA[E]-sA[S-1]);
            M--;
        }

    }
}
