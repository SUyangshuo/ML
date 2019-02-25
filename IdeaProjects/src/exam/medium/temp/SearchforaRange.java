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
    public static void main(String[] args) {


        int[] a = new int[]{2,2};
          int[] b=new int[2];
          b=searchRange(a,2);
        System.out.print("结果是" + b[0]+"-----"+b[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] a=new int[]{-1,-1};

        if(nums.length<1 || nums ==null){
            return a;
        }

        int min=nums.length/2;

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
    //jhjhgfjgvjk
        int i=min-1,j=min+1;



            if(min==0){
                a[0]=min;
                if(j<nums.length){
                    while(nums[j]==target){
                        if(j+1<nums.length){
                            j++;
                        }else{
                            break;
                        }
                    }
                    a[1]=j-1;
                }else{
                    a[1]=min;
                }

            }else if(min==nums.length-1){
                a[1]=min;
                if(i>=0){
                    while(nums[i]==target){
                        if(i-1>=0){
                            i--;
                        }else{
                            break;
                        }
                    }
                    a[0]=i+1;
                }else{
                    a[0]=min;
                }

            }else {

                while(i>=0){
                    if(nums[i]==target){
                        if(i-1>=0){
                            i--;
                        }else{
                            break;
                        }
                        continue;
                    }
                    break;
                }
                while(j<nums.length){
                    if(nums[j]==target){
                        if(j+1<nums.length){
                            j++;
                        }else{
                            break;
                        }
                        continue;

                    }
                    break;
                }
                a[0]=i+1;
                a[1]=j-1;

            }



        return a;
    }
}
