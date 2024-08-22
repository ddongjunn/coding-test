class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            int skillIndex = 0;
            boolean flag = true;

            for (int i = 0; i < skillTree.length(); i++) {
                char curr = skillTree.charAt(i);
                int idx = skill.indexOf(curr);

                if(idx == -1) {
                    continue;
                }

                if(skillIndex == idx) {
                    skillIndex++;
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
            }
        }

        return answer;
    }
}