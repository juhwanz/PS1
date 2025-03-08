import java.io.*;
import java.util.*;

public class BOJ1446 {
    static ArrayList<Edge14>[] A;
    static boolean[] visited;
    static int[] Distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지름길 갯수
        int D = Integer.parseInt(st.nextToken()); // 고속도로 길이
        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        Distance = new int[N+1];
        for(int i =0; i<N+1; i++) A[i]=new ArrayList<>();
        for(int i =0; i<N+1; i++) Distance[i] = Integer.MAX_VALUE;

        for(int i =0; i< N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int dd = Integer.parseInt(st.nextToken());
            A[s].add(new Edge14(a,dd));
        }

        PriorityQueue<Edge14> pq = new PriorityQueue<>();
        pq.add(new Edge14(0,0));

    }
}

class Edge14 implements Comparable<Edge14>{
    int e, d;
    public Edge14(int e, int d) {
        this.e = e;
        this.d = d;
    }
    public int compareTo(Edge14 o) {
        return this.d-o.d;
    }
}