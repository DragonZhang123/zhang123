package MyInterviewQuestions;

/**
 * Created by zhangguanlong on 2017/10/26.
 */

/**
 * 参加网易的笔试
 * 不好意思
 * 12道题就会三道
 */

import java.util.Scanner;

/**
 * 题目：一种双核CPU的两个核能够同时的处理任务，
 * 现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，
 * 每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，
 * 现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 * 输入包括两行：
 第一行为整数n(1 ≤ n ≤ 50)
 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。
 输出描述:
 输出一个整数，表示最少需要处理的时间
 输入例子1:
 5 3072 3072 7168 3072 1024
 输出例子1:
 9216
 */
public class TwoCoreCpu {
    /**
     * 思路：这道题可以理解为一个01背包问题，双核CPU并行处理任务就是把所有任务分成两组，
     * 使时间最少就是让两组任务中花费时间较少的那组任务花费时间尽可能的接近串行总时间的一半，
     * 即求一个小于总时间一半的最大时间。使用动态规划求最优解，
     * dp[i][j]表示前i个任务中总时间为j时可以进行任务的最大时间，dp[i][j] = max{dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]}。
     * 其中nums[i]表示第i个任务的时间；dp[i-1][j]表示前i-1个任务中总时间为j时进行任务的最大时间，
     * 即第i个任务不加入这一组；dp[i-1][j-nums[i]]表示前i-1个任务中总时间为j-nums[i]时进行任务的最大时间，
     * 避免加入nums[i]后超过总时间j。
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int n = sc.nextInt();
            int[] nums = new int[n];
            int sum = 0;
            for(int i=0;i<n;i++){
                nums[i] = sc.nextInt()/1024;
                sum += nums[i];
            }
            int[] dp = new int[sum/2+1];
            for(int i=0;i<n;i++){
                for(int j=sum/2;j>=nums[i];j--){
                    dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
                }
            }
            System.out.println((sum-dp[sum/2]) * 1024);
        }
    }

}
