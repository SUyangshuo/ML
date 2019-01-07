package medium.palindromicNumber;

/**
 * @author YangShuo
 * @create 2019/1/7
 * @comment
 */

/**
 * Find the smallest prime palindrome greater than or equal to N.

 Recall that a number is prime if it's only divisors are 1 and itself, and it is greater than 1.

 For example, 2,3,5,7,11 and 13 are primes.

 Recall that a number is a palindrome if it reads the same from left to right as it does from right to left.

 For example, 12321 is a palindrome.

 判断大于n的最小回文素数
 1：首先是一个素数
 2：是一个回文数
 可知偶数位的回文数都能被11整除，所以可以直接判断奇数位的回文数
 判断n是否为素数时，只需要判断n的平方根是否含能被整除即可
 */
public class PrimePalindrome {
    public int primePalindrome(int N) {



        return 1;
    }
    //判断回文数
    public static boolean isPalindrome(int x){
        String temp1=String.valueOf(x);
        String temp= new StringBuilder(temp1).reverse().toString();
        if(temp.equals(temp1) && temp.length()%2!=0){ //奇数位才可以
            return true;

        }else {
            return false;
        }
    }
    //判断素数
    public static boolean isPrime(int x){
        boolean booler=true;

        if(x<=2) return false;
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0){
                booler=false;
                break;
            }
        }
        return booler;
    }


}
