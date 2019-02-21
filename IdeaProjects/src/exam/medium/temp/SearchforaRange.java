package medium.temp;

import java.util.Arrays;

/**
 * @author YangShuo
 * @create 2019/2/21
 * @comment
 */

//34. Find First and Last Position of Element in Sorted Array
    //查找某个元素在数组中，第一次和最后一次出现的位置
    //数组是一个有序的
public class SearchforaRange {
    //直接使用二分查找
    //找到相应元素后就向左右遍历

    public int[] searchRange(int[] nums, int target) {

        int min=nums.length/2;

        int[] a=new int[]{-1,-1};
        while(nums[min]!=target ){
            if(min==0 || min==nums.length-1){
                return a;
            }
            if(nums[min]>target){
                min=min/2;
            }else if(nums[min]<target) {
                min=min+(nums.length-min)/2;
            }
        }
        int i=min-1,j=min+1;



            if(min==0){
                a[0]=min;
                while(nums[j]==target){
                    j++;
                }
                a[1]=j-1;
            }else if(min==nums.length-1){
                a[1]=min;
                while(nums[i]==target){
                    i--;
                }
                a[1]=i+1;
            }else {
                while(i>=0 && j<nums.length){
                    if(nums[i]==target){
                        i--;
                    }
                    if(nums[j]==target){
                        j++;
                    }
                }
                a[0]=i+1;
                a[1]=j-1;

            }





        return a;
    }
}
