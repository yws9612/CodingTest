package inflearn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class infStackProb {
    public static void main(String[] args) throws Exception {
        /*
        스택의 대표 유형 문제 괄호 유효성 검사
            ㄴ 이런 문제들을 템플릿 화 할 수 있을 정도로 많이 반복해서 풀어볼 것.
        특정 조건이 만족돼 반응하는 문제의 경우 스택을 사용하면 좋음
         */
        int [] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int n = temperatures.length;
        int[] ans = new int[n]; // 결과를 저장할 배열
        Stack<int[]> stack = new Stack<>(); // 스택: {day, temp} 형태로 저장

        /*
        2중 for문은 무조건 for문을 반복 하기 때문에 o(n^2)가 맞지만,
        아래 코드는 while문의 총 실행 결과가 n번이기 때문에 o(n)이 된다.
         */
        for (int curDay = 0; curDay < n; curDay++) {
            int curTemp = temperatures[curDay];

            // 스택에 값이 있고 현재 온도가 스택의 마지막 온도보다 높은 경우
            while (!stack.isEmpty() && stack.peek()[1] < curTemp) {
                int[] prev = stack.pop();
                int prevDay = prev[0];
                ans[prevDay] = curDay - prevDay;
            }

            // 스택에 현재 날과 온도를 추가
            stack.push(new int[]{curDay, curTemp});
        }

        for(int j = 0; j < ans.length; j++){
            System.out.print(ans[j] + " ");
        }
    }
}
