package medium.palindromicNumber;

/**
 * @author YangShuo
 * @create 2019/1/7
 * @comment
 */

/**
 *  867. Prime Palindrome  回文素数
 * Find the smallest prime palindrome greater than or equal to N.

 Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.

 For example, 2,3,5,7,11 and 13 are primes.

 Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.

 For example, 12321 is a palindrome.

 判断大于n的最小回文素数
 1：首先是一个素数
 2：是一个回文数
 可知偶数位的回文数都能被11整除（肯定不是素数），所以可以直接判断奇数位的回文数
 判断n是否为素数时，只需要判断n的平方根是否含能被整除即可
 */
public class PrimePalindrome {
    public static void main(String[] args) {

        int i = primePalindrome(61023998);

        System.out.println("结果是："+i);
    }
    public static int primePalindrome(int N) {
        if(N==8){
            return 11;
        }
        //N=N+1;


        while(isnotPalindrome(N) || isnotPrime(N)){
            N++;
        }



        return N;
    }
    //判断回文数
    public static boolean isnotPalindrome(int x){
        String temp1=String.valueOf(x);
        String temp= new StringBuilder(temp1).reverse().toString(); //费时
        if(temp.equals(temp1) && (temp.length()%2!=0 || x<=11)){ //奇数位才可以
            return false;

        }else {
            return true;
        }
    }
    //判断素数
    public static boolean isnotPrime(int x){
        boolean booler=false;

        if(x<=1) return true;
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0){
                booler=true;
                break;
            }
        }
        return booler;
    }
    public static boolean isnotPalindrome2(int x){ //从个位开始反转

        int a, b, c;
        a = x;
        b = 0;
        c = 0;
        while (x>0){
            c = x % 10;
            x /= 10;
            b = b * 10 + c;
        }
       return a!=b;
    }

}
