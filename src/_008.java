import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _008 {
    // 투 포인터
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long A[] = new long[N];
        int Result =0;

        for(int i =0; i<N; i++) A[i] = Long.parseLong(br.readLine());
        Arrays.sort(A);

        //Two Pointer
        for(int k =0; k<N; k++){
            long find = A[k];
            int i = 0;
            int j = N-1;

            while(i<j){
                if(A[i]+A[j]==find){
                    if(i!=k && j!=k){
                        Result++;
                        break;
                    }else if(i==k){
                        i++;
                    }else if(i==j){
                        j--;
                    }
                } else if (A[i]+A[j]>find) {
                    j--;
                }else{
                    i++;
                }
            }
        }
        System.out.println(Result);
        br.close();
    }
}
