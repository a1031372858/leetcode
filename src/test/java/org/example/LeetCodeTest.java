package org.example;

import org.junit.Assert;
import org.junit.Test;

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

}
