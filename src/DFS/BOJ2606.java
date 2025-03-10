package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2606 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        A=new ArrayList[N+1];
        visited=new boolean[N+1];
        for(int i=1; i<N+1; i++) A[i]=new ArrayList<>();
        for(int i=0; i<E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        DFS(1);

        int count=0;

        for(int i=1; i<N+1;i++){
            if(visited[i])
                count++;
        }
        System.out.println(count-1);

    }

    static void DFS(int Node){
        if(visited[Node]) return;
        visited[Node]=true;
        for(int i : A[Node]){
            if(!visited[i]) DFS(i);
        }
    }
}
