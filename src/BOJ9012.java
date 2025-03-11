import java.io.*;
import java.util.*;

public class BOJ9012 {
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            if(isValidNum(str)) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);
    }
    static boolean isValidNum(String str){
        stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(c == '(' ) stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

// 괄호는 '('부터 시작해야 한다. 따라서 '('일 경우 스택에 넣는다
// 1. 또 '(' 등장 -> 스택에 또 PUSH
// 2. ')' 등장 -> 스택에 들어가 있던 '('를 POP으로 제거 | 근데 만약 이때 스택이 비어 있다 -> NOT Valid
// 최종적으로 스택이 비어있으면 "YES"

// 스택에 확인이 필요한 값을 쭈루룩 넣으면서, 넣기 전에 짝이 맞으면 제거, 짝이 안맞으면 (비어있으면 거짓) 스택에 계속 넣는다.
