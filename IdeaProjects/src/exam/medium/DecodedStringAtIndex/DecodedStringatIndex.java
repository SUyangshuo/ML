package medium.DecodedStringAtIndex;

/**
 * @author YangShuo
 * @create 2019/1/23
 * @comment
 */
public class DecodedStringatIndex {

    public static void main(String[] args) {




        String i = decodeAtIndex2("leet2code3",10);

        System.out.print("结果是" + i);
    }
    //存在有特例，特别大的k值时无法计算
    public static String decodeAtIndex(String S, int K) {

        char[] s=S.toCharArray();
        if(s[S.length()-1]%K==0){

        }


        StringBuffer result=new StringBuffer();
        for(char b:s){
            boolean indexBoolean=true;
            //判断b是不是字母   如果是数字n的话需要将result重复n-1
            if((b>96 && b<123) ||(b>63 && b<91)){//说明是字母
                result.append(b);
            }else{   //说明是数字
                String temp="";
                System.out.println("数字是" + b);

                for(int i=0;i<b-'0';i++){
                    System.out.println("数字之前的字符串是" + result);

                    temp=temp+result;
                    if(temp.length()>K){
                        indexBoolean=false;
                        break;
                    }
                }
                result=new StringBuffer();
                result.append(temp);

                if(indexBoolean==false){
                    break;
                }

            }

        }
        System.out.print("最终字符串是" + result);


        return String.valueOf(result.toString().toCharArray()[K-1]);
    }
    //ac版本
    public static String decodeAtIndex2(String S, int K) {
        long size=0;
        char[] s=S.toCharArray();
        //首先计算长度
        int i=0;
        for( i=0;i<S.length();i++){
            if(!isdigit(s[i])){
                size++;
            }else{
                size=size*(s[i]-'0');

            }
            if(size>=K){
                break;
            }
        }

        System.out.print("长度是---i是" + size+"----"+i);

        //从后往前遍历i
        if(i==S.length()){
            i=i-1;
        }


        for(int j=i;j>0;j--){

            if(isdigit(s[j])){//如果是数字
                size /= s[j]-'0';
                K %= size;
            }else {
                if(K==0 || size==K){ //最后一个字符是
                    return String.valueOf(s[j]);
                }else{
                    size--;
                }
            }

        }

        return "";
    }

    public static boolean isdigit(char s){
        if((s>96 && s<123) ||(s>63 && s<91)){//说明是字母
            return false;
        }
        return true;

    }
}
