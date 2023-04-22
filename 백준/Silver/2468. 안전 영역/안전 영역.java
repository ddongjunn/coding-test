import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static final int[] DX = {1,-1,0,0};
    static final int[] DY = {0,0,1,-1};
	static List<Integer> limits = new ArrayList<>();
    static int n;
	static int maxCnt = Integer.MIN_VALUE;
    static int[][] area;
	static boolean[][] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());

        area = new int[n][n];
		visit = new boolean[n][n];
        for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
				int num = Integer.parseInt(st.nextToken());
				area[i][j] = num;

				if(!limits.contains(num)){
					limits.add(num);
				}
			}
        }

		for (int limit : limits) {
			visit = new boolean[n][n];

			int cnt = 0;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(area[i][j] >= limit && !visit[i][j]){
						bfs(i, j, limit);
						cnt++;
					}
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}
		System.out.println(maxCnt);
    }

	static void bfs(int i, int j, int limit){
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(i, j));
		visit[i][j] = true;

		while(!q.isEmpty()){
			Pos pos = q.poll();

			for(int dir=0; dir<4; dir++){
				int nx = pos.x + DX[dir];
				int ny = pos.y + DY[dir];
				if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
				if(!visit[nx][ny] && area[nx][ny] >= limit){
					visit[nx][ny] = true;
					q.add(new Pos(nx, ny));
				}
			}
		}
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
