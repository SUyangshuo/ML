package medium.temp;

import java.util.Arrays;

/**
 * @author YangShuo
 * @create 2019/2/21
 * @comment
 */

/*
34. Find First and Last Position of Element in Sorted Array
 */
    //查找某个元素在数组中，第一次和最后一次出现的位置
    //数组是一个有序的
public class SearchforaRange {
    //直接使用二分查找
    //找到相应元素后就向左右遍历


        public int[] searchRange(int[] nums, int target){
            //Method 2
            int[] res = {-1, -1};
            if (nums == null || nums.length == 0) {
                return res;
            }
            //find left bound
            int ll = 0;
            int lr = nums.length - 1;
            while (ll <= lr) {
                int mid = ll + (lr - ll) / 2;
                if (nums[mid] < target) {
                    ll = mid + 1;
                } else {
                    lr = mid - 1;
                }
            }
            //find right bound
            int rl = 0;
            int rr = nums.length - 1;
            while (rl <= rr) {
                int mid = rl + (rr - rl) / 2;
                if (nums[mid] <= target) {
                    rl = mid + 1;
                } else {
                    rr = mid - 1;
                }
            }
            //check if target is found
            if (ll > rr) {
                return res;
            }
            res[0] = ll;
            res[1] = rr;
            return res;

    }
}
