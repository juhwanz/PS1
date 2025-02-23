import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> D = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for(int i =0; i< N; i++){
            int now = Integer.parseInt(st.nextToken());

            while(!D.isEmpty() && D.getLast().value > now){
                D.removeLast();
            }
            D.addLast(new Node(now, i));

            if(D.getFirst().index<=i-L){
                D.removeFirst();
            }
            bw.write(D.getFirst().value + " ");
        }
        bw.flush();
        bw.close();

    }

    static class Node{
        int value;
        int index;
        public Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
