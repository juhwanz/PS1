package 유니온파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _050 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i =0; i<N+1;i++) parent[i] = i;

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int Q = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(Q==0) union(a,b);
            else{
                if(checkSame(a,b)) System.out.println("Yes");
                else System.out.println("NO");
            }
        }

    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b) parent[b]=a;
    }
    public static int find(int a){
        if(parent[a]==a) return a;
        return parent[a]=find(parent[a]);
    }

    public static boolean checkSame(int a, int b){
        if(find(a) == find(b)) return true;
        return false;
    }
}
