class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int attackIdx = 0;
        int hp = health;
        int castingTime = 0;

        int t = 1;
        while(t <= attacks[attacks.length - 1][0]) {
        
            if(attacks[attackIdx][0] == t) {
                hp -= attacks[attackIdx][1];
                castingTime = 0;
                attackIdx++;
            } else {
                hp += applyRecovery(hp, bandage[1], health);
                castingTime++;

                if(castingTime == bandage[0]) {
                    hp += applyRecovery(hp, bandage[2], health);
                    castingTime = 0;
                }
            }

            if(isDead(hp)) {
                return -1;
            }
            
            t++;
        }
        
        return hp;
    }

    public static int applyRecovery(int hp, int recoveryAmount, int health){
        hp += recoveryAmount;    
        if(hp < health) {
            return recoveryAmount;
        } else if (hp >= health) {
            hp -= recoveryAmount;
            return health - hp;
        }
        return 0;
    }

    public static boolean isDead(int hp) {
        return hp <= 0;
    }
}