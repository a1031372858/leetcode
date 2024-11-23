package org.example;

public class DynamicProgram {
    /**
     * 爬楼梯
     * f(x)=f(x-1)+f(x-2)
     * 【滚动数组思想】:后一个数为前两个数之和
     * r=p+q
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int p=0,q=0,r=1;
        for (int i = 1; i <= n; ++i) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }

    /**
     * 斐波那契数列
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        int p=0,q=1,r=1;
        for (int i = 3; i <= n; i++) {
            p=q;
            q=r;
            r=p+q;
        }
        return r;
    }

    /**
     * 第 N 个泰波那契数
     * Tn+3 = Tn + Tn+1 + Tn+2
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 1;
        int o=0,p=1,q=1,r=2;
        for (int i = 4; i <= n; ++i) {
            o=p;
            p=q;
            q=r;
            r=o+p+q;
        }
        return r;
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
