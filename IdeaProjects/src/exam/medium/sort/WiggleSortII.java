package medium.sort;

import java.util.Arrays;

/**
 * @author YangShuo
 * @create 2019/2/20
 * @comment
 */
public class WiggleSortII {

//324. Wiggle Sort II
    //传统方法 排序后 交叉排序,空间复杂度为o(n)

    public void wiggleSort(int[] nums) {

        int[] newNums = new int[nums.length];
        int length = nums.length;
        if(nums == null || length < 2)
            return;
        for(int i = 0; i < length; i++)
            newNums[i] = nums[i];

        Arrays.sort(nums);  //排序
        if(length == 2)
            return;
        int k = length - 1;
        for(int i = 1; i < length; i = i + 2)
        {
            newNums[i] = nums[k];
            k = k - 1;
        }
        for(int j = 0; j < length; j = j + 2)
        {
            newNums[j] = nums[k];
            k = k - 1;
        }
        for(int i = 0; i < length; i++)
        {
            nums[i] = newNums[i];
            //System.out.print(newNums[i] + "  ");
        }


        }
        //空间复杂度为o(1)


}
