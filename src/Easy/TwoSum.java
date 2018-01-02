package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题描述：
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 对题的理解: 让你从给定的数组中找到两个元素的和为指定值的两个索引.
 */


public class TwoSum {

    public static int[] nums= {2,7,11,15};

    private static int target = 9;

    public static void main(String[] args){

        if (getResultSimple()!=null) {
            System.out.println(getResultSimple()[0]+","+getResultSimple()[1]);
        }

        if (getResultByHashMap()!=null) {
            System.out.println(getResultByHashMap()[0]+","+getResultByHashMap()[1]);
        }

    }

    /**
     * 通过简单的两重for循环来找到这样的下标
     * 时间复杂度为O(n^2)
     * @return
     */
    private static int[] getResultSimple(){

        for (int i = 0; i < nums.length; i++) {

            for (int i1 = 0; i1 < nums.length; i1++) {

                if (nums[i]+nums[i1]==target){
                    return new int[]{i,i1};
                }

            }

        }
        return null;

    }

    /**
     * 通过Map的方式，target-数组在当前索引下取到的值作为key,当前的下标作为value,遍历数组,每次都先判断当前的数组值
     * 是否已经存在于map当中，如果已经存在，则返回该数组值对应的索引和当前的索引作为最终结果；如果不存在，则将
     * target-数组在当前索引下取到的值，与其索引，插入到map当中
     * 时间复杂度为:O(n)
     * @return
     */
    private static int[] getResultByHashMap(){

        Map<Integer,Integer> map = new HashMap<>();

        int len = nums.length;

        for (int i = 0; i < len; i++) {

            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }else {
                map.put(target - nums[i],i);
            }

        }

        return null;
    }

}
