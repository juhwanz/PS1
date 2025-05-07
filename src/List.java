import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class List {
    //리스트 자료형은 ArrayList, Vector, LinkedList가 있다.
    //자료형의 갯수가 계속 변하는 상황 -> list
    public static void main(String[] args) {
        ArrayList pitches = new ArrayList();
        pitches.add("136");
        pitches.add("129");
        pitches.add("142");
        pitches.add(0, "133");
        //get
        System.out.println(pitches.get(1));
        //size
        System.out.println(pitches.size());
        //contains
        System.out.println(pitches.contains("136"));

        //remove(인덱스) or remove(객체)
        System.out.println(pitches.remove("129"));//->true/false
        System.out.println(pitches.remove(0));//객체 반환후 삭제

        //제네릭스 -> 형변환 필요 없음.
        //이미 문자열 배열이 있는 경우
        String[] data = {"111", "222", "333"};
        ArrayList<String> pitch = new ArrayList<>(Arrays.asList(data));
        ArrayList<String> pitch2 = new ArrayList<>(Arrays.asList("123","456","789"));

        //string.join 각 요소 중간에 요소 넣기
        String result = String.join(",", pitches);
        System.out.println(result);

        //리스트 정렬
        pitches.sort(Comparator.naturalOrder()); //asec
        pitches.sort(Comparator.reverseOrder()); //desc
    }
}
