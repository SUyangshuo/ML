package medium.reverseString;

/**
 * @author YangShuo
 * @create 2019/1/2
 * @comment
 */

import javax.rmi.CORBA.Util;
import java.util.Stack;

/**
 * Given an input string, reverse the string word by word.

 Example:

 Input: "the sky is blue",
 Output: "blue is sky the".

 Note:

 A word is defined as a sequence of non-space characters.
 Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 You need to reduce multiple spaces between two words to a single space in the reversed string.

 Follow up: For C programmers, try to solve it in-place in O(1) space.
翻转字符串，并且去除多余的空格
 */
public class reverseWordInString {
    public static void main(String[] args) {
        String ii="the sky is blue";
        String i=reverseWords(ii);
        System.out.println("最终结果是"+i);
    }
    public static String reverseWords(String s) {
        String newstr=s.trim();
        String result="";

        int index=0;
        Stack<String> stack = new Stack<String>();

        if(!newstr.isEmpty()){
            String temp="";
            char lastTemp=' ';
            while(index<newstr.length()){
                if(newstr.charAt(index) != ' '){
                    temp=temp+newstr.charAt(index);


                    lastTemp=newstr.charAt(index);
                }else if(lastTemp!=' '){


                    stack.push(temp);
                    temp="";
                }
                index++;
            }
            stack.push(temp);
             result=stack.pop();


            while(!stack.isEmpty()){
                result=result+" "+stack.pop();
            }
        }



        return result;
    }
}
