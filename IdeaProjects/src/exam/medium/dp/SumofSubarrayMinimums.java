package medium.dp;

/**
 * @author YangShuo
 * @create 2019/2/13
 * @comment
 */
public class SumofSubarrayMinimums {

    /**
     *动态规划的条件，有重叠子问题，可以划分为多个子问题，
     */
    //时间复杂度为nlngn的动态规划，可能会引起超时
    public int sumSubarrayMins(int[] A) {
        //i:表示当前元素
        //j:表示当前元素左移j-1个元素
        //转移方程：当i=1，j=1时   dp[i][j]=a[i-1]
        //                       dp[i][j]=min(a[i-1],dp[i-1][j-1])
        int max=A.length;
        int[][] dp=new int[max][max];

        for(int i=0;i<A.length;i++){
            dp[i+1][1]=A[i];
        }

        for(int i=1;i<A.length;i++){

            for(int j=2;j<=i+1;j++){
                dp[i+1][j]=min(A[i],dp[i-1][j-1]);
            }

        }
        //求和

        return 1;
    }

    public static int min(int i,int j){

        return i>=j?i:j;

    }
}
