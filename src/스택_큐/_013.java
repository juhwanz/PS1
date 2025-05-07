package 스택_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> Q = new LinkedList<>();
        for(int i = 1; i< N+1; i++){
            Q.add(i);
        }
        while(Q.size()>1){
            Q.poll();
            int num = Q.poll();
            Q.add(num);
        }
        System.out.println(Q.poll());
    }
}
