package 다익스트라;

import java.util.*;
import java.io.*;

public class _057 {
    static ArrayList<Edge57>[] A;
    static boolean[] visited;
    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int City = Integer.parseInt(br.readLine());
        int Bus = Integer.parseInt(br.readLine());

        A=new ArrayList[City+1];
        visited=new boolean[City+1];
        D=new int[City+1];

        for(int i = 0; i < City+1; i++) A[i]=new ArrayList<>();
        for(int i = 0; i< City+1; i++) D[i]=Integer.MAX_VALUE;

        StringTokenizer st;

        for(int i =0; i<Bus; i++){
            st=  new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            A[s].add(new Edge57(e,w));
        }

        st=new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        PriorityQueue<Edge57> pq = new PriorityQueue<>();
        pq.add(new Edge57(start, 0));
        D[start]=0;

        while(!pq.isEmpty()){
            Edge57 now = pq.poll();
            int n_v = now.to;
            if(visited[n_v]) continue;
            visited[n_v]=true;

            for(int i=0; i<A[n_v].size();i++){
                Edge57 tmp = A[n_v].get(i);
                int Next_v = tmp.to;
                int Next_w = tmp.pay;
                if(D[Next_v]>D[n_v]+Next_w){
                    D[Next_v]=D[n_v]+Next_w;
                    pq.add(new Edge57(Next_v, D[Next_v]));
                }
            }
        }

        System.out.println(D[end]);

    }
}

class Edge57 implements Comparable<Edge57>{
    int to, pay;
    public Edge57(int to, int pay){
        this.to = to;
        this.pay = pay;
    }
    public int compareTo(Edge57 o) {
        return pay - o.pay;
    }
}