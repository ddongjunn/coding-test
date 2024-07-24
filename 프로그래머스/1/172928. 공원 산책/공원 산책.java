import java.util.Arrays;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int row = park.length;
        int col = park[0].length();
        int[] currentPosition = new int[2];
        char[][] map = new char[row][col];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = park[i].charAt(j);

                if(map[i][j] == 'S') {
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                }
            }
        }

        for(int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            String direction = route[0];
            int distance = Integer.parseInt(route[1]);

            int x = currentPosition[0];
            int y = currentPosition[1];

            for(int j = 0; j < distance; j++) {

                if("E".equals(direction)) {
                    y++;
                } else if("W".equals(direction)) {
                    y--;
                } else if("S".equals(direction)) {
                    x++;
                } else if("N".equals(direction)) {
                    x--;
                }
    
                if(x < 0 || y < 0 || x >= row || y >= col) {
                    break;
                }
                
                if(map[x][y] == 'X') {
                    break;
                }
                
                if(j == distance - 1) {
                    currentPosition[0] = x;
                    currentPosition[1] = y;
                }
            }
        }
        
        return currentPosition;
    }
}