import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int answer, solutionCnt, timeLimit;
    public static int[] scores, times;

    public static int dfs(int level, int scoreSum, int timeSum){
        if(timeSum > timeLimit){
            return 0;
        }

        if(level == solutionCnt){
            return scoreSum;
        }

        int maxScore = dfs(level + 1, scoreSum, timeSum);
        maxScore = Math.max(maxScore, dfs(level + 1, scoreSum + scores[level], timeSum + times[level]));

        return maxScore;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        solutionCnt = Integer.parseInt(st.nextToken());
        timeLimit = Integer.parseInt(st.nextToken());

        scores = new int[solutionCnt];
        times = new int[solutionCnt];
        for(int i=0; i<solutionCnt; i++){
            st = new StringTokenizer(br.readLine());
            scores[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
        }

        int answer = dfs(0,0,0);
        System.out.println(answer);
    }
}
