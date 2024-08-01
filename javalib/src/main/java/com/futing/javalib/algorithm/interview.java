package com.futing.javalib.algorithm;

/**
 * Created by futing on 2024/7/31.
 */
public class interview {

    public static void main(String[] args) {
        //序号1
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
    //腾娱面试题：二面 2024/07/31

    /**
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/
     *     //参考题解才做出来
     */

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNode = new ListNode(0, head);
        ListNode cur = listNode;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return listNode.next;
    }
    //腾娱面试题：一面 2024/07/30

    /**
     * 序号1
     * LCR 008. 长度最小的子数组
     *
     * @param target
     * @param nums
     * @return //参考题解滑动窗口
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int start = 0, end = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        while (end < length) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
