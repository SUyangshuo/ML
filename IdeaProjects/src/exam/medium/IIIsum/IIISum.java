package medium.IIIsum;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author YangShuo
 * @create 2019/1/24
 * @comment
 */
public class IIISum {
    //求三数之和等于0  不能使用暴力解法
    public static void main(String[] args) {



        int[] a={              };
        threeSum2(a);


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //首先对数组排序
        List<List<Integer>> result=new ArrayList<>();


        Arrays.sort(nums);//首先对集合进行排序

        //对于一个已经顺序的集合来说 从第一个开始遍历，a[i]设为标记，这时从i+1---length 找到两个数 和等于a[i]的相反数
        //因为等于0 所以遍历到第一个整数就停止，

        //双指针  l指针指向i++  r指针指向length

        for(int i=0;i<nums.length-1;i++){
            //System.out.println(tempNume.get(i));
            int tempNumber=nums[i];

            if(nums[i]>0){
                break;
            }
            if(i==0 || tempNumber != nums[i-1] ){
                int t = 0-tempNumber;

                int l=i+1;//左指针
                int r=nums.length-1;//右指针

                while(l<r){
                    if(nums[l]+nums[r]==t){
                        //两边指针下一位相同
                        if(r<nums.length-1 && l>i+1  && nums[l]==nums[l-1] && nums[r]==nums[r+1]) {
                            l++;
                            r--;
                            continue;
                        }

                        //System.out.println(tempNume.get(i)+"=="+tempNume.get(l)+"=="+tempNume.get(r));
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));

                        if(nums[l]==nums[r]){
                            break;
                        }
                        l++;
                        r--;
                    }else if(nums[l]+nums[r]-t<0){
                        //左指针右移
                        l++;
                    }else if(nums[l]+nums[r]-t>0){
                        //右指针左移
                        r--;
                    }
                }
            }


        }

        return result;
    }
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (len < 3) {
            return result;
        }

        Arrays.sort(nums);

        // for all number that can be the 1st number of triplet
        for (int i = 0; i < len - 1; i++) {
            int firstNumber = nums[i];

            // skip all duplicated first number
            if (i == 0 || firstNumber != nums[i - 1]) {

                int leftIndex  = i + 1;
                int rightIndex = len - 1;
                int twoSumTarget = 0 - firstNumber;

                // try to find two numbers that sum up to twoSumTarget
                while (leftIndex < rightIndex) {
                    int twoSum = nums[leftIndex] + nums[rightIndex];
                    if (twoSum == twoSumTarget) {
                        // one valid triplet found!!
                        result.add(Arrays.asList(firstNumber, nums[leftIndex], nums[rightIndex]));
                        // skip duplicated nums[leftIndex]
                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                            leftIndex++;
                        }
                        // skip duplicated nums[rightIndex]
                        while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                            rightIndex--;
                        }
                        // move to next non-duplicates
                        leftIndex++;
                        rightIndex--;
                    } else if (twoSum < twoSumTarget) {
                        // move left towards right to
                        // make twoSum larger to get closer to twoSumTarget
                        leftIndex++;
                    } else {
                        rightIndex--;
                    }
                }

            }
        }

        return result;
    }

}
