import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static List<Pos> houseList, chickenList;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1){
                    houseList.add(new Pos(i, j));
                }

                if(map[i][j] == 2){
                    chickenList.add(new Pos(i, j));
                }
            }
        }
        
        isVisited = new boolean[chickenList.size()];        
        bfs(0, 0);
        System.out.println(answer);
    }

    private static void bfs(int depth, int start) {
        if(depth == M){
            int cityDist = 0;
            for(int i = 0; i < houseList.size(); i++){
                int houseDist = Integer.MAX_VALUE;
                for(int j = 0; j < chickenList.size(); j++){
                    if(isVisited[j]){
                        houseDist = Math.min(houseDist, getDistance(houseList.get(i), chickenList.get(j)));
                    }
                }
                cityDist += houseDist;
            }
            answer = Math.min(cityDist, answer);
            return;
        }

        for(int i = start; i < chickenList.size(); i++){
            isVisited[i] = true;
            bfs(depth + 1, i + 1);
            isVisited[i] = false;
        }
    }

    private static int getDistance(Pos pos1, Pos pos2) {
        return Math.abs(pos1.x - pos2.x) + Math.abs(pos1.y - pos2.y);
    }
}

class Pos{
    int x;
    int y;
    
    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}