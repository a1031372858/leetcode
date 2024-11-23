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
}
