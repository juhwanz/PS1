import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        float sum = 0;
        float totalPoint = 0;  // 학점 총합
        int count = 20;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken(); // 과목 이름
            float point = Float.parseFloat(st.nextToken()); // 학점
            String avp = st.nextToken(); // 성적

            if (!avp.equals("P")) { // "P" 학점 제외
                sum += point * avp_f(avp);
                totalPoint += point;
            }
        }

        // 평균 학점 출력 (나눗셈 오류 방지를 위해 totalPoint == 0 예외 처리)
        System.out.printf("%.6f", totalPoint == 0 ? 0.0 : sum / totalPoint);
    }

    // 성적을 점수로 변환하는 메서드
    static float avp_f(String a) {
        switch (a) {
            case "A+": return 4.5f;
            case "A0": return 4.0f;
            case "B+": return 3.5f;
            case "B0": return 3.0f;
            case "C+": return 2.5f;
            case "C0": return 2.0f;
            case "D+": return 1.5f;
            case "D0": return 1.0f;
            case "F": return 0.0f;
            default: return 0.0f; // 오류 방지
        }
    }
}
