// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

 

// Example 1:

// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1

// Example 2:

// Input: coins = [2], amount = 3
// Output: -1

// Example 3:

// Input: coins = [1], amount = 0
// Output: 0

class Solution {
    private int [] coins;
    private int INF;

    public int coinChange(int[] coins, int amount){
        this.coins = coins;
         this.INF = amount +1;
         int ans = dfs(amount);
         return ans == INF ? -1: ans;
    }
    private int dfs(int rem){
        if(rem == 0) return 0;
        int best = INF ;
        
        for(int coin : coins){
            if(coin <= rem){
                int sub = dfs(rem - coin);
                if(sub != INF){
                    best = Math.min(best , sub+1);
                }
            }
        }
        return best;
    }

        
    }

