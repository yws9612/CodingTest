package inflearn;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class infHashTwosum {
    public static void main(String[] args) {
        /*
        infTwoPointer와 같은 문제
         */

        int target = 14;
//        int target = 4;

        boolean chk = false;

        Hashtable<Integer, Boolean> hash = new Hashtable<>();

//        hash.put(2, true);
//        hash.put(1, true);
//        hash.put(5, true);
//        hash.put(7, true);

        hash.put(4, true);
        hash.put(1, true);
        hash.put(9, true);
        hash.put(7, true);
        hash.put(5, true);
        hash.put(3, true);
        hash.put(16, true);

        //forEach문 사용 시
        for (int key : hash.keySet()) {
            int val = target - key;
            if (hash.containsKey(val) && val != key) {//set 대신 hash.containsKey를 사용하면 동일한 조건
                chk = true;
                break;
            }
        }

        //forEach문 및 Set 사용 시
        Set<Integer> set = hash.keySet();//HashTable의 키 값들만 Set에 대입
        for (int key : set) {
            int val = target - key;
            if (set.contains(val) && val != key) {//hash.contains => hash의 value이기 때문에 set.contains 사용
                chk = true;
                break;
            }
        }

        //while문 사용 및 Iterator 사용 시
        Iterator<Integer> itr = set.iterator();//hasNext를 사용하여 반복문 최대치를 설정하기 위해 사용
        while(itr.hasNext()){
            int key = itr.next(); //set객체를 사용하기 때문에 키 값만 존재함. value를 사용하기 위해서는 hash.get(i) 사용
            int val = target - key;
            if(set.contains(val) && val != key){
                chk = true;
                break;
            }
        }

        System.out.println(chk);
    }
}
