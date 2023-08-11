class Solution {
    
    private final int MOD = 1234567;
    
    private long mod(long v1, long v2) {
        return ((v1 % MOD) + (v2 % MOD)) % MOD;
    }
    
    public int solution(int n) {
        long[] dp = new long[n+1];
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            dp[i] = mod(dp[i-1], dp[i-2]);
        }
        
        
        return (int)dp[n];
    }
    
}