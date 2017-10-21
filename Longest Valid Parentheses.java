class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            if (x == '(') stack.push(i);
            else {
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                }
                else stack.push(i);
            }
        }
        if (stack.isEmpty()) ans = n;
        else {
            int a = n, b = 0;
            while (!stack.isEmpty()) {
                b = stack.pop();
                ans = Math.max(ans, a - b - 1);
                a = b;
            }
            ans = Math.max(ans, a);
        }
        return ans;
    }
}