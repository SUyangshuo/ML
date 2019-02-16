package medium.slidingWindow;

import java.util.HashMap;

/**
 * @author YangShuo
 * @create 2019/2/15
 * @comment
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 3. Longest Substring Without Repeating Characters
     * 找出子串中没有重复字符的最大长度
     * 主要使用了一个滑动窗口的方法
     *
     */
    public static void main(String[] args) {

        int i = lengthOfLongestSubstring("aabaab!bb");
        System.out.print("结果是" + i);
    }

    public static int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();

        //map中key存放字符，value存放字符位置
        HashMap<Character,Integer> hashMap=new HashMap<Character, Integer>();

        int left=0,right=0;
        int max=0;
        for(int i=0;i<s.length();i++){

            if(!hashMap.containsKey(chars[i]) || hashMap.get(chars[i])<left){
                hashMap.put(chars[i],i);
                right++;
                max=max>(right-left)?max:(right-left);

            }else{

                left=hashMap.get(chars[i])+1;
                hashMap.put(chars[i],i);
                right++;

                max=max>(right-left)?max:(right-left);

            }

            System.out.println("left=" + left+"right="+right);

        }
        return max;
    }
    //还可以使用256位的数组来代替hashmap 原因是ASCII表共能表示256个字符  但是键盘只有128个键位 用128的数组也可以

}
