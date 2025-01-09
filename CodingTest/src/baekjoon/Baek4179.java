package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek4179 {
    static char graph [][];
    static boolean visited[][];

    static int row;
    static int col;

    static int len;

    static Queue<int []> fQue;
    static Queue<int []> pQue;

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        graph = new char[row][col];

        fQue = new LinkedList<>();
        pQue = new LinkedList<>();

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            for(int j = 0; j < col; j++){
                char k = tmp.charAt(j);
                graph[i][j] = k;
                if(k == 'F'){
                    fQue.offer(new int[] {i, j, 0});
                }else if(k == 'J'){
                    pQue.offer(new int[] {i, j, 0});
                }
            }
        }

        len = 0;

        bfs();

        if(len == 0){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(len);
        }
    }

    public static void bfs(){

        while(!pQue.isEmpty()){
            int size = fQue.size();
            for(int i = 0; i < size; i++){
                if (fQue.isEmpty()) continue;
                int poll [] = fQue.poll();
                if (poll == null) continue;
                int cur_x = poll[0];
                int cur_y = poll[1];

                for(int j = 0; j < dx.length; j++){
                    int next_x = cur_x + dx[j];
                    int next_y = cur_y + dy[j];

                    if((next_x >= 0 && next_x < row) && (next_y >= 0 && next_y < col)){
                        if(graph[next_x][next_y] == '.'){
                            graph[next_x][next_y] = 'F';
                            fQue.offer(new int[] {next_x, next_y, 0});
                        }
                    }
                }
            }

            size = pQue.size();
            for(int i = 0; i < size; i++){
                if (pQue.isEmpty()) continue;
                int poll [] = pQue.poll();
                if (poll == null) continue;
                int cur_x = poll[0];
                int cur_y = poll[1];
                int cur_l = poll[2];

                if(cur_x == row-1 || cur_y == col-1 || cur_x == 0 || cur_y == 0){
                    len = cur_l + 1;
                    return;
                }

                for(int j = 0; j < dx.length; j++){
                    int next_x = cur_x + dx[j];
                    int next_y = cur_y + dy[j];

                    if((next_x >= 0 && next_x < row) && (next_y >= 0 && next_y < col)){
                        if(graph[next_x][next_y] == '.'){
                            graph[next_x][next_y] = 'J';
                            pQue.offer(new int[] {next_x, next_y, cur_l + 1});
                        }
                    }else{
                        len = cur_l + 1;
                    }
                }

            }
        }
    }
}
