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
        //注意是第一个不为0的数字
        String newstr=str.trim();
        int i=0,index=1;
        long base=0;
        if(!newstr.isEmpty()){

            //判断转化后的数字是正还是负
            if(newstr.charAt(i)=='-' || newstr.charAt(i)=='+'){
                index=newstr.charAt(i)=='-'?-1:1;
                i++;
            }
            boolean temp=true;
            while(newstr.charAt(i)>='0' && newstr.charAt(i)<='9'){
                if(newstr.charAt(i)=='0' && temp){
                    i++;
                    continue;
                }
                //第一非0判断
                temp=false;
                base=(base*10) + (newstr.charAt(i++)-'0');
                if(base>Integer.MAX_VALUE){
                    return index==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
            }




        }else{
            return 0;
        }
        return (int)(index * base);

    }
}
