package inflearn;

import java.util.Arrays;

public class infTwoPointer {
    public static void main(String[] args) {
        /*
        리스트/원소가 존재할 때, 리스트 정렬 시간 복잡도는 O(nlogn)
        two pointer : [1, 3, 5, 7, 2]라는 리스트가 존재 할 경우 두개의 포인터(아래 예제에서는 2, 7)를 갖고 문제를 풀이하는 방법
            ㄴ 정렬이 된 상황에서 사용, 정형화된 방법은 아님.

        아래 코드의 시간복잡도의 경우, 반복문 O(n), if/리스트 찾기 O(1), 정렬 O(nlogn)이고, 모든 코드의 시간 복잡도는 가장 오래걸리는
        시간 복잡도 기준이기 때문에 O(nlogn)이다.
         */
        int []arr = {2, 1, 5, 7};
        int target = 4;

        boolean check = false;

        Arrays.sort(arr); //O(nlogn)

        int l = 0;
        int r = arr.length - 1;

        while(l < r){
            if(arr[l] + arr[r] == target){
                check = true;
                break;
            }else if(arr[l] + arr[r] < target){
                l += 1;
            }else if(arr[l] + arr[r] > target){
                r -= 1;
            }
        }
        System.out.println(check);
    }
}
