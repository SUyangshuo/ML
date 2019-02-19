package Tool.kmp;

/**
 * @author YangShuo
 * @create 2019/2/18
 * @comment
 */
public class kmp {
    /**
     *kmp算法的基本原则是基于模式串前后存在相同的部分
     */
    public static boolean kmpSearch(String a,String b){


        char[] s=a.toCharArray();
        char[] p=b.toCharArray();

        int i = 0;
        int j = 0;
        int sLen = a.length();
        int pLen = b.length();

        int[] next = getNext(b);//获得next数组
        while (i < sLen && j < pLen)
        {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s[i] == p[j])
            {
                i++;
                j++;
            }
            else
            {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }


        if (j == pLen)
            return i - j;
        else
            return -1;

        return false;
    }



    //next数组应用在模式串上，目的是在于找到模式串前后的相同位置
    public static int[] getNext(String a){

        //a为原串，b为子串
        int[] next=new int[a.length()];

        char[] p=a.toCharArray();

        int i=0;

        int k=-1;//长度为k 的相同前缀和后缀

        next[0]=-1;//next数组的第一位是-1

        while(i<a.length()){
            if(k==-1 || p[i]==p[k]){
                k++;
                i++;
                next[i]=k;
            }else{
                k=next[k];//相当于p[k] 跳到上一个有相同前后缀的地方
            }

        }

        return next;
    }
}
