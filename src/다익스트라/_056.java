package 다익스트라;

import java.io.*;
import java.util.*;

public class _056 {
    static int V,E,K;
    static int distance[];
    static boolean visited[];
    static ArrayList<Edge56> list[];
    static PriorityQueue<Edge56> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        distance = new int[V+1];
        visited = new boolean[V+1];
        list = new ArrayList[V+1];
        for(int i = 1; i<=V; i++){
            list[i] = new ArrayList<Edge56>();
        }
        for(int i = 0; i<=V+1; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        //가중치가 있는 인접 리스트 초기화하기
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge56(v,w));
        }

        //k를 시작점으로 설정
        pq.add(new Edge56(K,0));

        distance[K] = 0;

        while(!pq.isEmpty()){
            Edge56 current = pq.poll();
            int c_v = current.vertex;
            if(visited[c_v]) continue;
            visited[c_v] = true;
            for(int i = 0; i< list[c_v].size(); i++){
                Edge56 tmp = list[c_v].get(i);
                int next = tmp.vertex;
                int value = tmp.value;
                if(distance[next] > distance[c_v] + value){
                    distance[next] = distance[c_v] + value;
                    pq.add(new Edge56(next, distance[next]));
                }
            }
        }


        for(int i =1; i<=V; i++){
            if(visited[i])
                System.out.println(distance[i]);
            else
                System.out.println("INF");
        }
        
    }

}

class Edge56 implements Comparable<Edge56>{
    int vertex, value;
    Edge56(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }
    public int compareTo(Edge56 e){
        if(this.value > e.value) return 1;
        else return -1;
    }
}
