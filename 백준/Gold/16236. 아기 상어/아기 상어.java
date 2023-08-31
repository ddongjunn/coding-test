import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    static int N, answer;
    static int[][] map;
    static boolean[][] isVisited;

    static ArrayList<Fish> eatFishs = new ArrayList<>();
    static Fish babyShark;	
	static int size = 2;
	static int eaten = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 9){
                    babyShark = new Fish(i, j, 0);
                    isVisited[i][j] = true;
                    map[i][j] = 0;
                }
            }
        }

        findFish();
        System.out.println(answer);
    }

    private static void findFish() {
        Queue<Fish> q = new LinkedList<>();
        q.add(babyShark);

        while(true){
            while(!q.isEmpty()){
                Fish fish = q.poll();

                for(int dir = 0; dir < 4; dir++){
                    int nx = fish.x + dx[dir];
                    int ny = fish.y + dy[dir];
                    int nextDist = fish.dist + 1;

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N || isVisited[nx][ny]){
                        continue;
                    }

                    if(map[nx][ny] < size && map[nx][ny] != 0){
                        isVisited[nx][ny] = true;
                        q.add(new Fish(nx, ny, nextDist));
                        eatFishs.add(new Fish(nx, ny, nextDist));
                    }

                    if(map[nx][ny] == size || map[nx][ny] == 0){
                        q.add(new Fish(nx, ny, nextDist));
                        isVisited[nx][ny] = true;
                    }

                }
            }

            if(!eatFishs.isEmpty()){
                sortedEatFishs();
                eat();
                q.clear();
                q.add(babyShark);
            }else{
                return;
            }
        }
    }

    private static void eat() {
        isVisited = new boolean[N][N];

        Fish fish = eatFishs.get(0);
        updateBabySharkPosition(fish);

        if (++eaten == size) {
            size++;
            eaten = 0;
        }

        answer += fish.dist;
        eatFishs.clear();
    }

    private static void updateBabySharkPosition(Fish fish) {
        babyShark.x = fish.x;
        babyShark.y = fish.y;
        isVisited[fish.x][fish.y] = true;
        map[fish.x][fish.y] = 0;
    }

    private static void sortedEatFishs(){
        eatFishs.sort(Comparator
                .comparingInt((Fish fish) -> fish.dist)
                .thenComparingInt(fish -> fish.x)
                .thenComparingInt(fish -> fish.y));
    }
}

class Fish{
    int x;
    int y;
    int dist;

    public Fish(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}