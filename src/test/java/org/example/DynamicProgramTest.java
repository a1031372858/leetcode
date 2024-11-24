package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void uniquePathsWithObstacles(){
        int[][] arr = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
//        int[][] arr = new int[][]{{1,0}};
        int result = dynamicProgram.uniquePathsWithObstacles(arr);
        System.out.println(result);
    }

    @Test
    public void minimumTotal(){
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);
        List<Integer> d = new ArrayList<>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        int result = dynamicProgram.minimumTotal(arr);
        System.out.println(result);
    }
    @Test
    public void minFallingPathSum(){
        int[][] arr = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        int result = dynamicProgram.minFallingPathSum(arr);
        System.out.println(result);
    }

}
