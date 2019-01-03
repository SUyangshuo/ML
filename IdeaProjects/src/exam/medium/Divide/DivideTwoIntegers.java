package medium.Divide;

/**
 * @author YangShuo
 * @create 2019/1/3
 * @comment
 */

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

 Return the quotient after dividing dividend by divisor.

 The integer division should truncate toward zero.


 不使用乘法和除法，取模运算，计算两个数的余数
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        int i =divide(10,3);
        System.out.println("结果是："+i);
    }
    public static int divide(int dividend, int divisor) {
        if(divisor ==0
                || dividend == divisor
                || dividend >=Integer.MAX_VALUE
                || divisor >=Integer.MAX_VALUE
                || divisor <=Integer.MIN_VALUE
                || dividend <=Integer.MIN_VALUE
                || divisor==1
                || dividend==0
                ){
            return 0;
        }else if( dividend < divisor){
            return dividend;
        }
        int sig=1;
        if((dividend<0 && divisor<0 ) ){
            sig=1;
        }else if(dividend<0 || divisor<0){
            sig=-1;
        }

        //todo:利用除数的左移
        int temp=divisor;
        int count=-1;
        int count2=-1;
        while(temp<dividend){

            while((divisor << 1)<dividend){
                divisor=divisor << 1;
                count++;
            }
            if(dividend==divisor){
                return  2<<count;
            }
            dividend=dividend-divisor;
            divisor=temp;
            count2++;
        }

    return  sig*((2<<count)+count2);
    }
}
