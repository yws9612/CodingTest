package inflearn;

public class infList {
    public static void main(String[] args) {
        /*
          List와 Set의 차이
            Set : 순서와 상관 없음([1,2,3], [2,1,3], [3,1,2]는 모두 같은 취급)
            List : 순서와 상관 있음([1,2,3], [2,1,3], [3,1,2]는 모두 다른 취급)

          List 자료 저장 방법 : ArrayList, LinkedList
            ArrayList : 배열을 기반으로 list 생성
                ㄴ Array, Dynamic array로도 구현이 가능하지만, c언어 영역이기에 무시해도 무관
                ㄴ 배열은 연속성이 있기 때문에 한번의 연산만 진행하여 요소를 찾을 수 있어 O(1)의 시간 복잡도를 갖음
            LinkedList : 비 연속적으로 저장되어있는 노드들을 연결하여 list 생성
                ㄴ 랜덤 액세스가 불가능 하기 때문에 n번째 데이터에 접근하기 위해서 n번의 연산을 해야되기 때문에 O(n)의 시간 복잡도를 갖음
        */
    }
}
