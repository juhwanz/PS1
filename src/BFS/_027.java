package BFS;

import java.io.*;
import java.util.*;

public class _027 {
    //상하 좌우 y에 1을 더하면 오른쪽, x에 1을 더하면 아래쪽

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static boolean[][] visited;
    static int[][] A;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine()); // 한줄 읽어 와
            String line = st.nextToken();// 또 한줄 읽어와
            for(int j = 0; j< M; j++){ // .substring(start index, last index)
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        BFS(0,0);
        System.out.println(A[N-1][M-1]);
        for(int i =0; i<N; i++){
            for(int j = 0; j<M; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void BFS(int i , int j){
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] { i , j });
        visited[i][j] = true;
        while(!Q.isEmpty()){
            int now[] = Q.poll();
            for(int k = 0; k< 4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                //유효성 검사
                if(x>=0 && y >= 0 && x<N && y<M){
                    //갈 수 있는 칸 && 방문 검사
                    if(A[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        //깊이 업데이트
                        A[x][y] = A[now[0]][now[1]]+1;
                        Q.add(new int[]{ x, y});
                    }
                }
            }
        }

    }
}
