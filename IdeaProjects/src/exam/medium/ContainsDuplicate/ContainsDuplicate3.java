package medium.ContainsDuplicate;

/**
 * @author YangShuo
 * @create 2019/1/9
 * @comment
 */

/**
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array such
 * that the absolute difference between nums[i] and nums[j] is
 * at most t and the absolute difference between i and j is at most k.
 *
 * |num[i]-num[j]| <t  and  |i-j|<k
 *
 * 维护一个大小为k的窗口，k窗口内出现有两个数差小于t
 */
public class ContainsDuplicate3 {
    public  static void main(String[] args){
        int[] a={1,2,3,4,5,6,7};
        boolean i=containsNearbyAlmostDuplicate(a,5,4);
        System.out.print("结果是"+i);
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(nums.length<2 || k<0  || t<0){
            return false;
        }
        int max=k;

        while(max<nums.length){
            int i=max-k;

            int lastmin=nums[i];
            int min=nums[i];

            while(i<=max){//todo:取出k窗口内的两个最小值
                if(nums[i]<=min){
                    lastmin=min;
                    min=nums[i];
                }
                i++;

            }

            if(Math.abs(min-lastmin)<t){
                return true;
            }
            max++;
        }

        if(max>=nums.length){
            max=nums.length-1;
            int i=0;
            int lastmin=nums[i];
            int min=nums[i];

            while(i<=max){//todo:取出k窗口内的两个最小值
                if(nums[i]<=min){
                    lastmin=min;
                    min=nums[i];
                }

            }
            if(Math.abs(min-lastmin)<t){
                return true;
            }
        }
        return false;
    }
}
