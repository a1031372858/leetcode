package org.example;

import org.junit.Test;

public class DynamicProgramTest {

    private final DynamicProgram dynamicProgram = new DynamicProgram();

    @Test
    public void climbStairs(){
        int result = dynamicProgram.climbStairs(5);
    }

    @Test
    public void fib(){
        int result = dynamicProgram.fib(4);
    }

    @Test
    public void tribonacci(){
        int result = dynamicProgram.tribonacci(4);
    }

    @Test
    public void minCostClimbingStairs(){
        int[] arr = new int[]{1,100,1,1,1,100,1,1,100,1};
        int result = dynamicProgram.minCostClimbingStairs(arr);
        System.out.println(result);
    }

    @Test
    public void rob(){
        int[] arr = new int[]{0};
        int result = dynamicProgram.rob(arr);
        System.out.println(result);
    }

    @Test
    public void deleteAndEarn(){
        int[] arr = new int[]{2,2,3,3,3,4};
        int result = dynamicProgram.deleteAndEarn(arr);
        System.out.println(result);
    }
    @Test
    public void uniquePaths(){
        int result = dynamicProgram.uniquePaths(3,7);
        System.out.println(result);
    }
//    @Test
//    public void uniquePaths2(){
//        int result = dynamicProgram.uniquePaths2(3,7);
//        System.out.println(result);
//    }

    @Test
    public void minPathSum(){
        int[][] arr = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int result = dynamicProgram.minPathSum(arr);
        System.out.println(result);
    }
}
