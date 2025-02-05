package org.example;

import java.util.*;

/**
 * @author xuyachang
 * @date 2024/10/12
 */
public class LeetCode {


    /**
     * 使用hash表将时间复杂度降低。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0;i<nums.length;i++){
            int key = target-nums[i];
            if(map.containsKey(key)){
                return new int[]{i,map.get(key)};
            }
            map.put(nums[i],i);
        }
        return null;
    }


    /**
     * 要考虑负数，反转数字超过int最大值。
     */
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            if(chars[i]!=chars[chars.length-1-i]){
                return false;
            }
        }
        return true;
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,target);
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
     * 69. x 的平方根
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left =0,right=x;
        int index = 0;
        while(left<=right){
            index = (right+left)/2;
            long cur = (long)index*index;
            if(cur==x){
                return index;
            }else if(cur > x){
                right = index-1;
            }else{
                left = index+1;
            }
        }
        return right;
    }

    /**
     * 2089. 找出数组排序后的目标下标
     * @param nums
     * @param target
     * @return
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        int targetIndex = (left+right)/2;
        while(left<=right){
            int index = (left+right)/2;
            if(nums[index]==target){
                targetIndex = index;
                break;
            }else if(nums[index] > target){
                right=index-1;
            }else{
                left=index+1;
            }
            if(left>right){
                return result;
            }
        }
        int minIndex =targetIndex,maxIndex=targetIndex;
        for (; minIndex >=0 ; minIndex--) {
            if(nums[minIndex] < target){
                break;
            }
        }
        minIndex++;
        for (; maxIndex < nums.length ; maxIndex++) {
            if(nums[maxIndex] > target){
                break;
            }
        }
        maxIndex--;
        for (int i = minIndex; i <= maxIndex ; i++) {
            result.add(i);
        }
        return result;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 222. 完全二叉树的节点个数
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            return countNodes(root.left) + countNodes(root.right) +1;
        }
    }

    /**
     * 268. 丢失的数字
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        while (left<=right){
            int index = (left+right)/2;
            if(nums[index] <= index){
                left = index+1;
            }else{
                right = index-1;
            }
        }
        return left;
    }

    /**
     * 268. 丢失的数字2
     * 数学解法，最快
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int total = n*(n+1)/2;
        for (int i = 0; i < n; i++) {
            total-=nums[i];
        }
        return total;
    }

    /**
     * 278. 第一个错误的版本
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left =1,right=n;
        while(left<right){
            int index = left+(right-left)/2;
            if(isBadVersion(index)){
                right = index;
            }else{
                left = index+1;
            }
        }
        return left;
    }
    boolean isBadVersion(long version){
        return version>=1702766720;
    }

    /**
     * 349. 两个数组的交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> list = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i:nums1){
            set.add(i);
        }
        for (int i:nums2){
            if(set.contains(i)){
                list.add(i);
            }
        }
        int[] r = new int[list.size()];
        int i=0;
        for (Integer item : list) {
            r[i] = item;
            i++;
        }
        return r;
    }

    /**
     * 350. 两个数组的交集 II
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] list1 = new int[1001];
        int[] list2 = new int[1001];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list1[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            list2[nums2[i]]++;
        }
        for (int i = 0; i < 1001; i++) {
            if(list1[i]!=0&&list2[i]!=0){
                int sum = 0;
                if(list1[i]>list2[i]){
                    sum=list2[i];
                }else{
                    sum=list1[i];
                }
                for (int j = 0; j < sum; j++) {
                    result.add(i);
                }
            }
        }

        int[] r = new int[result.size()];
        int i=0;
        for (Integer item : result) {
            r[i] = item;
            i++;
        }
        return r;
    }

    /**
     * 367. 有效的完全平方数
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int left=0,right=num;
        while (left<=right){
            int index = (right-left)/2 + left;
            long cur = (long) index *index;
            if(cur==num){
                return true;
            }else if(cur>num){
                right = index -1;
            }else{
                left = index +1;
            }
        }
        return false;
    }

    /**
     * 374. 猜数字大小
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int l=0,r=n;
        while (l<=r){
            int index = (r-l)/2 +l;
            int value = guess(index);
            if(value==0){
                return index;
            }else if(value>0){
                l = index+1;
            }else{
                r = index-1;
            }
        }
        return 0;
    }
    int guess(int num){
        int r = 3;
        if(num==r){
            return 0;
        }else if(num>r){
            return 1;
        }else {
            return -1;
        }
    }

    /**
     * 441. 排列硬币
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        int left=1,right=n;
        while (left<=right){
            int index = (right-left)/2 + left;
            long cur = (long) index *(index+1)/2;
            if(cur==n){
                return index;
            }else if(cur > n){
                right = index -1;
            }else{
                left = index +1;
            }
        }
        return right;
    }

    /**
     * 二分查找法
     * 和数组中间的数字比，
     * 比中间的大，则起点改为中间点+1，
     * 比中间小，则终点改为中间点-1，
     * 相等时返回相等值的下标
     * 最后数组会慢慢缩小至2个数时，下一次会变成1个数，1个数时，下一次会数组越界
     * 起点越界说明这个数比最后的数字大，结果为最后的数+1;
     * 终点越界说明这个数比最后的数字小,结果为最后的数
     * 这两种情况，刚好都和left相同，所以直接返回left
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int left =0,right=nums.length-1;
        int index = 0;
        while(left<=right){
            index = (right+left)/2;
            int cur = nums[index];
            if(target==cur){
                return index;
            }else if(target > cur){
                left = index+1;
            }else{
                right = index-1;
            }
        }
        return left;
    }

}
