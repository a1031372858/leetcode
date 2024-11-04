package org.example;

import java.util.function.BinaryOperator;

/**
 * @author xuyachang
 * @date 2024/10/12
 */
public class LeetCode {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int index = nums.length/2;

        while (true){
            if(nums[index] == target){
                return index;
            }else if(nums[index] > target){
                if(start == end || index == start){
                    return index;
                }
                end = index - 1;
                index = (end - start)/2 + start;
            }else{
                if(start == end || index == end){
                    return index+1;
                }
                start = index + 1;
                index = (end - start)/2 + start;
            }
        }
    }

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split[split.length-1].length();
    }

    public int[] plusOne(int[] digits) {
        int [] result = new int[digits.length+1];
        for (int i = digits.length-1; i >=0; i--) {
            if(digits[i]<9){
                digits[i] = digits[i]+1;
                return digits;
            }else{
                digits[i]=0;
                result[i]=0;
            }
        }
        result[0] = 1;
        return result;
    }

    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i=a.length()-1,j=b.length()-1;
        int ca =0;
        for (; i >=0 || j>=0; i--,j--) {
            int sum = ca;
            int x = i>=0 ? a.charAt(i)-'0' : 0;
            int y = j>=0 ? b.charAt(j)-'0' : 0;
            sum = sum + x + y;
            ca = sum/2;
            ans.append(sum%2);
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        String[] strs = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        while (columnNumber>0){
            int curValue = columnNumber%27;
            columnNumber = columnNumber/27;
            ans.append(strs[curValue]);
        }

        return ans.reverse().toString();
    }

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
