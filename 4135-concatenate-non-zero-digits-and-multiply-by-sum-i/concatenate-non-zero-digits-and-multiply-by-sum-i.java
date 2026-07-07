class Solution {
    public long sumAndMultiply(long n) {
        long sum=0;
        long temp =0;
        while(n != 0){
            long rev = n % 10;
            if(rev != 0){
                temp = temp * 10 + rev;
            }
            sum += rev;
            n /=10;

        }
        while(temp != 0){
            long rev = temp % 10;
            n = n * 10 + rev;
            temp /= 10;
        }
        return n * sum;
    }
}