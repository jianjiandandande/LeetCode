/**
 * Created by Vincent on 2017/11/26.
 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args){

        RemoveDuplicatesfromSortedArray rdfsa = new RemoveDuplicatesfromSortedArray();

        System.out.println(rdfsa.getRealLength(new int[]{1,2,3,3,4,5,5}));

    }

    /**
     *
     * 这里有个坑，一开始没注意到，想了半天没想清楚
     * i++,先使用，后++
     * ++i,先++，后使用
     * @param nums
     * @return
     */
    private int getRealLength(int[] nums){

        int len = nums.length;
        if (len <= 1) return len;
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            if (nums[i - 1] != nums[i]) {
                nums[tail++] = nums[i];
            }
        }
        for (int  a: nums) {
            System.out.println(a);
        }
        return tail;
    }
}
