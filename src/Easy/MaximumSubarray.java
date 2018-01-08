package Easy;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Vincent on 2018/1/2 22:11
 * <p>
 * Description:
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p>
 * 题目要求：找出一个数组的子数组，这个子数组的所有元素的和是这个数组所有子数组中和最大的。
 **/
public class MaximumSubarray {



    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,4};
        List<ArrayList<Integer>> arrays = getSubArrays(nums);//将数组的所有子集拿出来
        List<Integer> sums = new ArrayList<>();//用来存放数组以及数组中元素所对应的和

        for (ArrayList<Integer> array : arrays) {

            int sum = 0;
            for (Integer integer : array) {
                sum += integer;
            }
            sums.add(sum);

        }

        int maxIndex = 0;//用来存放最大的和所在的下标
        for (int i=1;i<sums.size();i++){

            if (sums.get(i)>=sums.get(maxIndex)){
                maxIndex = i ;
            }

        }

        //根据最大的下标，在arrays中找到对应的数组
        List<Integer> listMaxSum = arrays.get(maxIndex);

        //打印找到的结果，即和最大的子数组
        System.out.print("和最大的子数组为：[");
        for (Integer integer : listMaxSum) {
            System.out.print(integer+",");
        }
        System.out.print("]");



    }

    /**
     * 获取一个数组的全部子集
     * @param nums
     * @return
     */
    public static List getSubArrays(int[] nums){
        int count = (int)Math.pow(2,nums.length);
        List<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        for(int i=1;i<count;i++){
            List<Integer> subarray = new ArrayList<Integer>();
            int temp = i;
            int index = 0;
            while (temp!=0){
                if((temp&1)==1){
                    subarray.add(nums[index]);
                }
                index++;
                temp = temp >>1;
            }
            arrays.add((ArrayList<Integer>) subarray);
        }
        return arrays;
    }

    /**
     * 分治法的思想
     * 递归方式来实现的，它会找到最大的和，但是不会将对应的子集输出
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = (left + right) >> 1;
        int leftAns = helper(nums, left, mid);
        int rightAns = helper(nums, mid + 1, right);
        int leftMax = nums[mid], rightMax = nums[mid + 1];
        int temp = 0;
        for (int i = mid; i >= left; --i) {
            temp += nums[i];
            if (temp > leftMax) leftMax = temp;
        }
        temp = 0;
        for (int i = mid + 1; i <= right; ++i) {
            temp += nums[i];
            if (temp > rightMax) rightMax = temp;
        }
        return Math.max(Math.max(leftAns, rightAns), leftMax + rightMax);
    }


    /**
     * 同样只是用来求解最大的子集和
     * 动态规划的思想
     * 当部分序列和大于零的话就一直加下一个元素即可，并和当前最大值进行比较，
     * 如果出现部分序列小于零的情况，那肯定就是从当前元素算起。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length, dp = nums[0], max = dp;
        for (int i = 1; i < len; ++i) {
            dp = nums[i] + (dp > 0 ? dp : 0);
            if (dp > max) max = dp;
        }
        return max;
    }


}
