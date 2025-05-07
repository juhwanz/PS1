public class Levenshtein {

    static int getDistance(String s1, String s2){
        int[][] D = new int[s1.length()][s2.length()];
        for(int i = 0; i<s1.length(); i++){
            D[i][0]=i;
        }
        for(int j = 0; j<s2.length(); j++){
            D[0][j]=j;
        }
        for(int i =0; i<s1.length(); i++){
            for(int j = 0; j<s2.length(); j++){
                int insert = D[i-1][j] +1;
                int delete = D[i][j-1] +1;
                int substitute = D[i-1][j-1] + (s1.charAt(i) == s2.charAt(j) ? 0:1);
            }
        }
        return D[s1.length()][s2.length()];
    }
    
    public static void main(String[] args) {

    }
}
