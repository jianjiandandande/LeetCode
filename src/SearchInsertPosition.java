/**
 * Created by Vincent on 2018/1/2 9:46
 *
 * Description:
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * 题目要求：题意是让你从一个没有重复元素的已排序数组中找到插入位置的索引。如果找到了，就返回对应的索引；如果没找到，就返回当前索引所在的位置。
 **/
public class SearchInsertPosition {

    public static void main(String[] args){

        SearchInsertPosition sip = new SearchInsertPosition();

        System.out.println(sip.searchInsert(new int[]{1,3,5,6},5));

        System.out.println(sip.searchInsert2(new int[]{1,3,5,6},2));

    }

    /**
     * 方法一：依据索引来遍历数组
     * @param nums
     * @param target
     * @return
     */
    private int searchInsert(int []nums,int target){

        int tail = 0;
        int len = nums.length;

        for (int i = 0; i <len ; i++) {

            if(nums[i]==target){
                return tail;
            }else if(nums[i]!=target){
                tail++;
                if(nums[i]>target)
                    return i;
            }
        }
        return tail;
    }

    /**
     * 方法二：根据二分法来遍历数据，从而找到target的位置
     * @param nums
     * @param target
     * @return
     */
    private int searchInsert2(int[] nums, int target) {

        int left = 0, right = nums.length - 1, mid = (right + left) >> 1;//位运算，右移相当于除以2，左移相当于乘2
        while (left <= right) {
            if (target <= nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
            mid = (right + left) >> 1;
        }
        return left;
    }
}
