package com.futing.javalib.algorithm;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Algorithm {

    public static void main(String[] args) {
        //3无重复字符串的最长子串

//        System.out.println(lengthOfLongestSubstring("abcabcbb") + "");
//        System.out.println(lengthOfLongestSubstring("aabaab!b") + "");
//        System.out.println(convert("PAYPALISHIRING", 3) + "");
//        System.out.println(convert("AB", 1) + "");
//        System.out.println(convert("PAYPALISHIRING",3).length() + "");
//        System.out.println("PAHNAPLSIIGYIR".length() + "");
//        System.out.println(convert("PAYPALISHIRING",3).equals("PAHNAPLSIIGYIR") + "");

        String s = "0";
        char c = s.charAt(0);
//        System.out.println(c == '0');
//        System.out.println(c == 0);

//        System.out.println(isPalindrome(21120));
        System.out.println(isMatch("mississippi", "mis*is*p*."));


//        intToRoman()
        intCa();

    }

    private static void intCa() {
        //取模问题
        System.out.println(3999 % 1000);
        System.out.println(3999 / 1000);

        System.out.println(999 % 500);
        System.out.println(999 / 500);
    }

    /**
     * //无法解出来，看了题解的思路；
     * 12. 整数转罗马数字
     *
     * @see <a href="https://leetcode.cn/problems/integer-to-roman/"></a>
     * 2024/04/22
     */
    public String intToRoman(int num) {
        if (num <= 0 || num >= 4000) {
            return "I";
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }


    /**
     * 看了题解，瞄了思路,未认真看代码；
     * 11.盛最多水的容器
     *
     * @see <a href="https://leetcode.cn/problems/container-with-most-water/description/"></a>
     */

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int result = 0;
        while (l < r) {
            int curHeight = Math.min(height[l], height[r]);
            int curWidth = r - l;
            result = Math.max(curWidth * curHeight, result);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }


    /**
     * 11.盛最多水的容器
     *
     * @see <a href="https://leetcode.cn/problems/container-with-most-water/description/"></a>
     * 第一步：超出时间限制 ； （未处理）
     */
    //自己调试
    public int maxArea1(int[] height) {
        int result = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = Math.min(height[i], height[j]) * (j - i);
                result = Math.max(result, temp);
            }
        }
        return result;
    }

    /**
     * 10.正则表达式匹配
     *
     * @param s
     * @param p '.' 匹配任意单个字符
     *          '*' 匹配零个或多个前面的那一个元素
     *          <p>
     *          第一次提交 "aab"  "c*a*b" true 我是false
     *          第一次提交 "mississippi" "mis*is*p*."  是false 我true
     * @return
     * @see <a href="https://leetcode.cn/problems/regular-expression-matching/"></a>
     * <p>
     * 比较难 放弃了
     */
    //自己调试实现
    public static boolean isMatch(String s, String p) {
        int pIndex = 0;
        char preCharOfS = '0';
        boolean anyPre = false;
        boolean xPre = false;
        int i;
        for (i = 0; i < s.length(); i++) {
            char curCharOfS = s.charAt(i);
            char curCharOfP = ' ';
            if (pIndex < p.length()) {
                curCharOfP = p.charAt(pIndex);
                pIndex++;
            }

            if (curCharOfP == '*') {
                anyPre = true;
                preCharOfS = curCharOfS;
            }

            if (curCharOfP == '.') {
                xPre = true;
                continue;
            }

            if (curCharOfS == curCharOfP) {
                preCharOfS = curCharOfS;
                continue;
            }


            if (anyPre && (xPre || curCharOfS == preCharOfS)) {
                continue;
            }

            if (pIndex < p.length()) {
                i = 0;
                continue;
            }

            break;

        }

        return i == s.length();
    }

    /**
     * 无限接近题解，所以没有看题解了
     * 9. 回文数
     * 进阶：你能不将整数转为字符串来解决这个问题吗？
     * 第一次：10测试用例未通过
     * 第一次：101测试用例未通过
     * 第一次：21120测试用例未通过
     *
     * @see <a href="https://leetcode.cn/problems/palindrome-number/"></a>
     */

    public static boolean isPalindrome(int x) {
        int x2 = 0;
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        while (x2 < x && x >= 10) {
            int num = x % 10;
            x2 = x2 * 10 + num;
            if (x2 != x) {
                x = x / 10;
            }
            if (x2 == 0) {
                break;
            }
        }
        return x2 == x;
    }

    /**
     * 9. 回文数
     *
     * @see <a href="https://leetcode.cn/problems/palindrome-number/"></a>
     */

    //自己实现的
    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        int end = s.length();
        boolean result = true;
        for (int start = 0; start <= s.length() / 2; start++) {
            end--;
            if (s.charAt(start) != s.charAt(end)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public int getStateIndex(char cur) {
        if (cur == ' ') {
            return 0;
        }
        if (cur == '-' || cur == '+') {
            return 1;
        }

        if (Character.isDigit(cur)) {
            return 2;
        }
        return 3;
    }

    /**
     * 8. 字符串转换整数 (atoi)
     *
     * @see <a href="https://leetcode.cn/problems/string-to-integer-atoi/"></a>
     * 第一遍：提交测试用例："words and 987" 未通过
     * 第二遍："+-12"
     * 第三遍："+20000000000000000000" 未通过
     * 第四遍："  0000000000012345678"未通过
     * @see <a href></a>
     */
    public int myAtoi(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            String curStr = result.toString();

            if (curStr.length() > 11) {
                break;
            }

            if (!Character.isDigit(curChar) && curStr.length() >= 2) {
                break;
            }


            if (curStr.length() == 0 && curChar != ' ' && curChar != '+' && curChar != '-' && !Character.isDigit(curChar)) {
                break;
            }

            if (curStr.length() == 1 && !Character.isDigit(curChar)) {
                break;
            }

            if (curChar == '-' && curStr.length() == 0) {
                result.append(curChar);
            }
            if ((Character.isDigit(curChar) || curChar == '+') && curStr.length() == 0) {
                result.append("+");
            }

            curStr = result.toString();
            System.out.println("len：" + curStr.length());
            System.out.println(curChar);
            System.out.println(curChar == 0);
            if (curStr.length() == 1 && curChar == '0') {
                System.out.println("y");
                continue;
            }
            System.out.println("z");
            if (Character.isDigit(curChar)) {
                result.append(curChar);
            }
        }

        if (result.toString().length() <= 1) {
            return 0;
        }


        long resultL = Long.parseLong(result.toString());

        if (resultL > Integer.MAX_VALUE) {
            resultL = Integer.MAX_VALUE;
        }

        if (resultL < Integer.MIN_VALUE) {
            resultL = Integer.MIN_VALUE;
        }

        return (int) resultL;
    }

    /**
     * 题解
     *
     * @param x
     * @return 2024/04/09
     */
    //题解
    public int reverse1(int x) {
        if (x < 10 && x > -10) {
            return x;
        }

        int reverseVal = 0;
        while (x != 0) {
            if (reverseVal > Integer.MAX_VALUE / 10 || reverseVal < -Integer.MAX_VALUE / 10) {
                return 0;
            }
            int num = x % 10;
            x = x / 10;
            reverseVal = reverseVal * 10 + num;
        }
        return reverseVal;
    }

    /**
     * 自己做的笨方法
     *
     * @see <a href="https://leetcode.cn/problems/reverse-integer/description/"></a>
     * 2024/04/09
     */

    public int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }

        String s = x + "";
        StringBuilder builder = new StringBuilder();
        if (x < 0) {
            builder.append("-");
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0' && (builder.toString().equals("-") || builder.length() <= 0)) {
                continue;
            }

            if (i == 0 && c == '-') {
                break;
            }
            builder.append(c);
        }
        int resultNum = 0;

        try {
            resultNum = Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return resultNum;

    }

    /**
     * todo：未处理完
     * 参照题解：方法一：利用二维矩阵模拟
     * 没处理完
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        int length = s.length();
        if (length <= 1 || numRows <= 1) {
            return s;
        }

        //列不知道多少行才好
        char[][] dp = new char[numRows][s.length()];
        int col = 0;
        boolean inc = true;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[row][col] = s.charAt(i);
            if (row == 0) {
                inc = true;
            }
            System.out.println(lengthOfLongestSubstring("aabaab!b") + "");


            if (row >= numRows - 1) {
                inc = false;
            }


            if (inc) {
                row++;
            } else {
                row--;
                col++;
            }
        }

        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j] != 0) {
                    resultStr.append(dp[i][j]);
                }
            }

        }
        return resultStr.toString();
    }

    /**
     * 6. Z 字形变换
     *
     * @param s       自己调试出来的
     * @param numRows
     * @return 提交时，没通过的测试用例 convert("AB", 1) Index -1 out of bounds for length 1
     * + row = Math.max(row, 0); row = Math.min(row, numRows - 1);
     * @see <a href="https://leetcode.cn/problems/zigzag-conversion/description/"></a>
     */
    //未看题解 自己调试出来的
    public static String convert(String s, int numRows) {
        //列不知道多少行才好
        char[][] dp = new char[numRows][s.length()];
        int col = 0;
        boolean inc = true;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[row][col] = s.charAt(i);
            if (row == 0) {
                inc = true;
            }

            if (row >= numRows - 1) {
                inc = false;
            }


            if (inc) {
                row++;
            } else {
                row--;
                col++;
            }

            row = Math.max(row, 0);
            row = Math.min(row, numRows - 1);

        }

        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j] != 0) {
                    resultStr.append(dp[i][j]);
                }
            }

        }
        return resultStr.toString();
    }

    /**
     * 5. 最长回文子串
     * https://leetcode.cn/problems/longest-palindromic-substring/description/
     *
     * @param s
     * @return (无法做出来 ， 参照官方题解动态规划想了很久才理解 。 还去看了
     * @see <a href="https://mp.weixin.qq.com/s/3h9iqU4rdH3EIy5m6AzXsg">动态规划小灰</a>
     * -)
     * 2024/04/08
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        if (s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int maxLength = 1;
        int begin = 0;
        for (int L = 2; L <= s.length(); L++) {
            for (int l = 0; l < s.length(); l++) {
                //r 右边index 没写对
                int r = L + l - 1;
                if (r >= s.length()) {
                    break;
                }

                if (chars[l] != chars[r]) {
                    dp[l][r] = false;
                } else {
                    if (r - l < 3) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }


                if (dp[l][r] && r - l + 1 > maxLength) {
                    maxLength = r - l + 1;
                    begin = l;
                }
            }
        }

        return s.substring(begin, begin + maxLength);
    }


    /**
     * 解法2：双指针+HashSet
     * 2024/04/05
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }

        int maxLength = 0;
        HashSet<Character> hashSet = new HashSet<>();
        int slowP = 0;
        int fastP = 0;
        while (fastP < s.length()) {
            if (hashSet.contains(s.charAt(fastP))) {
                maxLength = Math.max(maxLength, fastP - slowP);
                hashSet.remove(s.charAt(slowP));
                slowP++;
            } else {
                hashSet.add(s.charAt(fastP));
                fastP++;
            }
        }
        maxLength = Math.max(maxLength, fastP - slowP);
        return maxLength;
    }

    /**
     * 3无重复字符串的最长子串
     *
     * @param s
     * @return
     * @see <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3无重复字符串的最长子串</a>
     * <p>
     * 自己做出来了，未对答案，看代码，但是调试了很多次，有些地方考虑的不周全；
     * 2024/04/04
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            int replaceIndex = stringBuilder.indexOf(charAt + "");
            if (replaceIndex != -1) {
                //一开始没有考虑到的点：
                //1、 删掉了，要加上stringBuilder.append(charAt);
                //2、以及删掉范围是写的是0，replaceIndex ；应该是0，replaceIndex+1；
                stringBuilder.delete(0, replaceIndex + 1);
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append(charAt);
                int length = stringBuilder.length();
                maxLength = Math.max(length, maxLength);
            }
        }

        return maxLength;
    }


    //     Definition for singly-linked list.
    public class ListNode {
        int      val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //2.两数相加
    //https://leetcode.cn/problems/add-two-numbers/discussion/

    /**
     * 2->4>3
     * 5>6>4
     * <p>
     * 7->0>8
     * <p>
     * 342+465 =807
     * 自己实现的，未看答案；
     *
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headerNode = new ListNode();
        ListNode resultNode = headerNode;

        int inc = 0;
        while (l1 != null || l2 != null) {

            int val1 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            int val2 = 0;
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int addResult = val1 + val2 + inc;
            inc = 0;
            if (addResult >= 10) {
                addResult = addResult - 10;
                inc = 1;
            }
            if (resultNode.next != null) {
                resultNode = resultNode.next;
            }
            resultNode.val = addResult;
            resultNode.next = new ListNode();
        }
        if (inc == 1) {
            resultNode = resultNode.next;
            resultNode.val = inc;
        } else {
            resultNode.next = null;
        }
        return headerNode;
    }

    //1、两数之和 [2,7,11,15]
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> findHaspMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (findHaspMap.containsKey(temp)) {
                return new int[]{findHaspMap.get(temp), i};
            }
            findHaspMap.put(nums[i], i);

        }

        return new int[0];
    }


    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
    }


    //
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int len = 1, n = nums.length;
            if (n == 0) {
                return 0;
            }
            int[] d = new int[n + 1];
            d[len] = nums[0];
            for (int i = 1; i < n; ++i) {
                if (nums[i] > d[len]) {
                    d[++len] = nums[i];
                } else {
                    int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                    while (l <= r) {
                        int mid = (l + r) >> 1;
                        if (d[mid] < nums[i]) {
                            pos = mid;
                            l = mid + 1;
                        } else {
                            r = mid - 1;
                        }
                    }
                    d[pos + 1] = nums[i];
                }
            }
            return len;
        }
    }

}
