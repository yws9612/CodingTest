package inflearn;

public class infRecursion {
    public static void main(String[] args) {
        /*
        재귀함수 : 자신을 정의할 때 자기 자신을 재참조하는 함수
        ex)
            public int factorial(int x) {
                if (x == 1) {
                    return 1;
                } else {
                    return x * factorial(x - 1);
                }
            }

         재귀함수의 구성 요소
            1) 점화식 (Factorial, 피보나치 수열 등..)
            2) Base Case
                ㄴ BaseCase(조건문)가 없을 경우 무한히 호출됨
                ㄴ 모든 입력이 최종적으로 BaseCase를 이용해서 문제를 해결할 수 있어야됨.

         재귀함수의 전체 시간복잡도 = 재귀함수 호출 수 * 재귀함수 하나당 시간복잡도

         O(n) => f(n) = f(n-1) + n
         O(2^n) f(n) = f(n-1) + f(n-2)
         O(log2n) => Binary Search
         */

    }

}
