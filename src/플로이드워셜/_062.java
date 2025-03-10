package 플로이드워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _062 {
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        D = new int[N][N];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                D[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-워셜 알고리즘
        for(int k = 0; k<N; k++){
            for(int i = 0; i<N; i++){
                for(int j =0; j<N; j++){
                    if(D[i][k] == 1 && D[k][j] == 1) D[i][j] = 1;
                }
            }
        }

        for(int[] A : D){
            System.out.println();
            for(int B : A){
                System.out.print(B+" ");
            }
        }
    }
}
