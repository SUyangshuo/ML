package medium.sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author YangShuo
 * @create 2019/2/14
 * @comment
 */
public class LargestNumber {
    //老的方法 使用comparator方法
    public String largestNumber(int[] nums) {
        if(nums.length<=0 || nums == null){
            return null;
        }
        String[] string=new String[nums.length];

        //把int转化为string
        for(int i=0;i<nums.length;i++){
            string[i]=String.valueOf(nums[i]);
        }

        Comparator<String> com=new Comparator<String>(){//外比较器   Comparable是内比较器
            @Override
            public int compare(String str1,String str2) {
                String s1=str1+str2;
                String s2=str2+str1;

                return s2.compareTo(s1);
            }
        };

        Arrays.sort(string,com);

        if(string[0].charAt(0)=='0'){
            return "0";
        }

        StringBuffer sb=new StringBuffer();

        for(String s:string){
            sb.append(s);
        }


        return sb.toString();
    }
    //使用1.8中的stream类

    public String largestNumber2(int[] num) {
        String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    }

}
