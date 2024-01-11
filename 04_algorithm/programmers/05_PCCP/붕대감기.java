class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int curHealth = health;
        int t = 0;
        int healingCnt = 0;
        int idx = 0;

        while (idx < attacks.length) {
            t++;

            if (attacks[idx][0] == t) {
                curHealth -= attacks[idx][1];
                if (curHealth <= 0) return -1;
                idx++;
                healingCnt = 0;
                continue;
            }

            healingCnt++;
            curHealth += bandage[1];
            if (healingCnt == bandage[0]) {
                curHealth += bandage[2];
                healingCnt = 0;
            }
            if (curHealth > health) curHealth = health;
        }

        return curHealth;
    }
}