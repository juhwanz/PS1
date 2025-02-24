import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N+1];
        for(int i =0; i<N+1; i++) A[i] = i;

        for(int i =2; i<=Math.sqrt(N); i++){
            if(A[i]==0) continue;
            for(int j = i+i; j<M; j=j+i){
                A[j]=0;
            }
        }

        for(int i = M; i<N; i++){
            if(A[i]!=0) System.out.println(A[i]);
        }
    }

}