/**
 * created by Vincent on 2018/1/2
 *
 * Description:
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * 题目要求：数组中可能包含多个val，删除这个数组中所有的val。
 **/
public class RemoveElement {

    public static void main(String[] args){

        RemoveElement removeElement = new RemoveElement();

        int []nums = new int[]{1,1,1,2,5,6};

        int realLen = removeElement.removeElement(nums,1);

        for (int i = 0; i < realLen; i++) {

            System.out.println(nums[i]);
        }

    }


    /**
     * 将一个数组中的所有的val删除
     * 空间复杂度为 O(1)
     * @param nums
     * @param val
     * @return
     */
    private int removeElement(int[] nums,int val){

        int len = nums.length;

        int tail = 0;

        if (len <= 1) return len;

        for (int i = 0; i <len; i++) {

            if (nums[i] != val){
                nums[tail++] = nums[i];
            }

        }
        return tail;

    }

}
