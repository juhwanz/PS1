import java.io.*;
import java.util.*;

public class _056 {
    static ArrayList<Edge56>[] A;
    static int[] D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        A= new ArrayList[N+1];
        D= new int[N+1];
        visited= new boolean[N+1];

        for(int i =0; i<N+1; i++) A[i]=new ArrayList<>();
        for(int i =0; i<N+1; i++) D[i]=Integer.MAX_VALUE;

        for(int i =0; i<E; i++){
            st= new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            A[S].add(new Edge56(L, W));
        }

        PriorityQueue<Edge56> pq= new PriorityQueue<>();
        pq.add(new Edge56(K, 0));
        D[K]=0;

        while(!pq.isEmpty()){
            Edge56 now = pq.poll();
            int n_v = now.v;
            if(visited[n_v])continue;
            visited[n_v]=true;

            for(int i=0; i<A[n_v].size(); i++){
                Edge56 tmp = A[n_v].get(i);
                int next = tmp.v;
                int weight = tmp.w;
                if(D[next]>D[n_v]+weight){
                    D[next]=D[n_v]+weight;
                    pq.add(new Edge56(next, D[next]));
                }
            }
        }
        for(int d : D){
            if(visited[d]) System.out.println(D[d]);
            else System.out.println("INF");
        }
    }
}

class Edge56 implements Comparable<Edge56>{
    int v,w;
    public Edge56(int vertex, int weight){
        this.v = vertex;
        this.w = weight;
    }
    public int compareTo(Edge56 o){
        if(this.w>o.w) return 1;
        else return -1;
    }
}
