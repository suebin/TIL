class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 체크 여부 확인
        
        boolean[] check = new boolean[n];
        
        for (int i=0; i<n; i++) {
            
            // 체크 되어 있지 않는 경우 (false)
            
            if (!check[i]) {
                
                // dfs 함수 호출
                
                dfs(computers, i, check);
                answer ++;
            }
        }
        
        return answer;
    }
    
    // dfs 함수
    
    boolean[] dfs (int[][] computers, int i, boolean[] check) {
        
        // 체크하기
        
        check[i] = true;
        
        for (int j=0; j<computers.length; j++) {
            
            // 자기 자신이 아니고, 값이 1이고, 체크가 되지 않은 경우
            
            if (i != j && computers[i][j] == 1 && check[j] == false) {
                
                // dfs 함수 호출 
                
                check = dfs(computers, j, check); // ★
            }
        }
        return check;
    }
}