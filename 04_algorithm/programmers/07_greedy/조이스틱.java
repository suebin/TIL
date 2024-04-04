class Solution {
    public int solution(String name) {
        int len = name.length();
        int answer = 0;
        int move = len - 1; // default : 오른쪽으로 쭉 가는 경우
        int idxA;

        for (int i = 0; i < len; i++) {
            answer += Math.min('Z' - name.charAt(i) + 1, name.charAt(i) - 'A');

            idxA = i + 1;
            while (idxA < len && name.charAt(idxA) == 'A') {
                idxA++;
            }

            move = Math.min(move, (i * 2) + len - idxA);
            move = Math.min(move, (len - idxA) * 2 + i);
        }

        return answer + move;
    }
}
