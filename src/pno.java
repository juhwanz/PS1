import java.util.*;

public class pno {
    static boolean[] visited_d;
    static boolean[] visited_b;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();
        A= new ArrayList[N+1];
        for(int i = 1; i<=N;i++) A[i]= new ArrayList<>();
        visited_d = new boolean[N + 1];
        visited_b = new boolean[N + 1];
        for(int i = 0; i<M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        for(int i=1; i<=N; i++){
            Collections.sort(A[i]);
        }
     DFS(start);
        System.out.println();
     BFS(start);
        System.out.println();
    }

    static void DFS(int Node){
        visited_d[Node] = true;
        for(int i : A[Node]){
            if(!visited_d[i]){
                DFS(i);
            }
        }
    }

    static void BFS(int Node){
        Queue<Integer> q = new LinkedList<>();
        q.add(Node);
        visited_b[Node] = true;
        while(!q.isEmpty()){
            int now_Node = q.poll();
            for(int i : A[now_Node]){
                    if(!visited_b[i]){
                        visited_b[i] = true;
                        q.add(i);
                    }
            }
        }
    }
}
