package Tool.sort;

/**
 * @author YangShuo
 * @create 2019/1/17
 * @comment
 */
public class quicksort {
    //版本一：使用快速排序  使用第一个值为比较值  时间复杂度为o(nlogn)

    public static void sortstep1(int[] a,int i,int j){

        int k=0;//第k大的数字
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

        ////------------------------
        int index2=sortstep2(a,i,j);

        if(k<index2){
           //说明k值在左边
            sortstep1(a,0,index-1);
        }else if(k>index2+1){
            sortstep1(a,index+1,a.length-1);

        }else if(k==index2+1){
           //return a[index2];
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


    //快排变种：Quick Select  用在返回第k大的数字时候，时间复杂度可以降低为on
    //改动点是在快排序遍历的时候，返回确定下标的时候和k进行比较

    public static Integer sortstep1verxion2(int[] a,int i,int j,int k){

        if(i>=j || k>a.length){
            return null;
        }
        int temp=a.length-k;
        int index2=sortstep2(a,i,j);


        if(temp<index2){
            //说明k值在左边
            sortstep1verxion2(a,0,index2-1,k);
        }else if(temp>index2){
            sortstep1verxion2(a,index2+1,a.length-1,k);

        }
            return a[temp];




    }

}
