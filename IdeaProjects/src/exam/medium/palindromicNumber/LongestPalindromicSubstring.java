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
     * @param s
     * @return
     */
    public static void main(String[] args) {

        String i = longestPalindrome2("aabaacd");

        System.out.println("结果是："+i);
    }

    public static String longestPalindrome2(String s) {
        //dp设置传递规则
        char[] newss=s.toCharArray();
        int[][] dp=new int[s.length()][s.length()];
        //dp[i][j]=1        ------i=j
        //dp[i][j]= s[i]==s[j]   -------j=i+1
        //dp[i][j]= s[i]==s[j] && dp[i+1][j-1]   -----j>i+1
        int left=0,right=0,len=0;
        for(int i=0;i<s.length();i++){
           for(int j=i;j<s.length();j++){
               if(i==j){
                   dp[i][j]=1;
               }
               if(j==i+1 && (newss[i]==newss[j])){
                   dp[i][j]= 1;
               }
               if(j>i+1 && (newss[i]==newss[j])  && dp[i+1][j-1]==1){
                   dp[i][j]= 1;
               }
               if(dp[i][j]==1 && len<(j-i+1)){
                    len=j-i+1;
                    left=i;
                    right=j;
               }
           }
        }

        return s.substring(left, right - left + 1);
    }
}
