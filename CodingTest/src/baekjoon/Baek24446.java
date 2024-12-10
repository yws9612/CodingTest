package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek24446 {
    static int M;
    static int N;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean visited [];
    static int result [];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[M+1];
        result = new int[M+1];

        for(int i = 0; i <= M; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i = 1; i <= M; i++){
            Collections.sort(graph.get(i));
        }

        bfs(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < result.length; i++){
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        int cnt = 0;

        for(int i = 1; i <= M; i++){
            result[i] = -1;
        }

        while(!q.isEmpty()){
            for(int j = q.size(); j > 0; j--){//큐에 추가된 후 반복적으로 실행함으로써 cnt값을 증가시켜주는 역할
                int poll = q.poll();
                result[poll] = cnt;

                for(int val : graph.get(poll)){
                    if(!visited[val]){
                        visited[val] = true;
                        q.offer(val);
                    }
                }
            }
            cnt++;
        }
    }
}
