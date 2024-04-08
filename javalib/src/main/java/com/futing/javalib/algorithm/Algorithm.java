package com.futing.javalib.algorithm;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import jdk.internal.net.http.common.Log;

public class Algorithm {

    public static void main(String[] args) {
        //3无重复字符串的最长子串

//        System.out.println(lengthOfLongestSubstring("abcabcbb") + "");
        System.out.println(lengthOfLongestSubstring("aabaab!b") + "");
        System.out.println(convert("PAYPALISHIRING", 3) + "");
        System.out.println(convert("AB", 1) + "");
//        System.out.println(convert("PAYPALISHIRING",3).length() + "");
//        System.out.println("PAHNAPLSIIGYIR".length() + "");
//        System.out.println(convert("PAYPALISHIRING",3).equals("PAHNAPLSIIGYIR") + "");


    }

    /**
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
        int val;
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
