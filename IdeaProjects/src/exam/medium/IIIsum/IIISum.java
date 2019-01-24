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



        int[] a={-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
         threeSum(a);


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //首先对数组排序
        List<List<Integer>> result=new ArrayList<>();

        List<Integer >  tempNume= new ArrayList<>();
        for(int i:nums){
            tempNume.add(i);
        }
        Collections.sort(tempNume);//首先对集合进行排序

        //对于一个已经顺序的集合来说 从第一个开始遍历，a[i]设为标记，这时从i+1---length 找到两个数 和等于a[i]的相反数
        //因为等于0 所以遍历到第一个整数就停止，

        //双指针  l指针指向i++  r指针指向length

        for(int i=0;i<tempNume.size();i++){
            //System.out.println(tempNume.get(i));

            if(tempNume.get(i)>0){
                break;
            }
            if(i!=0 && (tempNume.get(i-1) == tempNume.get(i)) ){
                continue;
            }

            int t = 0-tempNume.get(i);

            int l=i+1;//左指针
            int r=tempNume.size()-1;//右指针

            while(l<r){



                if(tempNume.get(l)+tempNume.get(r)==t){
//                    String tempResult=tempNume.get(l)+","+tempNume.get(r);
//                    if(set.contains(tempResult)){
//                        continue;
//                    }
//                    set.add(tempResult);
                    System.out.println(tempNume.get(i)+"=="+tempNume.get(l)+"=="+tempNume.get(r));
                    result.add(Arrays.asList(tempNume.get(i),tempNume.get(l),tempNume.get(r)));
                    if(tempNume.get(l)==tempNume.get(r)){
                        break;
                    }
                    l++;
                    r--;

                    if(tempNume.get(l)==tempNume.get(l-1) && tempNume.get(r)==tempNume.get(r+1)){
                        l++;
                        r--;
                        continue;
                    }
                }else if(tempNume.get(l)+tempNume.get(r)<t){
                    //左指针右移
                    l++;
                }else if(tempNume.get(l)+tempNume.get(r)>t){
                    //右指针左移
                    r--;
                }
            }
        }

        return result;
    }
}
