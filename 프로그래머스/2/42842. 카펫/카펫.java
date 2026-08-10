class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        for (int width = 3; width < total; width++) {
            if (total % width != 0) {
                continue;
            }
            
            int height = total / width;
            if (width < height) {
                continue;
            }
            
            if ((width - 2) * (height - 2) == yellow) {
                return new int[]{width, height};
            }
            
        }
        return new int[]{};
    }
}

/*
    직사각형 너비 구하기?
    최소 가로 = y + 2, 최소 세로 = y + 2
    
    전체 너비는 brown + yellow
    - 가로길이 완전 탐색
        - 최소 가로: 3 -> total까지
        - 직사각형 너비 조건이 안맞는 경우 continue
        
*/