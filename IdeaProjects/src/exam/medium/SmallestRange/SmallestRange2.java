package medium.SmallestRange;

/**
 * @author YangShuo
 * @create 2019/1/17
 * @comment
 */

/**
 * Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).

 After this process, we have some array B.

 Return the smallest possible difference between the maximum value of B and the minimum value of B.

 数组a中没给元素+k，或者-k，组成新的数组b，求组成新的数组中最大值和最小值的差最小
 */
public class SmallestRange2 {
    //todo：首先对a进行排序 这个时间复杂度是logn  然后根据两个性质
    //性质1：如果A[i]需要+k 则在A[i]以后的元素都要+k
    //性质2：如果A[i]需要-k，则在A[i]之前的元素都要-k
    public int smallestRangeII(int[] A, int K) {
        int j=A.length;
        int i=0;
        int tempNumber=A[0];
        sortstep1(A,i,j);

        //现在a是有序的，进行枚举
        for(int s=0;s<A.length;s++){
            
        }

        return 0;
    }
    //使用快速排序
    public static void sortstep1(int[] a,int i,int j){
        if(i>=j){
            return ;
        }
        int index=sortstep2(a,i,j);

        if(index > 0 && index < a.length-1){
            sortstep1(a,0,index-1);
            sortstep1(a,index+1,a.length-1);
        }else if(index == 0){
            sortstep1(a,index+1,a.length-1);
        }else {
            sortstep1(a,0,index-1);
        }


    }

    //返回数字确定的位置
    public static Integer sortstep2(int[] a,int i,int j){

        if(i==j){
           return null;
        }
        int temp=a[i];//把第一个作为比较值

        while(i<j){
            while(a[j]>temp && j>i){
                j--;
            }
            swap(a,j,i);
            while(a[i]<temp && i<j){
                i++;
            }
            swap(a,i,j);
        }
        return i;
    }

    public  static int[] swap(int[] a,int x,int y){

        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;
        return a;
    }
}