package medium.charsTransform;

/**
 * @author YangShuo
 * @create 2018/12/28
 * @comment
 */

/**
 * Implement atoi which converts a string to an integer.

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned.

 1:字符串转化为int  注意不要超过int的范围
 */
public class atoi {

    public static int myAtoi(String str){
        String newstr=str.trim();
        if(!newstr.isEmpty()){
            int i=0,index=1;//判断转化后的数字是正还是负
            long base=0;
            index=newstr.charAt(0)=='-'?-1:1;

            
        }else{
            return 0;
        }

    }
}
