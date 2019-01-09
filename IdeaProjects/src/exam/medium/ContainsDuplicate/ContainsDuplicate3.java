package medium.ContainsDuplicate;

/**
 * @author YangShuo
 * @create 2019/1/9
 * @comment
 */

import java.util.TreeSet;

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

        if(nums==null||nums.length==0||k<=0) return false;

        TreeSet<Long> treeSet = new TreeSet<Long>(); //注意这个数据结构 treeset
        for(int i=0;i<nums.length;i++){

            final Long floor = treeSet.floor((long)nums[i]+t); //取出treeset中nums[i]+t下最大的
            final Long ceil = treeSet.ceiling((long)nums[i]-t);

            if((floor!=null&&floor>=(long)nums[i])||
                    (ceil!=null&&ceil<=(long)nums[i])){
                return true;
            }

            treeSet.add((long)nums[i]);
            if(i>=k){        //因为元素的坐标差不能超过k，所以在treeSet中最多只能有k个元素
                treeSet.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
