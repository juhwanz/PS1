import java.io.*;
import java.util.*;

public class _059 {
    static long[] distance;
    static Edge59[] Edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        distance = new long[N + 1];
        Edge = new Edge59[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            Edge[i]=new Edge59(start,end,time);
        }

        //Bellman-ford Algorithm
        distance[1] = 0; // first distance 0 init
        for(int i=1; i<N;i++){ // N-1 loop
            for(int j=0; j<M; j++){
                Edge59 tmp_edge = Edge[j];
                // less than value -> update
                if(distance[tmp_edge.start] != Long.MAX_VALUE && distance[tmp_edge.end] > distance[tmp_edge.start]+ tmp_edge.weight){
                    distance[tmp_edge.end] = distance[tmp_edge.start] + tmp_edge.weight;
                }
            }
        }

        // find minus cycle
        boolean mCycle = false;
        for(int i = 0; i<M; i++){
            Edge59 edge = Edge[i];
            if (distance[edge.start] != Long.MAX_VALUE && distance[edge.end] > distance[edge.start] + edge.weight) {
                mCycle = true;
            }
        }

        //if minus cycle absent
        if(mCycle){
            for(int i =2; i<N; i++){
                if(distance[i] == Long.MAX_VALUE) System.out.println("-1");
                System.out.println(distance[i]);
            }
        }else{
            System.out.println("-1");
        }
    }
}

class Edge59{
    int start, end, weight;
    public Edge59(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
