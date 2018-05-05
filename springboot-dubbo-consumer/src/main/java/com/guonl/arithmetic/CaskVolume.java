package com.guonl.arithmetic;

/**
 * Created by guonl
 * Date 2018/5/3 下午11:52
 * Description: 给定一个int数组，每一个数组元素代表一个木块的高度，每个木块紧密连接，假设木块之间的凹槽能蓄水，求需水量
 */
public class CaskVolume {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 1, 2, 1, 7, 7, 6};// 定义一个牧木桶的数组
        int left = 0;//左边开始第一位
        int right = arr.length - 1;// 右边第一位
        int max_l = arr[left];
        int max_r = arr[right];

        int volume = 0;//总容积

        while (left < right) {
            if (max_l < max_r) {
                left = left + 1;
                if (arr[left] > max_l) {
                    max_l = arr[left];
                } else {
                    volume = volume + max_l - arr[left];
                }
            } else {
                right = right - 1;
                if (arr[right] > max_r) {
                    max_r = arr[right];
                } else {
                    volume = volume + max_r - arr[right];
                }
            }

        }
        System.out.println("木桶的容量为：" + volume);

    }
}
