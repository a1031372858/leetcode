package org.example;

import java.util.HashMap;
import java.util.Map;

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


}
