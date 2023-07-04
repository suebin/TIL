class Solution {
    static boolean[] visit;
    static int answer;

    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];;
        dfs(begin, target, words, 0);
        return answer;
    }

    static void dfs(String word, String target, String[] words, int cnt) {
        if (word.equals(target)) {
            answer = cnt;
        }

        for (int i = 0; i < words.length; i++) {
            if (visit[i]) {
                continue;
            }

            int alphabetCnt = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (word.charAt(j) != words[i].charAt(j)) {
                    alphabetCnt++;
                }
            }

            if (alphabetCnt == 1) {
                visit[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visit[i] = false;
            }
        }
    }
}