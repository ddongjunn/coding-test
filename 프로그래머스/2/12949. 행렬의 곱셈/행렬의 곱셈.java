class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] res = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = getValue(arr1, arr2, i, j);
            }
        }
        return res;
    }

    public int getValue(int[][] arr1, int[][] arr2, int i, int j) {
        int res = 0;
        for (int k = 0; k < arr1[0].length; k++) {
            res += arr1[i][k] * arr2[k][j];
        }
        return res;
    }
}