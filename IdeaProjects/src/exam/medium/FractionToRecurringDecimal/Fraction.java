package medium.FractionToRecurringDecimal;

import java.util.HashMap;

/**
 * @author YangShuo
 * @create 2019/1/8
 * @comment
 */
public class Fraction {

    public  static void main(String[] args){
        String i=fractionToDecimal(-1,-2147483648);
        System.out.print(i);
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result=new StringBuilder();

        //确定正负
        if((numerator<0 && denominator>0) ||(numerator>0 && denominator<0)){
            result.append("-");
        }
        long denominatorNew=Math.abs(denominator);

        long numeratorNew=Math.abs(numerator);
        System.out.println("除数和被除数"+numeratorNew+"))))"+denominatorNew+"()()()("+denominator);


        long temp =numeratorNew/denominatorNew;
        result.append(temp);

        numeratorNew = (numeratorNew%denominatorNew)*10; //重点：余数乘10后再次变为分子


        if(numeratorNew!=0){
            result.append(".");
        }
        //todo:利用hashtable映射来判断小数部分循环   hashmap里面 key是numerator，value是stringbuilder.length

        HashMap<Long,Integer> hashmap = new HashMap<Long,Integer>();

        while(numeratorNew!=0){
            if(hashmap.containsKey(numeratorNew)){
                int index=hashmap.get(numeratorNew);//toso:表示在哪个位置插入（
                result.insert(index,"(");
                result.append(")");
                break;
            }else{

                temp=numeratorNew/denominatorNew;
                hashmap.put(numeratorNew,result.length());
                numeratorNew=(numeratorNew%denominatorNew)*10;
                System.out.println("++++"+temp);

                result.append(temp);
            }
        }


        return result.toString();
    }
}
