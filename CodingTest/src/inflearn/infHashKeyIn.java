package inflearn;

import java.util.Hashtable;
import java.util.Iterator;

public class infHashKeyIn {
    public static void main(String[] args) {
        /*
        정렬되어 있지 않은 정수형 배열 nums가 주어졌을 때, nums 원소를 가지고 만들 수 있는 가장 긴 연속된 수의
        갯수는 몇개인지 반환하시오
         */
        Hashtable<Integer, Integer> hash = new Hashtable<>();

        int longest = 0;

        //hash 키 값에 값을 넣어줌, 키 값은 중복을 허용하지 않기 때문에 4 5 6 7 100이 HashTable에 들어감
        hash.put(6, 1);
        hash.put(7, 1);
        hash.put(100, 1);
        hash.put(5, 1);
        hash.put(4, 1);
        hash.put(4, 1);

        for(int key : hash.keySet()){
            int kVal = key - 1;
            if(!hash.containsKey(kVal)){//key 값의 연속된 이전 수가 없으면
                int count = 1; //본인포함 연속된 수 1
                int target = key + 1; //target은 키 값에 연속된 수로 설정
                while(hash.containsKey(target)){ //만약 target값이 테이블에 있을 경우
                    target += 1;    //다음 target값 설정
                    count += 1;     //연속된 수 + 1
                }
                longest = Math.max(longest, count);//총 갯수 비교
            }
        }
        System.out.println(longest);
    }
}
