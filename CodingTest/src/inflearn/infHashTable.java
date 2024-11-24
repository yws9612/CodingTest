package inflearn;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class infHashTable {
    public static void main(String[] args) {
        /*
        HashTable 구현 방법
            1) ArrayList(Python 딕셔너리에서는 ArrayList로 구현), Open Addressing
            2) ArrayList + LinkedList, Seperate chaining/

        HashTable의 저장, 삭제, 검색의 시간 복잡도는 모두 O(1)/해시 충돌이 날 경우 O(n)

        HashTable <-> Direct-address Table

        Direct-addressTable이란?
            ㄴ 키 값을 인덱스 번호로 갖는 테이블
            ㄴ 문자열로는 인덱스를 지정 불가하기 때문에 해쉬테이블 사용

        HashTable(파이썬 Dictionary)는 메모리를 사용하는거기 때문에 시간복잡도를 많이 줄여 줄 수 있음.
        */

        // HashTable 생성
        Hashtable<String, Integer> hashTable = new Hashtable<>();

        // Entry 객체 저장
        hashTable.put("부산", 1);
        hashTable.put("인천", 2);
        hashTable.put("대구", 3);
        hashTable.put("대전", 4);
        hashTable.put("광주", 5);
        hashTable.put("울산", 6);

        // 저장된 총 Entry 수 얻기
        int size = hashTable.size();
        System.out.println(size);

        // 객체 찾기
        Object object = hashTable.get("부산");
        System.out.println(object);

        // key를 요소로 가지는 Set 생성
        Set<String> keySet = hashTable.keySet();
        System.out.println(keySet);

        // value 값 읽기
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer value = hashTable.get(key);
            System.out.println("키 : " + key + " 값 : " + value);
        }

        // 객체 삭제 후 크기 출력
        hashTable.remove("부산");
        System.out.println(hashTable.size());

        // Entry 객체를 요소로 가지는 Set을 생성
        Set<Map.Entry<String, Integer>> entrySet = hashTable.entrySet();

        // entrySet을 순회하면서 value 값 읽기
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();

        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey(); // Map.Entry 인터페이스의 메서드
            Integer value = entry.getValue(); // Map.Entry 인터페이스의 메서드
            System.out.println("키 : " + key + " 값 : " + value);
        }

        // 전체 객체 삭제
        hashTable.clear();
    }
}
