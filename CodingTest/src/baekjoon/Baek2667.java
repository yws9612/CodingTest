package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2667 {

    static int n;
    static int row;
    static int col;

    static int result;

    static int graph [][];
    static boolean visited [][];
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> ary = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());

        row = n;
        col = n;
        graph = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for(int j = 0; j < n; j++){
                graph[i][j] = tmp.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j ++){
                if(!visited[i][j] && graph[i][j] == 1){
                    result++;
                    ary.add(bfs(i, j));
                }
            }
        }

        System.out.println(result);
        Collections.sort(ary);
        for(int size : ary){
            System.out.println(size);
        }
    }

    public static int bfs (int x, int y){
        Queue<int []> q = new LinkedList<>();
        visited[x][y] = true;

        int path = 1;

        q.offer(new int[] {x, y});


        while(!q.isEmpty()){
            int poll [] = q.poll();
            int cur_x = poll[0];
            int cur_y = poll[1];

            for(int i = 0; i < dx.length; i++){
                int next_x = cur_x + dx[i];
                int next_y = cur_y + dy[i];

                if((next_x >= 0 && next_x < row) && (next_y >= 0 && next_y < col)){
                    if(!visited[next_x][next_y] && graph[next_x][next_y] == 1){
                        q.offer(new int[] {next_x, next_y});
                        visited[next_x][next_y] = true;
                        path++;
                    }
                }
            }
        }
        return path;
    }
}
