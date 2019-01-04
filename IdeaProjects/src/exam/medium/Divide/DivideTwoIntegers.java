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
        long i =divide(-2147483648,2);
        System.out.println("结果是："+i);
    }
    public static long divide(int dividend, int divisor) {
        int sig=1;
        if((dividend<0 && divisor<0 ) ){
            sig=1;
        }else if(dividend<0 || divisor<0){
            sig=-1;
        }
        if(divisor == -1 && dividend == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;

        }else if(dividend==divisor){

            return 1;
        }else if(divisor==1){
            return dividend;
        }

        long dividendnew= Math.abs((long)dividend);
        long divisornew= Math.abs((long)divisor);

        if(divisornew ==0
                || dividendnew==0
                || dividendnew < divisornew
                ){
            //System.out.println("我进来了");
            return 0;
        }else if(dividendnew==divisornew){

            return sig*1;
        }


        //todo:利用除数的左移
        long temp=divisornew;
        int result=0;
        int count2=-1;
        while(temp<dividendnew){
            int count=1;
            while((divisornew << 1)<=dividendnew){

                divisornew=divisornew << 1;
                count = count<<1;
                System.out.println(divisornew+"+++"+count);

            }
            if(dividendnew==divisornew){
                return  sig*count;
            }
            result=result+count;
            dividendnew=dividendnew-divisornew;
            System.out.println("被除数是"+dividendnew);

            divisornew=temp;
            count2++;
        }
        System.out.println(sig);
        return  sig*result;
    }
}
