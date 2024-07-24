class Solution {
    public String solution(String X, String Y) {
        int[] arrayX = new int[10];
        for(char x : X.toCharArray()) {
            arrayX[x - '0']++;
        }

        int[] arrayY = new int[10];
        for(char y : Y.toCharArray()) {
            arrayY[y - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < Math.min(arrayX[i], arrayY[i]); j++) {
                sb.append(i);
            }
        }

        if(sb.length() == 0) {
            return "-1";
        }

        if(sb.charAt(0) == '0')  {
            return "0";
        }

        return sb.toString();
    }
}