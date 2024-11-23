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

    /**
     * 动态规划解题流程
     * 从最后一步找出状态转移方程
     * 找到起始值
     * 建立状态转移数组
     * 求解
     * dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
     * 使用滚动数组的思想，可以将空间复杂度缩减到O(1)，因为第i个值只与i-1和i-2的值有关，其他值不需记录
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i <= n;i++){
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);

        }
        return dp[n];
    }


    /**
     * 打家劫舍
     * fn = max(f(n-2)+nums[n], f(n-1))
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n+2];
        dp[0]=nums[0];
        if(n==1)return dp[n-1];
        dp[1]=Math.max(dp[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }

    /**
     * 内存简化版
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int n=nums.length;
        int p = nums[0];
        if(n==1)return p;
        int q = Math.max(p,nums[1]);
        int r =q;
        for (int i = 2; i < n; i++) {
            r =  Math.max(q,p+nums[i]);
            p = q;
            q = r;
        }
        return r;
    }

    /**
     * 740. 删除并获得点数
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = Math.max(n,num);
        }
        int[] arr = new int[n+1];
        for (int num : nums) {
            arr[num] += num;
        }
        return rob2(arr);
    }

    /**
     * 62. 不同路径
     * arr[i][j] = arr[i-1][j]+arr[i][j-1]
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i==0 || j==0){
                    arr[i][j]=1;
                }else{
                    arr[i][j] = arr[i-1][j]+arr[i][j-1];
                }
            }
        }
        return arr[n-1][m-1];
    }

//    /**
//     * 内存简化版
//     * @param m
//     * @param n
//     * @return
//     */
//    public int uniquePaths2(int m, int n) {
//        int p =1,q=1;
//        int r =0;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if(i==0 || j==0){
//                    r=1;
//                }else{
//                    r =p+q;
//                }
//                p=q;
//                q=r;
//            }
//        }
//        return r;
//    }

    public int minPathSum(int[][] grid) {
        int n = grid.length,m=grid[0].length;
        int[][] arr = new int[n][m];
        arr[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            arr[i][0] = arr[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            arr[0][j] = arr[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                arr[i][j] = Math.min(arr[i-1][j],arr[i][j-1])+grid[i][j];
            }
        }
        return arr[n-1][m-1];
    }
}
