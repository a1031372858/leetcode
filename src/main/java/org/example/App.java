package org.example;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        LeetCode leetCode = new LeetCode();
//        int index = leetCode.strStr("sadbutsad", "sad");
//        System.out.println(index);

//        int[] arr = new int[]{3,5,7,9,10};
//        int i = leetCode.searchInsert(arr, 8);
//        System.out.println(i);

//        int length = leetCode.lengthOfLastWord("   fly me   to   the moon  ");
//        System.out.println(length);

//        int[] arr = new int[]{9,8,7,6,5,4,3,2,1,0};
//        int[] ints = leetCode.plusOne(arr);

//        String s = leetCode.addBinary("11", "1");

//        String result = leetCode.convertToTitle(27);
//        System.out.println(result);

//        int i = leetCode.climbStairs(5);
//        System.out.println(i);

//        int fib = leetCode.fib(4);
//        System.out.println(fib);

        int[] arr = new int[]{1,100,1,1,1,100,1,1,100,1};
        int result = leetCode.minCostClimbingStairs(arr);
        System.out.println(result);
    }
}
