import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int sum = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            if(!stack.isEmpty()){
                if(val == 0){
                    stack.pop();
                }else{
                    stack.add(val);
                }
            }else{
                stack.add(val);
            }
        }

        for(int j = 0; j < stack.size(); j++){
            sum += stack.get(j);
        }

        System.out.println(sum);
    }
}
