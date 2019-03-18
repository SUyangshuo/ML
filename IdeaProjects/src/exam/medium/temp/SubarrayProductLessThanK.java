package medium.temp;

/**
 * @author YangShuo
 * @create 2019/2/27
 * @comment
 */
public class SubarrayProductLessThanK {
    /**
     * 连乘小于k的子数组一共有多少个---------step1:数组内全部大于0
     */


    public static void main(String[] args) {
        int[] a=new int[]{1,1,1};

        int i = numSubarrayProductLessThanK2(a,2);
         System.out.print("结果是" + i);
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //利用二维dp数组 保存每次新增元素连乘后时候小于k---这种方法时间复杂度为o(n2)

        if(nums.length==1 && nums[0]<k){
            return 1;

        }else if(nums.length==1 && nums[0]>=k){
            return 0;
        }

        int[][] dp=new int[nums.length][nums.length];
        //按照竖行遍历
        for(int j=0;j<nums.length;j++){
            for(int i=0;i<=j;i++){

            }

        }


        return 1;
    }

    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        /**
         *  利用滑动窗口 设定左右指针，右指针每次右移，如果乘积小于k则继续右移动，如果乘积大于k，左指针右移，左指针移动前的左右指针差值就是该窗口的子数组串
         *    注意：nums[i]<k 如果出现该值大于k 则直接r++;  l=r
         *          如果出现中间l==i; 同样 r++,l=r

         */

        if(nums.length==1 && nums[0]<k){
            return 1;

        }else if(nums.length==1 && nums[0]>=k){
            return 0;
        }
        int product=1;
        int l=0;
        int r=0;
        int count=0;
        while(l<nums.length ){




                if(product<k && r+1<nums.length){
                    product=product*nums[r];

                    count++;
                        r++;
//                    if(r == nums.length){
//                        r=r-1;
//                    }
                }else{
                    count=count+(r-l);

                    product=product/nums[l];
                    l++;
                }


        }

        return count;
    }

}


void gao(int n, int nums[] , int k ){

}