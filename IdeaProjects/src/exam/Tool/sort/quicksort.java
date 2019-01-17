package Tool.sort;

/**
 * @author YangShuo
 * @create 2019/1/17
 * @comment
 */
public class quicksort {
    //版本一：使用快速排序  使用第一个值为比较值
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
