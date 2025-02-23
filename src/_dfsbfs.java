import java.util.*;

public class _dfsbfs {
    static boolean visited[];
    static ArrayList<Integer>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Start = sc.nextInt(); // 시작점
        A= new ArrayList[N+1];
        for(int i =1; i<=N; i++) A[i]= new ArrayList<>();
        for(int i =0; i<N; i++){
            int S= sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        //정렬
        for(int i=1; i<=N; i++){
            Collections.sort(A[i]);
        }

        visited= new boolean[N+1];

        DFS(Start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(Start);
        System.out.println();

    }


    static void DFS(int Node){
        if(visited[Node]) return;
        visited[Node] = true;
        for(int i : A[Node]){
            if(!visited[i]) DFS(i);
        }
    }

    static void BFS(int Node){
        Queue<Integer> q = new LinkedList<>();
        q.add(Node);
        visited[Node]=true;
        while(!q.isEmpty()){
            int now_Node = q.poll();
            System.out.println(now_Node);
            for(int i : A[now_Node]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
