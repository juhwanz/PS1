import java.util.*;

public class 미로찾기 {
    static int N,M;
    static int[][] Map;
    static boolean[][] visited;
    static int[] dx = { -1, 1, 0, 0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        Map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            String line = sc.nextLine();
            for(int j = 0; j<M; j++){
                Map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(Map[N-1][M-1]);
    }

    public static void bfs(int x, int y){
        Queue<int[] > q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;

        
    }
}
