package com.yx.algorithm;

/**
 * 滑动窗口算法示例程序01
 *
 * <p>
 *
 * 连续元素最大和
 *
 * 给定数组，获取数组中n个连续元素，最大的和。
 *
 * Input: [-3, 3, 1, -3, 2, 4, 7], n=3
 * Output: 13
 *
 * <p/>
 *
 * @author yangxi
 * @version 1.0
 */
public class SlidingWindow01 {

    public static void main(String[] args) {
        int[] sourceArray = {-3, 3, 1, -3, 2, 4, 7};
        int n = 3;

        // 第一种暴力解法
        int result1 = maxSumSub_method01(sourceArray, n);
        System.out.println("result1:" + result1);

        // 第二种使用滑动窗口解法
        int result2 = maxSumSub_method02(sourceArray, n);
        System.out.println("result2:" + result2);

    }

    /**
     * 暴力穷举解法
     * @param sourceArray 源数组
     * @param n
     * @return
     */
    public static int maxSumSub_method01(int[] sourceArray, int n) {

        if(sourceArray == null) {
            return 0;
        }

        // 数组长度比n小的时候，直接计算数组所有元素值的和
        if(sourceArray.length <= n) {
            int sum = 0;
            for(int i = 0; i < sourceArray.length; i++) {
                sum += sourceArray[i];
            }
            return sum;
        }

        // 数组长度比n大的时候，穷举所有可能的子数组（由于要求是n个连续的元素，所以最大就是((原数组长度-n) + 1 )个子数组），然后分别计算完各个子数组的元素值的和，取最大的值
        int maxSumSub = 0;
        for(int i = 0; i < (sourceArray.length - n) + 1; i++) {

            int sumSub = 0;
            for(int j = i; j < n + i; j++) {
                sumSub += sourceArray[j];
            }

            maxSumSub = Math.max(sumSub, maxSumSub);
        }

        return maxSumSub;
    }

    /**
     * 滑动窗口解法
     * @param sourceArray 源数组
     * @param n
     * @return
     */
    public static int maxSumSub_method02(int[] sourceArray, int n) {

        if(sourceArray == null) {
            return 0;
        }

        // 数组长度比n小的时候，直接计算数组所有元素值的和
        if(sourceArray.length <= n) {
            int sum = 0;
            for(int i = 0; i < sourceArray.length; i++) {
                sum += sourceArray[i];
            }
            return sum;
        }

        // 定义两个指针
        int firstIndex = 0;
        int lastIndex = n - 1;

        int maxSumSub = 0;
        while (lastIndex < sourceArray.length) {
            int sumSub = 0;
            for(int i = firstIndex; i <= lastIndex; i++) {
                sumSub += sourceArray[i];
            }
            maxSumSub = Math.max(sumSub, maxSumSub);

            // 窗口向前滑动
            firstIndex++;
            lastIndex++;
        }
        return maxSumSub;
    }

}