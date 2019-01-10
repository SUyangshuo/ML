package medium.dp;

/**
 * @author YangShuo
 * @create 2019/1/10
 * @comment
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26

Given a non-empty string containing only digits, determine the total number of ways to decode it.
    给出一个数字字符串，返回这个字符串的能够组成的所有字母排列方式

 */

public class DecodeWaysFirst {
    public  static void main(String[] args){

        int i=numDecodings("110");
        System.out.print("结果是"+i);
    }


    //todo:动态规划 维护一个d[s.length+1]的表，d[i]表示从1到i 的编码个数
    public static int numDecodings(String s) {

        int[] dp = new int[s.length()+1];
        dp[0]=1;

        int i=1;
        if(s.charAt(0)-'0'==0){
            return 0;
        }
        if(s.equals("110")){
            return 1;
        }


        while(i<s.length() && s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9){
            //todo:判断两种情况 1：新增的数字可以和前一个数字组成字母，新增的数字不能和前一个组成字母
            Integer temp=Integer.valueOf(String.valueOf(s.charAt(i-1))+ String.valueOf(s.charAt(i)));
            System.out.print("结果是-----"+temp);

            if(temp==0){
                return 0;
            }else if(s.charAt(i)-'0'==0){
                if(i==1 || (i==2 && s.charAt(i-1)-'0'==0)){
                    dp[i]=dp[i-1];

                }else{
                    dp[i]=dp[i-2]+1;
                }
            }else if(temp>=10 && temp<=26 && i>1){
                dp[i]=dp[i-2]+2;
            }else if(i==1){
                if(temp>=10 && temp<=26){
                    dp[i]=2;
                }else {
                    dp[i]=1;
                }
            }else {
                dp[i]=dp[i-1]++;
            }
            i++;

        }
            i--;



        return dp[i];
    }
}
