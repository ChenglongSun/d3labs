class Solution {
    public int getSum(int a, int b) {
        if (b == 0) return a;
        int sum, carry;
        sum = a ^ b;
        carry = (a & b) << 1;//&对应位置都是1的时候显示1，实现carry，然后左移一位实现进位
        return getSum(sum, carry);
    }
}
