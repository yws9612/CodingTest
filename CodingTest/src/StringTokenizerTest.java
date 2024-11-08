import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {

        String str = "안 녕 하 세 요";
        StringTokenizer st = new StringTokenizer(str, " ");

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
