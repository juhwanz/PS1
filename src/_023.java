import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _023 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        A= new ArrayList[N];
        visited = new boolean[N];
        for(int i =0; i<N;i++) A[i] = new ArrayList<>();
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s= Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        int count =0;
        for(int i =0; i< N; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    static void DFS(int node){
        if(visited[node]) return;
        visited[node] = true;
        for(int i : A[node]){
            if(visited[i] == false) DFS(i);
        }
    }
}
