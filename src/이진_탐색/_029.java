package 이진_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Data = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++) Data[i]=Integer.parseInt(st.nextToken());
        int findNum = Integer.parseInt(br.readLine());

        Arrays.sort(Data);

        st=new StringTokenizer(br.readLine());
        for(int i =0; i< findNum; i++){
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());

            int start = 1;
            int end = Data.length-1;
            while(start<=end){
                int midi = (start + end )/2;
                int midV = Data[midi];
                if(midV>target) end = midi-1;
                else if(midV<target) start = midi+1;
                else{
                    find = true;
                    break;
                }
            }
            if(find) System.out.println(1);
            else System.out.println(0);

        }





    }
}
