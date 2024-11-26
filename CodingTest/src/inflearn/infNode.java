package inflearn;

public class infNode {
    /*
                A
               / \
              B   C
             / \   \
            D   E   F
                   / \
                  G   H
     와 같은 이진 트리가 있을 때 해당 Node 들이 같는 속성 값은 다음과 같다.
     Value, LC(Left Child), RC(Right Child)
     */
    private int value;
    private infNode lc, rc;

    public infNode(int value){
        this.value = value;
        this.lc = null;
        this.rc = null;
    }

}
