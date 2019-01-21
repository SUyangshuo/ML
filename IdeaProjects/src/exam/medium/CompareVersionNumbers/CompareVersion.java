package medium.CompareVersionNumbers;

/**
 * @author YangShuo
 * @create 2019/1/21
 * @comment
 */
public class CompareVersion {
    public static void main(String[] args) {


        int a=compareVersion("1","1.1");
        System.out.println(a);


    }
    public static int compareVersion(String version1, String version2) {


        String[] a=version1.split("\\.");
        String[] b=version2.split("\\.");

        int min=Math.min(a.length,b.length);

        int i=0;
        for(;i<min;i++){
            int aNew=Integer.valueOf(a[i]);
            int bNew=Integer.valueOf(b[i]);
            if(aNew<bNew){
                return -1;
            }else if(aNew > bNew){
                return 1;
            }
        }
        
        if(b.length>a.length){

            System.out.println("----"+b.length+"---"+i);

            for(;i<b.length;i++){
                if(Integer.valueOf(b[i])!=0){
                    return -1;
                }
            }
        }else if(b.length<a.length){
            for(;i<a.length;i++){
                if(Integer.valueOf(a[i])!=0){
                    return 1;
                }
            }
        }




        return 0;
    }
}
