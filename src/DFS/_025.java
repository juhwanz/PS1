package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _025 {
    static boolean arrive;
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arrive = false;
        A = new ArrayList[N];
        for(int i =0; i<N; i++) A[i]=new ArrayList<>();

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        for(int i = 0; i<N; i++){
            DFS(i, 1);
            if(arrive) break;
        }
        if(arrive) System.out.println("1");
        System.out.println("0");
    }
    public static void DFS(int Node, int depth){
        if(depth==5 || arrive){
            arrive = true;
            return;
        }
        visited[Node] = true;
        for(int i : A[Node]){
            if(!visited[i]) DFS(i, depth+1);
        }
        visited[Node]=false;
    }
}
