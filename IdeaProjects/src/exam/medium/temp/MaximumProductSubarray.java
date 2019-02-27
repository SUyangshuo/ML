package medium.temp;

/**
 * @author YangShuo
 * @create 2019/2/26
 * @comment
 */

/**
 * 152. Maximum Product Subarray
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] a=new int[]{2,3,-2,4};

        int i = maxProduct(a);
       // System.out.print("结果是" + i);
    }
    /**  最大子数组连乘
     * dp问题 需要保留每次新增元素后的乘积最大值和最小值
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        //乘法最大值有两种情况，要么是负数乘一个负数， 要么是正数乘正数，所以每一步都保存每一步的最大和最小值

        if(nums.length==1){
            return nums[0];
        }

        int[] max=new int[nums.length];
        int[] min=new int[nums.length];

        max[0]=nums[0];
        min[0]=nums[0];


        int maxNumber=nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                max[i]=Math.max(min[i-1]*nums[i],nums[i]);
                min[i]=Math.min(max[i-1]*nums[i],nums[i]);
                maxNumber=Math.max(max[i],maxNumber);
            }else {
                max[i]=Math.max(max[i-1]*nums[i],nums[i]);
                min[i]=Math.min(min[i-1]*nums[i],nums[i]);
                maxNumber=Math.max(max[i],maxNumber);

            }


        }

        return maxNumber;
    }

}
