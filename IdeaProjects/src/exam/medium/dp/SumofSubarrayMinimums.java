package medium.dp;

import java.util.Stack;

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

    public static void main(String[] args) {
        int[] a = new int[]{76};

        System.out.println(sumSubarrayMins2(a));

    }
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
    //方法2：res = sum(A[i] * f(i))，其中f(i)是子数组的数量，A[i]是最小值  求每个元素作为最小值的时候次数
    public static Stack<int[]> stack=new Stack<>();

    public static int sumSubarrayMins2(int[] A){

        //创建两个数组 left和right
        //left保存元素左侧大于该元素的子数组个数, right保存元素右侧大于-等于该元素的子数组个数
        //这两个数组的计算方法按照单调栈的方式
        int[] leftPlus=new int[A.length];
        int[] rightPlus=new int[A.length];
        long sum=0;

        //left
        for(int i=0;i<A.length;i++){
            leftPlus[i]=preStack(A[i]);

        }
        stack.clear();
        //right
        for(int i=A.length-1;i>=0;i--){
            rightPlus[i]=laterStack(A[i]);
        }

        for(int i=0;i<A.length;i++){

            sum+=A[i]*leftPlus[i]*rightPlus[i];
            sum %= 1000000007;
        }

        return  (int)sum;



    }
    public static int preStack(int pre){
        int rec=1;
        while(!stack.isEmpty() && stack.peek()[0]>pre){
            rec+=stack.pop()[1];

        }
        stack.push(new int[]{pre,rec});
        return rec;
    }

    public static int laterStack(int pre){
        int rec=1;
        while(!stack.isEmpty() && stack.peek()[0]>=pre){
            rec+=stack.pop()[1];

        }
        stack.push(new int[]{pre,rec});
        return rec;
    }
}
