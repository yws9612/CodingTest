package inflearn;

public class infTraversal3 {
    public static void main(String[] args) {
        /*
        infTraversal 파일에서 BFS, DFS 기본형 작성
        해당 클래스 파일에서는 DFS에 3가지 방법(전위순회, 중위순회, 후위순회)에 대해 작성
        접근 != 방문
        */
    }

    //전위순회, print를 통해 방문, 자식 노드에 접근하기 전에 방문 노드 출력
    public void preOrder(infNode node){
        if(node == null){
            return;
        }else{
            System.out.println(node.value);
            preOrder(node.lc);
            preOrder(node.rc);
        }
    }

    //중위순회, 자식 노드(lc) 먼저 방문 후 자신 방문 그 후 나머지 자식 노드(rc) 방문
    public void inOrder(infNode node){
        if(node == null){
            return;
        }else{
            inOrder(node.lc);
            System.out.println(node.value);
            inOrder(node.rc);
        }
    }

    //후위순회, 모든 자식 노드 방문 후 자기 자신 방문
    public void postOrder(infNode node){
        if(node == null){
            return;
        }else{
            postOrder(node.lc);
            postOrder(node.rc);
            System.out.println(node.value);
        }
    }

}
