package medium.ContinuousSubarraySum;

/**
 * @author YangShuo
 * @create 2019/1/28
 * @comment
 */
public class ContinuousSubarraySumI {
    public static void main(String[] args) {


    }
    //暴力破解
    public boolean checkSubarraySum(int[] nums, int k) {
        //除数为0的情况
        if(k==0){
            return checkzero(nums);//trick
        }
        if(nums.length<2){
            return false;
        }
        if(!checkzero(nums)){
            for(int i=0;i<nums.length;i++){
                int sum=0;

                for(int j=i+1;j<nums.length;j++){
                    sum+=nums[j];

                    if(sum==0 || sum%k==0){
                        return true;
                    }
                }
            }
        }else{
            return true;
        }

        return false;
    }
    //判断被除数是否为0
    public static boolean checkzero(int[] nums){

        for(int i:nums){
            if(i==0){
                return true;
            }

        }
        return false;

    }
    //

}
