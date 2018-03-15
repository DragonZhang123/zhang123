package Algorithm;

/**
 * Created by zhangguanlong on 2017/12/11.
 * 辗转相除法（欧几里得算法）
 */
public class EuclideanAlgorithm {
    /**
     * 传两个数求最大公因数
     * @param m
     * @param n
     * @return
     */
    public static long gcd(long m,long n){
        //连续计算余数，直到为零
        while (n!=0){
        long remainder = m%n;
            System.out.println("余数："+remainder);
        m=n;
        n=remainder;
        }
        return 0l;
    }

    public static void main(String[] args) {
        gcd(1989,1590);
    }
}
