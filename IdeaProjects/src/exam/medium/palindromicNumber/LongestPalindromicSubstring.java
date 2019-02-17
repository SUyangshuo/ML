package medium.palindromicNumber;

/**
 * @author YangShuo
 * @create 2019/2/16
 * @comment
 */

/**
 * 5. Longest Palindromic Substring  最长回文子串
 */
public class LongestPalindromicSubstring {
    /**
     * 最长回文串有多种解法，
     * 1：以该点为中心向左右扩散
     * 2：dp，使用一个二维数组dp[i][j]保存表示i-j稍微为回文串
     * 3:

     */
    public static void main(String[] args) {

        String i = longestPalindrome2("abcdbbfcba");
        //String ss="abcdbbfcba";
        //System.out.println(ss.substring(4,6));
        System.out.println("结果是hi："+i);

    }

    public static String longestPalindrome2(String s) {

        if(s.length()<1 || s.isEmpty()){
            return "";
        }
        //dp设置传递规则
        char[] newss=s.toCharArray();
        int[][] dp=new int[s.length()][s.length()];
        //dp[i][j]=1        ------i=j
        //dp[i][j]= s[i]==s[j]   -------j=i+1
        //dp[i][j]= s[i]==s[j] && dp[i+1][j-1]   -----j>i+1
        int left=0,right=0,len=0;
        //注意 遍历的时候竖行遍历


        for(int j=0;j<s.length();j++){
            for(int i=0;i<=j;i++){
                if(i==j){
                    dp[i][j]=1;
                }
                if(newss[i]==newss[j] && i==j-1){
                    dp[i][j]=1;

                }
                if(newss[i]==newss[j] && j-i>1 ){
                    dp[i][j]=dp[i+1][j-1];
                }
                if(dp[i][j]==1 && len<j-i+1){
                    len=j-i+1;
                    left=i;
                    right=j;
                }
            }
        }
        System.out.println("left"+left+"---right"+right+"-----s.length"+s.length());

        return s.substring(left, right+1);
    }
}
