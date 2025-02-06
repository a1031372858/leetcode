package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LeetCodeTest {

    private final LeetCode leetCode = new LeetCode();
    @Test
    public void twoSumTest(){
        int target = 9;
        int[] arr = new int[]{2,7,11,15};
        int[] ints = leetCode.twoSum(arr, 9);
        Assert.assertEquals(arr[ints[0]] + ints[1], target);
    }

    @Test
    public void isPalindrome(){
        int x = 1234567899;
        boolean palindrome = leetCode.isPalindrome(x);
        System.out.println(palindrome);
    }

    @Test
    public void searchInsert() {
        int[] arr = new int[]{1,3,5,6};
        int result = leetCode.searchInsert(arr, 2);
        System.out.println(result);
    }
    @Test
    public void mySqrt() {
        int result = leetCode.mySqrt(10);
        System.out.println(result);
    }

    @Test
    public void targetIndices() {
        int[] arr = new int[]{1,2,5,2,3};
        List<Integer> integers = leetCode.targetIndices(arr, 5);
    }


    @Test
    public void firstBadVersion() {
        int badVersion = leetCode.firstBadVersion(2126753390);
        System.out.println(badVersion);
    }

    @Test
    public void isPerfectSquare() {
        boolean perfectSquare = leetCode.isPerfectSquare(2147483647);
        System.out.println(perfectSquare);
    }

    @Test
    public void getCommon() {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{5,6};
        int common = leetCode.getCommon(arr1, arr2);
        System.out.println(common);
    }

    @Test
    public void isValid() {
        boolean valid = leetCode.isValid("{{}}}");
        System.out.println(valid);
    }
}
