package medium.ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

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
        boolean result=false;
        if(k==0){
            //return checkzero(nums);//trick
            for(int i = 0 ; i < nums.length - 1; i ++){
                if(nums[i] == 0 && nums[i] == nums[i + 1]) {return result;}
            }
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
            if(i==0 ){
                return true;
            }

        }
        return false;

    }
    //利用一个技巧，就是两个数相加和对k取余

    public static boolean checkSubarraySum2(int[] nums, int k){

        Map<Integer,Integer> map=new HashMap<>();
        Integer subarray=0;

        for(int i=0;i<nums.length;i++){
            subarray+=nums[i];
            if(k!=0){
               subarray%=k;
            }

            Integer pre=map.get(subarray);

            if(pre != null && i-pre>1){//两个余数的位置不能相同
                return true;
            }else{
                map.put(pre,i);
            }

        }

        return false;
    }
    public boolean checkSubarraySum3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}}; //提前放一个余数为0 的
        int runningSum = 0;
        for (int i=0;i<nums.length;i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;  //注意这里为什么是大一1   而不是等于1
            }
            else map.put(runningSum, i);
        }
        return false;
    }


}
