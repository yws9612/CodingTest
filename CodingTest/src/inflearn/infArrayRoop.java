package inflearn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class infArrayRoop {
    public static void main(String[] args) throws Exception {
        /*
            Nums에 리스트 요소들을 입력받는다. target을 입력받고, nums 배열 요소들의 합이 target과 같으면 true, 아니면 false를 반환
            생각한 알고리즘으로는 이중 for문을 사용하여 요소를 하나씩 탐색하는것이지만, 시간복잡도가 O(N^2)로 시간 초과 가능성이 존재하기에
            시간 복잡도 조건을 잘 보며 안맞을 경우 다른 알고리즘으로 풀이한다.
         */
        int arr[] = {2, 1, 5, 7};
        int target = 4;

        boolean bool = false;

        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length; j++){
                if(arr[i] + arr[j] == target){
                    bool = true;
                }
            }
        }

        System.out.println(bool);
    }
}
