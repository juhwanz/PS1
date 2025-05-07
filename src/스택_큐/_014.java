package 스택_큐;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _014 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            // 리턴 값이 양수 이면 자리 바꿈.(우선순위가 높다)
            if(first_abs == second_abs) return o1>o2 ? 1 : -1;
            else return first_abs - second_abs;
        });

        for(int i=0; i<N+1; i++){
            int request = sc.nextInt();
            if(request == 0){
                if(pq.isEmpty()) System.out.println("0");
                else System.out.println(pq.poll());
            }
            else pq.add(request);
        }
    }
}
