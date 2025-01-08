package com.futing.javalib.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Algorithm {

    public static void main(String[] args) {
        //18. 四数之和
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));

        //15.三数之和 //[-1,2,1,-4]
//        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
//        System.out.println(threeSum(new int[]{0, 0, 0}));


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
//        System.out.println(isMatch("mississippi", "mis*is*p*."));


//        intToRoman()
//        intCa();
//        romanToInt1("MCMXCIV");
        isValid("()");

        countAndSay(2);

        System.out.println(uniquePaths1(3, 2));
//        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("100", "110010"));
        System.out.println(new int[]{0, 1});
    }
    // TODO: 2024/8/17 二维数组要紧急 在二维数组中，直接使用 length 属性获取的是数组的行数，在指定的索引后加上 length（如 array[0].length）表示的是该行拥有多少个元素，即列数。

    /**
     * 96. 不同的二叉搜索树
     *https://leetcode.cn/problems/unique-binary-search-trees/
     *2025/01/07
     */
//    public int numTrees(int n) {
//
//    }



    /**
     * 95. 不同的二叉搜索树 II
     * https://leetcode.cn/problems/unique-binary-search-trees-ii/description/
     * 2025/01/06 题目都看不懂呀（原因不理解二叉搜索树）
     * 二叉搜索树 ：：根节点值大于左子节点的所有值；
     */

    //直接看的题解
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode currtree = new TreeNode(i);
                    currtree.left = leftTree;
                    currtree.right = rightTree;
                    allTrees.add(currtree);
                }
            }

        }
        return allTrees;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 94. 二叉树的中序遍历 (左根右)
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/
     * 2025/01/04 写了一会就参看题解了；
     */
    List<Integer> resultList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        //递归
        dfs3(root, resultList);
        return resultList;
    }

    private void dfs3(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return;
        }

        dfs3(root.left, resultList);
        resultList.add(root.val);
        dfs3(root.right, resultList);
    }

    /**
     * 93. 复原 IP 地址
     * https://leetcode.cn/problems/restore-ip-addresses/
     * 2024/12/31 时隔一个半月了’
     */
    static final int SEG_COUNT = 4;
    List<String> ans1 = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs1(s, 0, 0);
        return ans1;
    }

    private void dfs1(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append(".");
                    }
                }
                ans1.add(ipAddr.toString());
            }
            return;
        }

        if (segStart == s.length()) {
            return;
        }

        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs1(s, segId + 1, segStart + 1);
            return;
        }
        int addr = 0;
        for (int segend = segStart; segend < s.length(); ++segend) {
            addr = addr * 10 + (s.charAt(segend) - '0');
            if (addr > 0 && addr <= 0XFF) {
                segments[segId] = addr;
                dfs1(s, segId + 1, segend + 1);
            } else {
                break;
            }
        }
    }

    /**
     * 92. 反转链表 II
     * https://leetcode.cn/problems/reverse-linked-list-ii/
     * 2024/11/16  27min 接近，但发现自己题目都没有看懂
     */
    //题解
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    //接近，但发现自己题目都没有看懂
    public ListNode reverseBetween1(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode node = new ListNode(Integer.MAX_VALUE, head);
        ListNode curNode = node.next;
        ListNode preLeftNode = node;
        ListNode preRightNode = node;
        ListNode preNode = node;
        int index = 1;
        while (curNode != null) {
            if (index == left) {
                preLeftNode = preNode;
            }
            if (index == right) {
                preRightNode = preNode;
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
            index++;
        }

        ListNode leftNode = preLeftNode.next;
        ListNode rightNode = preRightNode.next;
        ListNode rightNext = null;

        if (rightNode != null) {
            rightNext = rightNode.next;
        }

        preLeftNode.next = rightNode;

        if (rightNode != null) {
            if (right - left == 1) {
                rightNode.next = leftNode;
            } else {
                rightNode.next = leftNode == null ? null : leftNode.next;
            }

        }

        preRightNode.next = leftNode;
        if (leftNode != null) {
            leftNode.next = rightNext;
        }

        return node.next;
    }

    /**
     * 91. 解码方法
     * https://leetcode.cn/problems/decode-ways/description/
     * 2024/9/19 没什么想法-》直接看的题解【动态规划】 =》还是看不懂哦 15min
     */
    public int numDecodings(String s) {
        int n = s.length();
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }

            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }

            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 90. 子集 II
     * https://leetcode.cn/problems/subsets-ii/description/
     * 2024/9/19 补14 ---->想到递归-》但是做不出来-》看了题解还是不怎么理解 15min
     */
    ArrayList<List<Integer>> lists = new ArrayList<>();
    ArrayList<Integer> t = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfsLL(false, nums, 0);

        return lists;

    }

    private void dfsLL(boolean choosePre, int[] nums, int i) {
        if (i == nums.length) {
            lists.add(new ArrayList<Integer>(t));
            return;
        }

        dfsLL(false, nums, i + 1);
        if (!choosePre && i > 0 && nums[i - 1] == nums[i]) {
            return;
        }

        t.add(nums[i]);
        dfsLL(true, nums, i + 1);
        t.remove(t.size() - 1);
    }

    /**
     * 89. 格雷编码
     * https://leetcode.cn/problems/gray-code/
     * 2024/9/19 补13
     * 没思路 ->看了题解归纳法，看了也不懂哦 5min
     */

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ret.size();
            for (int j = m - 1; j >= 0; j--) {
                ret.add(ret.get(j) | (1 << (i - 1)));
            }
        }
        return ret;
    }

    /**
     * 87. 扰乱字符串 hard 跳过
     * 88. 合并两个有序数组
     * 2024/09/12
     * https://leetcode.cn/problems/merge-sorted-array/ 15min自己实现
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = n + m;

        int r = size - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (r >= 0) {
            if (index1 < 0) {
                nums1[r] = nums2[index2];
                index2--;
            } else if (index2 < 0) {
                nums1[r] = nums1[index1];
                index1--;
            } else if (nums1[index1] <= nums2[index2]) {
                nums1[r] = nums2[index2];
                index2--;
            } else {
                nums1[r] = nums1[index1];
                index1--;
            }
            r--;
        }
    }


    /**
     * 84. 柱状图中最大的矩形 hard 跳过
     * 85. 最大矩形  hard 跳过
     * 86. 分隔链表
     * 2024/09/12 补11号
     * hhttps://leetcode.cn/problems/partition-list/
     * 太难了，无思路。思考了8min直接看题解了， ——》模拟 15min
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode small1Head = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;

        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }

            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;

        return small1Head.next;

    }

    /**
     * 83. 删除排序链表中的重复元素
     * 2024/09/12 补10号
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
     * //自己数显6min
     */

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = new ListNode(Integer.MAX_VALUE, head);
        ListNode cur = listNode;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return listNode.next;

    }


    /**
     * 82. 删除排序链表中的重复元素 II
     * 2024/09/12 补9号
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/submissions/
     * 写过了还是写不出来，参考题解 8min
     */
    //写过了还是写不出来，参考题解
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = new ListNode(Integer.MAX_VALUE, head);
        ListNode cur = preNode;
        while (cur != null && cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }

        }
        return preNode.next;
    }


    /**
     * 81. 搜索旋转排序数组 II
     * 2024/09/12 补9号
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/
     * 自己实现了部分用例发现不通过，最后看了题解 40min
     */

    public boolean search1(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return nums[0] == target;
        }

//        想到的是采用二分法
        int l = 0;
        int r = n - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return false;
    }

    /**
     * 80. 删除有序数组中的重复项 II
     * 2024/09/08
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/
     */
    public int removeDuplicates3(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;

    }

    /**
     * 79. 单词搜索
     * https://leetcode.cn/problems/word-search/
     * 2024/09/08 补昨日
     * 直接坎坷题解； =》回溯
     */
//看了题解还是不太懂
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int cur) {
        if (board[i][j] != word.charAt(cur)) {
            return false;
        } else if (cur == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] direction : directions) {
            int newi = i + direction[0], newj = j + direction[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, word, cur + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    /**
     * 78. 子集
     * https://leetcode.cn/problems/subsets/description/
     * 2024/9/6 想到的也是递归 但是做不出来！ 看了题解（计时47min，但是根本没用到这个时间，大部分都是在玩手机呀）
     */
//    List<List<Integer>> ans = new ArrayList<>();
//    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfsC1(nums, 0);

        return ans;
    }

    private void dfsC1(int[] nums, int i) {
        if (nums.length == i) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        temp.add(nums[i]);
        dfsC1(nums, i + 1);
        temp.remove(temp.size() - 1);
        dfsC1(nums, i + 1);
    }


    /**
     * 76. 最小覆盖子串 hard 跳过
     * https://leetcode.cn/problems/combinations/description/
     * 2024/9/6 补9.5
     * 77. 组合  想到的是递归 做了十分钟做不出来看了题解 最终15min
     */

//    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfsC(1, n, k);
        return ans;
    }

    private void dfsC(int cur, int n, int k) {
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }


        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(cur);

        dfsC(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        dfsC(cur + 1, n, k);
    }

    /**
     * 75. 颜色分类
     * https://leetcode.cn/problems/sort-colors/
     * 2024/9/4 //题解版本 觉得写自己写的太复杂了！ 优化了自己代码未非题解  17min
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        int l = 0, slowL = 0, r = n - 1;
        while (l < r || (l <= r && nums[l] != 2)) {
            if (nums[l] == 1) {
                l++;
                continue;
            }

            if (nums[l] == 0) {
                if (l != slowL) {
                    nums[l] = 1;
                    nums[slowL] = 0;
                }
                l++;
                slowL++;
            } else if (nums[l] == 2) {
                while (nums[r] == 2 && l < r) {
                    r--;
                }
                if (l < r) {
                    nums[l] = nums[r];
                    nums[r] = 2;
                    r--;
                }
            }
        }

    }

    /**
     * 75. 颜色分类
     * https://leetcode.cn/problems/sort-colors/
     * 2024/9/4 //未看题解 32min 有个测试用例没有通过-》41又调试了会
     */
    public void sortColors1(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        int l = 0, lFast = 0, r = n - 1;
        while (l < r) {
            if (nums[l] == 0) {
                l++;
                continue;
            }

            if (nums[l] == 1) {
                if (lFast <= l) {
                    lFast = l + 1;
                }
                while (lFast <= r && nums[lFast] != 0) {
                    lFast++;
                }
                if (lFast <= r) {
                    nums[l] = 0;
                    nums[lFast] = 1;
                }
                l++;
                continue;

            }

            if (nums[l] == 2) {
                while (nums[r] == 2 && l < r) {
                    r--;
                }
                if (l < r) {
                    nums[l] = nums[r];
                    nums[r] = 2;
                    r--;
                }
            }
        }

    }


    /**
     * 74. 搜索二维矩阵
     * https://leetcode.cn/problems/search-a-2d-matrix/
     * 2024/9/3 5min未看题解-》提交了 ；  看了题解可以使用二分查找，但是我自己未做出来了；
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n < 1) {
            return false;
        }
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (target > matrix[i][m - 1]) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }

        }

        return false;
    }

    /**
     * 73. 矩阵置零
     * https://leetcode.cn/problems/set-matrix-zeroes/description/
     * 2024/09/02 未看题解自己实现 16min
     */

//未看题解自己实现
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        if (n < 1) {
            return;
        }
        int m = matrix[0].length;

        int[] rows = new int[n];
        int[] columns = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] == 1 || columns[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

// TODO: 2024/9/2 k看了题解发现下面可以优化成一个for循环

//        for (int i = 0; i < n; i++) {
//            if (rows[i] == 1) {
//                for (int j = 0; j < m; j++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//        for (int j = 0; j < m; j++) {
//            if (columns[j] == 1) {
//                for (int k = 0; k < n; k++) {
//                    matrix[k][j] = 0;
//                }
//            }
//        }


    /**
     * 72. 编辑距离
     * https://leetcode.cn/problems/edit-distance/
     * 2024/09/02 补昨日 20min
     */

//直接看了题解都无法理解的题
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (n * m == 0) {
            return n + m;
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }

                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }

        }
        return dp[n][m];
    }

    /**
     * 71. 简化路径
     * https://leetcode.cn/problems/simplify-path/description/
     * 2024/08/31 //看了题解 5min
     */
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!name.isEmpty() && !".".equals(name)) {
                stack.offerLast(name);
            }
        }

        StringBuilder ans = new StringBuilder();
        if (stack.isEmpty()) {
            ans.append("/");
        } else {
            while (!stack.isEmpty()) {
                ans.append("/");
                ans.append(stack.pollFirst());
            }
        }

        return ans.toString();
    }


    /**
     * 70. 爬楼梯
     * https://leetcode.cn/problems/climbing-stairs/
     * 2024/08/30 //看了题解 5min
     */
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * 68. 文本左右对齐 hard 跳过
     * 69. x 的平方根 easy
     * https://leetcode.cn/problems/sqrtx/
     * 2024/08/29
     * 好吧想是想不出来了，直接看题解了；二分查找 8m,in
     */
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


    /**
     * 67. 二进制求和
     * https://leetcode.cn/problems/add-binary/description/
     * 2024/08/28
     * 看题解 自己简化  q其实和官方模拟法差别不大，但是我逻辑判断 比较复杂， 改进点：关键点 逢2进1
     * 10min
     */

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int n = a.length() - 1;
        int m = b.length() - 1;

        int mod = 0;
        while (n >= 0 || m >= 0) {

            int aI = n >= 0 ? a.charAt(n) - '0' : 0;
            int bI = m >= 0 ? b.charAt(m) - '0' : 0;
            int temp = aI + bI + mod;
            ans.append(temp % 2);
            mod = temp / 2;
            n--;
            m--;
        }

        if (mod == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }

    /**
     * 67. 二进制求和
     * https://leetcode.cn/problems/add-binary/description/
     * 2024/08/28
     * 未看题解 62min 看似很简单，做起来真麻烦！！
     */
    public static String addBinary1(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int n = a.length() - 1;
        int m = b.length() - 1;

        int mod = 0;
        while (n >= 0 && m >= 0) {
            int aI = a.charAt(n) - '0';
            int bI = b.charAt(m) - '0';

            if (mod == 1 && aI == 1 && bI == 1) {
                mod = 1;
                ans.append(1);
            } else {
                int temp = aI ^ bI;
                if (mod == 1) {
                    temp = temp ^ mod;
                }
                ans.append(temp);
                if ((aI == 1 && bI == 1) || (mod == 1 && temp == 0)) {
                    mod = 1;
                } else {
                    mod = 0;
                }
            }
            n--;
            m--;
//            int cur = aC ^ bC;
        }
        String substring = null;
        if (n >= 0) {
            substring = a.substring(0, n + 1);
        }
        if (m >= 0) {
            substring = b.substring(0, m + 1);
        }


        if (substring != null) {
            int len = substring.length() - 1;
            while (len >= 0) {
                int temp = substring.charAt(len) - '0';
                int ansTemp = temp ^ mod;
                ans.append(ansTemp);
                if (temp == 1 && mod == 1) {
                    mod = 1;
                } else {
                    mod = 0;
                }
                len--;
            }
        }


        if (mod == 1) {
            ans.append(1);
        }

        StringBuilder str = new StringBuilder();
        for (int i = ans.length() - 1; i >= 0; i--) {
            str.append(ans.charAt(i));
        }
        return str.toString();
//        return ans.toString();
    }


    /**
     * 65. 有效数字 hard 跳过
     * 66. 加一 easy
     * https://leetcode.cn/problems/plus-one/
     * 2024/08/27
     * 未看题解 14min
     */

//自己实现
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int mod = 0;
        digits[n - 1] = digits[n - 1] + 1;
        for (int i = n - 1; i >= 0; i--) {
            int temp = digits[i] + mod;

            if (temp < 10) {
                digits[i] = temp;
                mod = 0;
                break;
            }
            digits[i] = temp % 10;
            mod = 1;
        }

        if (mod == 0) {
            return digits;
        }
        // TODO: 2024/8/27 最后mod大于1 也就是原数组已经装不下它了怎么办；

        // TODO: 2024/8/27  看了题解发现这里需要优化
        // digits 中所有的元素均为 9
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
//
//        int[] ans = new int[n + 1];
//        ans[0] = mod;
//        for (int i = 1; i <= n; i++) {
//            ans[i] = digits[i - 1];
//        }
//        return ans;

    }

    /**
     * 64. 最小路径和
     * https://leetcode.cn/problems/minimum-path-sum/description/
     * 2024/08/26
     * 看题目是一点思路都没有啊：只能想到动态规划
     * 看了题解：动态规划
     * 19min
     */

//看了题解：动态规划
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;

        }
        int row = grid.length;
        int columns = grid[0].length;

        int[][] dp = new int[row][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < columns; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }


        for (int i = 1; i < row; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }

        }

        return dp[row - 1][columns - 1];
    }

    /**
     * 63. 不同路径 II
     * https://leetcode.cn/problems/unique-paths-ii/
     * 2024/08/25
     * 看题目是一点思路都没有啊：：
     * 看了题解：动态规划
     * 滚动数组好难理解呀！！ 47 min
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] f = new int[m];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }


    /**
     * 62. 不同路径
     * https://leetcode.cn/problems/unique-paths/description/
     * 2024/08/24
     * 看题解：：
     * 竟然有的动态规划，或者组合法；
     * 这里我看动态规划把！！  12min
     */

    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }


    /**
     * 62. 不同路径
     * https://leetcode.cn/problems/unique-paths/description/
     * 2024/08/24
     * 看到这题，我就知道要采用递归，但是我不会呀！！！！！！！尝试下把！！！
     * 尝试是写出来了，但没有通过所有答案，超时了  20min
     */

    public static int sum = 0;

    public static int uniquePaths1(int m, int n) {
        dfsUniquePaths(0, 0, m, n);
        return sum;
    }

    private static void dfsUniquePaths(int row, int column, int m, int n) {

        if (row == m - 1 && column == n - 1) {
            sum++;
            System.out.println(sum);
            return;
        }
        if (row <= m - 1) {
            dfsUniquePaths(row + 1, column, m, n);

        }
        if (column <= n - 1) {
            dfsUniquePaths(row, column + 1, m, n);
        }
    }

    /**
     * 60. 排列序列 hard 跳过
     * 61. 旋转链表
     * https://leetcode.cn/problems/rotate-list/
     * 2024/08/23
     * //24min 未看题解 24min +含调试事件是34
     * <p>
     * 看了题解思路比我优秀很多的啊
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        ListNode edn = head;
        // TODO: 2024/8/23 改进dian
        int n = 0;
        while (temp != null) {
            edn = temp;
            temp = temp.next;
            n++;
        }


        // TODO: 2024/8/23  改进点
        while (k > n) {
            k = k - n;
        }

        if (k == n || n == 1) {
            return head;
        }

        int ednN = n - k;

        // TODO: 2024/8/23 改进点
        ListNode ansHead = head;
        while (ednN > 0 && ansHead != null) {
            ednN--;
            temp = ansHead;
            ansHead = ansHead.next;
        }

        edn.next = head;
        if (temp != null) {
            temp.next = null;
        }
        return ansHead;
    }

    /**
     * 59. 螺旋矩阵 II
     * https://leetcode.cn/problems/spiral-matrix-ii/description/
     * 2024/08/22
     * //8min 看了题解2.模拟用法
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, top = 0, bottom = n - 1, right = n - 1;

        int num = 1;

        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                ans[top][column] = num;
                num++;
            }

            for (int row = top + 1; row <= bottom; row++) {
                ans[row][right] = num;
                num++;
            }

            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    ans[bottom][column] = num;
                    num++;
                }

                for (int row = bottom; row > top; row--) {
                    ans[row][left] = num;
                    num++;

                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }

        return ans;
    }

    /**
     * 59. 螺旋矩阵 II
     * https://leetcode.cn/problems/spiral-matrix-ii/description/
     * 2024/08/22
     * //25min 要用模拟但是写不出来
     */
//    模拟
    public int[][] generateMatrix1(int n) {
        int[][] ans = new int[n][n];
        int left = 0, top = 0, bottom = n - 1, right = n - 1;
        int num = 1;
        for (int i = 0; i < ans.length; i++) {
            left = i;
            for (int j = i; j <= right; j++) {
                ans[i][i] = num;
                num++;
            }

            top = top + 1;
            for (int k = top; k <= bottom; k++) {
                ans[right][k] = num;
                num++;
            }

            right = right - 1;
            for (int r = right; r >= left; r--) {
                ans[bottom][right] = num;
                num++;
            }

            bottom = bottom - 1;
            for (int l = bottom; l >= top; l--) {
                ans[bottom][left] = num;
                num++;

            }

        }
        return ans;
    }

    /**
     * 58. 最后一个单词的长度
     * https://leetcode.cn/problems/length-of-last-word/
     * 2024/08/22 周四 补周三
     * //看错题解，是最后一个 单词的长度。  不是最长的。
     */
    public int lengthOfLastWord(String s) {
        int maxLen = 0, len = s.length();

        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ' && maxLen == 0) {
                continue;
            }
            if (c == ' ') {
                break;
            }

            maxLen++;
        }

        return maxLen;
    }

    /**
     * 57. 插入区间
     * https://leetcode.cn/problems/insert-interval/description/
     * 2024/08/20 周二
     * //看了题解，逻辑比较清晰；方法一：模拟
     */
//    看了题解，逻辑比较清晰；方法一：模拟
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newL = newInterval[0];
        int newR = newInterval[1];
        boolean addEnd = true;
        List<int[]> ansList = new ArrayList<int[]>();

        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (L > newR) {
                //插入的素组的右边边和当前对比的元素无交集
                //第一个
                if (addEnd) {
                    ansList.add(new int[]{newL, newR});
                    addEnd = false;
                }
                ansList.add(interval);
            } else if (R < newL) {
                //插入的素组的左边和当前对比的元素无交集
                ansList.add(interval);
            } else {
//                有交集,算出并集
                newL = Math.min(L, newL);
                newR = Math.max(R, newR);
            }
        }

        if (addEnd) {
            ansList.add(new int[]{newL, newR});
        }

        int[][] ans = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }

    /**
     * 57. 插入区间
     * https://leetcode.cn/problems/insert-interval/description/
     * 2024/08/20 周二
     * //参照上一题加调试
     */
//参照上一题加调试
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        int newL = newInterval[0];
        int newR = newInterval[1];
        ArrayList<int[]> merged = new ArrayList<>();

        boolean addEnd = true;
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (!addEnd) {
                if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(new int[]{L, R});
                } else {
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
                continue;
            }

            //在左侧无交集 这里看了题解才做的出来
            if (L > newR && addEnd) {
                addEnd = false;
                merged.add(new int[]{newL, newR});
                merged.add(interval);
                continue;
            }

            if (newL <= R && addEnd) {
                addEnd = false;
                newL = Math.min(newL, L);
                newR = Math.max(newR, R);
                merged.add(new int[]{newL, newR});
            } else {
                merged.add(interval);
            }
        }
        if (addEnd) {
            merged.add(newInterval);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 56. 合并区间
     * https://leetcode.cn/problems/merge-intervals/
     * 2024/08/20 周二 补昨日
     * 做不出来,看了题解 排序
     */
//题解
    public int[][] merge(final int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });

        ArrayList<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }

        }

        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 55. 跳跃游戏
     * https://leetcode.cn/problems/jump-game/
     * 2024/08/18 周天
     * 做不出来,看了题解 贪心算法
     */
//题解
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 54. 螺旋矩阵
     * https://leetcode.cn/problems/spiral-matrix/
     * 2024/08/17 周六
     * 做不出来,看了题解二 按层模拟
     */
//参看 题解
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int clounm = left; clounm <= right; clounm++) {
                ans.add(matrix[top][clounm]);
            }

            for (int row = top + 1; row <= bottom; row++) {
                ans.add(matrix[row][right]);
            }

            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    ans.add(matrix[bottom][column]);
                }

                for (int row = bottom; row > top; row--) {
                    ans.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;

        }
        return ans;
    }

    /**
     * 51. N 皇后 hard 跳过
     * 52. N 皇后 II hard 跳过
     * 53. 最大子数组和
     * https://leetcode.cn/problems/maximum-subarray/solutions/228009/zui-da-zi-xu-he-by-leetcode-solution/
     * 2024/08/16 周五 补昨日
     * 参考了题解
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(pre, maxAns);
        }
        return maxAns;
    }

    /**
     * 50. Pow(x, n)
     * https://leetcode.cn/problems/powx-n/
     * 2024/08/16 周五 补昨日
     *
     * @param x
     * @param n
     * @return //参看题解
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    /**
     * 50. Pow(x, n)
     * https://leetcode.cn/problems/powx-n/
     * 2024/08/16 周五 补昨日
     *
     * @param x
     * @param n
     * @return //未看题解，超出时间限额 1,2147483647
     */
    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = Math.abs(n);
            x = 1 / x;
        }
        double sum = x;
        for (int i = 1; i < n; i++) {
            sum = sum * x;
        }
        return sum;
    }

    /**
     * 49. 字母异位词分组
     * https://leetcode.cn/problems/group-anagrams/description/
     * 2024/08/14 周三
     * 想到下面的思路了，但对于key排序有点不够清晰，所以看了题解的排序方法-
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = hashMap.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            hashMap.put(key, list);
        }

        return new ArrayList<List<String>>(hashMap.values());
    }

    /**
     * 48. 旋转图像
     * https://leetcode.cn/problems/rotate-image/
     * 2024/08/14 周三 补周二
     *
     * @param matrix 想了会做不出来看了官方题解二 方法二：原地旋转
     */

//想了会做不出来看了官方题解二 方法二：原地旋转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //行
        for (int i = 0; i < n / 2; i++) {
            //列
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    /**
     * 47. 全排列 II
     * https://leetcode.cn/problems/permutations-ii/
     * 2024/08/14 周三 补周一
     * 直接看了 题解，回溯方法
     */

    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack2(nums, ans, 0, perm);
        return ans;
    }

    private void backtrack2(int[] nums, List<List<Integer>> ans, int index, List<Integer> perm) {
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }

            perm.add(nums[i]);
            vis[i] = true;
            backtrack2(nums, ans, index + 1, perm);
            vis[i] = false;
            perm.remove(index);
        }
    }

    /**
     * 46. 全排列
     * https://leetcode.cn/problems/permutations/description/
     * 2024/08/11
     * 直接看了题解，回溯方法。
     */

//直接看了题解，回溯方法。
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> output = new ArrayList<>();

        for (int num : nums) {
            output.add(num);
        }

        backtracks(nums.length, output, ans, 0);

        return ans;
    }

    private void backtracks(int length, ArrayList<Integer> output, ArrayList<List<Integer>> ans, int index) {
        //所有数都填完了
        if (index == length) {
            ans.add(new ArrayList<Integer>(output));
        }

        for (int i = index; i < length; i++) {
            Collections.swap(output, index, i);
            backtracks(length, output, ans, index + 1);
            Collections.swap(output, i, index);
        }
    }

    /**
     * 44. 通配符匹配 hard 跳过
     * 45. 跳跃游戏 II
     * https://leetcode.cn/problems/jump-game-ii/
     * 2024/08/11 补昨日
     * 直接看了题解
     */

//直接看了题解
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 41. 缺失的第一个正数 hard 跳过
     * 42. 接雨水 hard 跳过
     * 43. 字符串相乘
     * https://leetcode.cn/problems/multiply-strings/
     * 2024/08/09
     * 看了题解的做乘法
     */
//看了题解的做乘法
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            //这一行是关键，没有这个知识点，就做不出来了
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }

        //这个思维很关键
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }


    /**
     * 40. 组合总和 II
     * https://leetcode.cn/problems/combination-sum-ii/
     * 2024/08/08
     * 太难了，直接看题解了
     * 但是还是看不懂
     * todo 就这样吧
     */


    List<int[]> freq = new ArrayList<int[]>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }

        dfs2(0, target);

        return ans;
    }

    private void dfs2(int pos, int reset) {
        if (reset == 0) {
            ans.add(new ArrayList<Integer>(sequence));
            return;
        }

        if (pos == freq.size() || reset < freq.get(pos)[0]) {
            return;
        }
        dfs2(pos + 1, reset);

        int most = Math.min(reset / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs2(pos + 1, reset - i * freq.get(pos)[0]);
        }

        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
    }


    /**
     * 39. 组合总和
     * https://leetcode.cn/problems/combination-sum/
     * 2024/08/07
     * 没什么思路，看题解了
     * 这类寻找所有可行解的题，我们都可以尝试用「搜索回溯」的方法
     * 真的很难理解回溯方法
     */
//参看题解
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> combine = new ArrayList<>();
        dfs(candidates, ans, combine, target, 0);


        return ans;
    }

    private void dfs(int[] candidates, List<List<Integer>> ans, ArrayList<Integer> combine, int target, int index) {
        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }

        dfs(candidates, ans, combine, target, index + 1);

        if (target - candidates[index] >= 0) {
            combine.add(candidates[index]);
            dfs(candidates, ans, combine, target - candidates[index], index);
            combine.remove(combine.size() - 1);
        }
    }


    /**
     * 37. 解数独 haed 跳过
     * 38. 外观数列
     * https://leetcode.cn/problems/count-and-say/
     * 2024/08/06
     * 先自己写了一般，又看了题解，因为一开始没有理解题解的意思，
     * countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。 这个条件要研读
     */

//先自己写了一般，又看了题解，因为一开始没有理解题解的意思，
    public static String countAndSay(int n) {
        String resultStr = "1";

        if (n == 1) {
            return resultStr;
        }

        for (int i = 1; i < n; i++) {
            int left = 0, right = resultStr.length();
            StringBuilder subStr = new StringBuilder();
            while (left < right) {
                int count = 1;
                int leftNext = left + 1;
                char curC = resultStr.charAt(left);
                while (leftNext < right && resultStr.charAt(leftNext) == curC) {
                    count++;
                    leftNext++;
                }
                left = leftNext;
                subStr.append(count).append(curC);
            }
            resultStr = subStr.toString();
        }

        return resultStr;
    }

    /**
     * 36. 有效的数独
     * https://leetcode.cn/problems/valid-sudoku/
     * * 2024/08/05
     * 做了一会做不出来，参看了题解
     */

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] boxNum = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    boxNum[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || boxNum[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    /**
     * 35. 搜索插入位置
     * https://leetcode.cn/problems/search-insert-position/
     * * 2024/08/04
     * 未看题解,自己实现
     * key：二分查找
     */

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
     * 2024/08/03
     * 未看题解
     */

//未看题解
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) {
            return result;
        }

        if (nums.length == 1 && nums[0] != target) {
            return result;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                result[0] = mid;
                result[1] = mid;
                int midleft = mid - 1, midRigth = mid + 1;
                while ((midleft >= left && nums[midleft] == target)) {
                    result[0] = midleft;
                    midleft--;
                }

                while ((midRigth <= right && nums[midRigth] == target)) {
                    result[1] = midRigth;
                    midRigth++;
                }

                return result;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return result;
    }

    /**
     * 32. 最长有效括号 hard 跳过
     * <p>
     * 33.搜索旋转排序数组
     *
     * @see <a herf="https://leetcode.cn/problems/search-in-rotated-sorted-array/"></a>
     * 2024/08/02
     * 参考题解：思路二分查找
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }


        }

        return -1;

    }

    /**
     * 30困难跳过
     * 2024/08/01
     * 31. 下一个排列
     * https://leetcode.cn/problems/next-permutation/
     * 参考题解实现，
     */
    public void nextPermutation(int[] nums) {
        //找比i-1位置小的数
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //找比较小的位置，找到较大的位置
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            swap(i, j, nums);
        }

        reverseNum(nums, i + 1);
    }

    private void reverseNum(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(left, right, nums);
            left++;
            right--;
        }

    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 2024/07/31
     * 28. 找出字符串中第一个匹配项的下标
     *
     * @param haystack
     * @param needle
     * @return
     * @see <a hrft="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/"></a>
     * 直接参看了官方题解的暴力解法
     * (有方法二：Knuth-Morris-Pratt 算法 没看，有时间再细细研究了)
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    if (flag) {
                        flag = false;
                    }
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 27. 移除元素
     *
     * @see <a href="https://leetcode.cn/problems/remove-element/"></a>
     * 官方题解 ：双指针
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    /**
     * 27. 移除元素
     *
     * @see <a href="https://leetcode.cn/problems/remove-element/"></a>
     * 自己调试实现
     */
    public int removeElement1(int[] nums, int val) {
        int length = nums.length;
        int index = length - 1;
        int resultLen = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num != val) {
                resultLen++;
                continue;
            }
            while (nums[index] == val && index > 0) {
                index--;
            }

            if (i >= index) {
                break;
            }

            int temp = nums[index];
            nums[i] = temp;
            nums[index] = val;
            index--;
            resultLen++;
        }

        return resultLen;
    }

    /**
     * 26. 删除有序数组中的重复项
     *
     * @param nums
     * @return
     * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/"></a>
     * 2024/06/25 11：09 -11: 30 看了题解 快慢双指针
     */
//参看题解
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int slow = 1;
        int fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    /**
     * 26. 删除有序数组中的重复项
     *
     * @param nums
     * @return
     * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/"></a>
     * 2024/06/25 11：05 -11:09 自己实现，优化前一个
     */
//自己实现
    public int removeDuplicates2(int[] nums) {
        int k = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (integers.contains(num)) {
                continue;
            }
            integers.add(num);
            nums[k] = num;
            k++;

        }
        return integers.size();
    }


    /**
     * 26. 删除有序数组中的重复项
     *
     * @see <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/"></a>
     * 2024/06/25 10:50-11：05 自己实现，但是感觉解法不好
     */
    public int removeDuplicates1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (integers.contains(num)) {
                continue;
            }

            integers.add(num);
            map.put(i, num);
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(i);
            if (value == null) {
                continue;
            }
            nums[k] = value;
            k++;
        }
        return integers.size();
    }

    /**
     * 25. K 个一组翻转链表 hard
     *
     * @see <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/"></a>
     * * 2024/06/24
     * 11：31-..
     * 2024/06/25
     * 9:53-10:45看题解边看边实现的，（没办法看完自己写出来，基本等于抄答案了，只是大意理解了思路）
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            ListNode next = tail.next;
            ListNode[] listNodes = reverseNode(head, tail);
            head = listNodes[0];
            tail = listNodes[1];
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    private ListNode[] reverseNode(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode p = head;
        while (pre != tail) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        return new ListNode[]{tail, head};
    }

    /**
     * 24. 两两交换链表中的节点
     *
     * @see <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/"></a>
     * 2024/06/22
     * 10：05-10:56  未看题解自己实现，及调试
     * 10：56-11：04 优化代码，详看注释粗处，以及看了下题解，和官方题解的迭代思路是一致的
     */
    public ListNode swapPairs(ListNode head) {
        ListNode resultNode = new ListNode();
        ListNode preNode = resultNode;

        while (head != null && head.next != null) {
            ListNode aNode = head;
            ListNode bNode = head.next;
            head = head.next.next;

            resultNode.next = bNode;
//            resultNode = resultNode.next;
//            resultNode.next = aNode;
//              resultNode = resultNode.next.
//            这意味着你并没有移动resultNode的指针，而是直接修改了resultNode的下一个节点的next指针。
            resultNode.next.next = aNode;
            //所以要在此处移动
            resultNode = resultNode.next.next;
        }

        if (resultNode != null) {
            resultNode.next = head;
        }
        return preNode.next;
    }

    /**
     * 23. 合并 K 个升序链表 hard
     *
     * @see <a href="https://leetcode.cn/problems/merge-k-sorted-lists/"></a>
     * 2024/06/21
     * 10:09-10:10 没思路
     * 10：10 -10:18 看题解
     * 10:18-10:25 7min 实现就简单的题解
     * 10：25-10：39 14 调试
     * 10：39-10：46看了分治合并，没看懂。
     */

//参照题解一就最简单的实现
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultNode = null;
        for (int i = 0; i < lists.length; i++) {
            resultNode = mergeTwoList(resultNode, lists[i]);
        }

        return resultNode;
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode resultList = new ListNode();
        ListNode headNode = resultList;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                resultList.next = list1;
                list1 = list1.next;
            } else {
                resultList.next = list2;
                list2 = list2.next;
            }
            resultList = resultList.next;
        }

        resultList.next = list1 == null ? list2 : list1;
        return headNode.next;
    }

    /**
     * 22. 括号生成
     * https://leetcode.cn/problems/generate-parentheses/
     * 2024/06/20
     * 10:01-10:07 想了下没思路
     * 10:07-10:28     看题解，发现刚自己连暴力法都做不出来 ，研究了官方题解回溯
     * 10:29-41  12min写和调试（出错了）
     */

//参照官方题解
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backParenthesis(ans, new StringBuilder(), 0, 0, n);

        return ans;

    }

    private void backParenthesis(List<String> ans, StringBuilder cureStr, int open, int close, int n) {
        if (cureStr.length() == n * 2) {
            ans.add(cureStr.toString());
            //出错点 未写return
            return;
        }

        if (open < n) {
            cureStr.append("(");
            backParenthesis(ans, cureStr, open + 1, close, n);
            //关键思路点，脑子总无法理解回溯~
            cureStr.deleteCharAt(cureStr.length() - 1);
        }

        //出错点 close < open 我写错成open < n
        if (close < open) {
            cureStr.append(")");
            backParenthesis(ans, cureStr, open, close + 1, n);
            cureStr.deleteCharAt(cureStr.length() - 1);
        }
    }

    /**
     * 21. 合并两个有序链表
     *
     * @see <a href="https://leetcode.cn/problems/merge-two-sorted-lists/""></a>
     * 2024/06/19 10:35-10：43 13 参照题解
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resultNode = new ListNode();
        // 2024/06/19 10:35-10：43 13 参照题解
        ListNode headNode = resultNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                resultNode.next = list1;
                list1 = list1.next;
            } else {
                resultNode.next = list2;
                list2 = list2.next;
            }

            resultNode = resultNode.next;
        }
        resultNode.next = list1 == null ? list2 : list1;

        return headNode.next;
    }

    /**
     * 21. 合并两个有序链表
     *
     * @see <a href="https://leetcode.cn/problems/merge-two-sorted-lists/""></a>
     * 2024/06/19 10:12-10：35 23 自己实现
     * 看了下题解，和题解的迭代思路大致是一致的，题解阀门更精简，只剩一个不为空的时候不需要遍历了直接拼接
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode resultNode = new ListNode();
        //调试之后发现少加了这里
        ListNode headNode = resultNode;
        while (list1 != null || list2 != null) {
            int va1 = Integer.MAX_VALUE;
            int va2 = Integer.MAX_VALUE;
            if (list1 != null) {
                va1 = list1.val;
            }
            if (list2 != null) {
                va2 = list2.val;
            }
            if (va1 <= va2) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
                va1 = va2;
            }
            resultNode.next = new ListNode(va1, null);
            //调试之后发现少加了这里
            resultNode = resultNode.next;
        }

        return headNode.next;
    }

    /**
     * 20. 有效的括号
     *
     * @see <a href="https://leetcode.cn/problems/valid-parentheses/"></a>
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 2024/05/07 10：08-10:15 参看题解思路
     * 10：15-10：22 7min写完代码代码
     */
//参照题解实现
    public static boolean isValid(String s) {
        //这个细节是之前未考虑到的
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char curChat = s.charAt(i);

            if (map.get(curChat) != null) {
                if (stack.isEmpty() || stack.peek() != map.get(curChat)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(curChat);
            }
        }
        return stack.isEmpty();
    }


    /**
     * 20. 有效的括号
     *
     * @see <a href="https://leetcode.cn/problems/valid-parentheses/"></a>
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 第一次提交失败：
     * //xxx... return value of "java.util.HashMap.get(Object)" is null
     * 需要加map.get(peek) != null 的判断
     * 2024/05/07 9:48-10：08 30min 思路基本一样我截没有参照官方题解了
     */
//自己实现
    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            char curChat = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(curChat);
                continue;
            }
            Character peek = stack.peek();
            if (map.get(peek) != null && curChat == map.get(peek)) {
                stack.pop();
            } else {
                stack.push(curChat);
            }

        }
        return stack.isEmpty();
    }


    /**
     * 19.删除链表的倒数第N个节点
     * 参照官方题解的双指针解题思路
     *
     * @param head
     * @param n
     * @return
     */
// 参照官方题解的双指针解题思路
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode first = head;
        ListNode curNode = node;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            curNode = curNode.next;
        }

        curNode.next = curNode.next.next;

        return node.next;
    }

    /**
     * 19.删除链表的倒数第N个节点
     *
     * @param head
     * @param n
     * @return
     * @see <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/"></a>
     * 2024/05/06 看了基本和官网截图思路一致。少了个哑节点的设计，导致我判断较多
     * 自己处理的
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode next = head;
        int length = 0;
        while (next != null) {
            length++;
            next = next.next;
        }

        next = head;
        int findN = length - n;

        while (findN > 1 && next != null) {
            findN--;
            next = next.next;
        }

        if (findN == 0 && head != null) {
            head = head.next;
        } else if (next != null && next.next != null) {
            next.next = next.next.next;
        }
        return head;
    }

    /**
     * 18. 四数之和
     *
     * @param nums
     * @param target
     * @return 2024/04/30
     * @see <a href="https://leetcode.cn/problems/4sum/description/"></a>
     * //参照题解思路，稍稍改了自己写的代码（主要是边界值的判断）
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return lists;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }


                //每考虑到负数的情况 如 [1,-2,-5,-4,-3,3,3,5]  -11  我将没有输出
//                if (nums[i] + nums[j] > target) {
//                    continue;
//                }

                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }
                    if (l < nums.length - 1 && nums[l] == nums[l + 1]) {
                        l--;
                        continue;
                    }
                    //未考虑到相加大于int值的场景
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        integers.add(nums[l]);
                        lists.add(integers);
                    }

                    if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }

            }
        }
        return lists;
    }

    /**
     * 18. 四数之和
     *
     * @see <a href="https://leetcode.cn/problems/4sum/"></a>
     * 想到的是用回溯的方法，枚举所有答案看是否符合 写了一会 发现无法实现，于是想到双针吧 写双指针发现没找全=>调整了好久终于实现
     * 提交1： [1,-2,-5,-4,-3,3,3,5]  -11 错误
     * 输出[]
     * 预期结果[[-5,-4,-3,1]]
     * <p>
     * 提交2 [1000000000,1000000000,1000000000,1000000000]
     * target =
     * -294967296
     * <p>
     * 输出
     * [[1000000000,1000000000,1000000000,1000000000]]
     * 预期结果
     * []
     * 2024/04/30
     */
//-2 -1 0 0 1 2
//自己实现
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                //每考虑到负数的情况 如 [1,-2,-5,-4,-3,3,3,5]  -11  我将没有输出
//                if (nums[i] + nums[j] > target) {
//                    continue;
//                }

                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }
                    if (l < nums.length - 1 && nums[l] == nums[l + 1]) {
                        l--;
                        continue;
                    }
                    //未考虑到相加大于int值的场景
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ArrayList<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[k]);
                        integers.add(nums[l]);
                        lists.add(integers);
                    }

                    if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }

            }
        }
        return lists;
    }


    /**
     * 17. 电话号码的字母组合
     * 实现方法：回溯算法
     *
     * @param digits
     * @return
     */
//参看题解
    public List<String> letterCombinations(String digits) {
        ArrayList<String> lists = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return lists;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(lists, map, digits, 0, new StringBuilder());
        return lists;

    }

    private void backtrack(ArrayList<String> lists, HashMap<Character, String> map, String digits, int curIndex, StringBuilder listStrS) {

        if (curIndex == digits.length()) {
            lists.add(listStrS.toString());
        } else {
            String str = map.get(digits.charAt(curIndex));
            for (int i = 0; i < str.length(); i++) {
                listStrS.append(str.charAt(i));
                backtrack(lists, map, digits, curIndex + 1, listStrS);
                listStrS.deleteCharAt(curIndex);
            }
        }
    }


    /**
     * 17. 电话号码的字母组合
     *
     * @see <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/"></a>
     * 能想到用递归，但是我不会写递归
     */
    public List<String> letterCombinations1(String digits) {
        ArrayList<String> lists = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return lists;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        //只写到这里无从下手了

        String s1 = map.get(digits.charAt(0));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {

            char num = digits.charAt(i);

            String s = map.get(num);

        }

        return lists;

    }

    /**
     * 参照题解（对我来说，仍旧比较难，还看了代码）
     * * 16. 最接近的三数之和
     *
     * @param nums
     * @param target
     * @return
     */
//参看题解
    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int resultNum = Integer.MAX_VALUE;

        for (int first = 0; first < nums.length; first++) {
            int firstNum = nums[first];
            if (first > 0 && firstNum == nums[first - 1]) {
                continue;
            }
            int l = first + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = firstNum + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                }

                if (Math.abs(target - sum) < Math.abs(target - resultNum)) {
                    resultNum = sum;
                }

                if (sum > target) {
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else {
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }

        }

        return resultNum;
    }

    /**
     * 16. 最接近的三数之和
     *
     * @see <a href="https://leetcode.cn/problems/3sum-closest/"></a>
     * //调试不过，因为估计是调试了顺序，导致结果不一致  如 [-1,2,1,-4] 我输出-1 他期望2
     * 与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 而我是先排序[-4,-1,1,2] 算出-1 （-4 12 ） 按道理差距也是2
     */
    public static int threeSumClosest1(int[] nums, int target) {

        Arrays.sort(nums);

        int resultNum = Integer.MAX_VALUE;

        for (int first = 0; first < nums.length; first++) {
            int firstNum = nums[first];
            if (firstNum > 0 && firstNum == nums[first - 1]) {
                continue;
            }
            int third = nums.length - 1;

            for (int second = first + 1; second < nums.length; second++) {
                int secondNum = nums[second];
                if (second > first + 1 && secondNum == nums[second - 1]) {
                    continue;
                }

                while (second < third && firstNum + secondNum + nums[third] > target) {
                    third--;
                }

                if (second == third) {
                    break;
                }
                if (third + 1 < nums.length) {
                    if (Math.abs(resultNum - target) > Math.abs(firstNum + secondNum + nums[third + 1] - target)) {
                        resultNum = firstNum + secondNum + nums[third + 1];
                    }

                }

                if (Math.abs(resultNum - target) > Math.abs(firstNum + secondNum + nums[third] - target)) {
                    resultNum = firstNum + secondNum + nums[third];
                }

            }
        }

        return resultNum;
    }

    private static void intCa() {
        //取模问题
        System.out.println(3999 % 1000);
        System.out.println(3999 / 1000);

        System.out.println(999 % 500);
        System.out.println(999 / 500);
    }

    /**
     * 不仅参考题解思路，还看了题解代码，对我来说好难
     *
     * @param nums
     * @return
     */

//参考题解思路
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int firt = 0; firt < nums.length; firt++) {
            int firstNum = nums[firt];
            //同一个index 不能出现相同的数字
            if (firt > 0 && firstNum == nums[firt - 1]) {
                continue;
            }
            int third = nums.length - 1;

            for (int sencod = firt + 1; sencod < nums.length; sencod++) {
                int secondNum = nums[sencod];

                if (sencod > firt + 1 && secondNum == nums[sencod - 1]) {
                    continue;
                }

                //关键是第二个判断条件
                while (sencod < third && secondNum + nums[third] > -firstNum) {
                    third--;
                }

                if (sencod == third) {
                    break;
                }

                if (secondNum + nums[third] + firstNum == 0) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(firstNum);
                    integers.add(secondNum);
                    integers.add(nums[third]);
                    lists.add(integers);
                }
            }

        }
        return lists;
    }

    /**
     * 15.三数之和
     *
     * @see <a href="https://leetcode.cn/problems/3sum/"></a>
     */

//未看题解 (超时了)
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> hash = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                //是以j为基础
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        int hashCode = list.hashCode();
                        if (!hash.contains(hashCode)) {
                            lists.add(list);
                            hash.add(hashCode);

                        }

                    }
                }
            }
        }
        return lists;
    }

    /**
     * 14. 最长公共前缀
     * 题解思路
     * 2024/04/25
     */
//参看了题解思路
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String preStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (preStr.length() == 0) {
                break;
            }
            String curStr = strs[i];
            int length = Math.min(preStr.length(), curStr.length());

            int index = 0;
            while (index < length && preStr.charAt(index) == curStr.charAt(index)) {
                index++;
            }
            preStr = preStr.substring(0, index);
        }
        return preStr;
    }

    /**
     * 14. 最长公共前缀
     *
     * @see <a href="https://leetcode.cn/problems/longest-common-prefix/"></a>
     * <p>
     * <p>
     * 2024/04/24
     * 参看了题解思路
     */
//自己调试
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder resultStr = new StringBuilder();
        int chatIndex = 0;
        char sameC = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (chatIndex == str.length()) {
                break;
            }

            if (i == 0) {
                sameC = str.charAt(chatIndex);
//                "a" 不能continue 比如只有一个  "a"
//                continue;
            }
            char curC = str.charAt(chatIndex);

            if (curC != sameC) {
                break;
            }

            if (i == strs.length - 1) {
                resultStr.append(curC);
                chatIndex++;
                //注意此处应该为-1，结束后会执行+1
                i = -1;
            }
        }
        return resultStr.toString();
    }

    /**
     * 13. 罗马数字转整数
     *
     * @see <a href="https://leetcode.cn/problems/roman-to-integer/"></a>
     * 2024/04/23
     * 参看了题解思路
     */
//参看了题解思路
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int resultValue = 0;

        int length = s.length();
        for (int i = 0; i < length; i++) {
            Integer value = map.get(s.charAt(i));

            if (i < length - 1 && value < map.get(s.charAt(i + 1))) {
                resultValue -= value;
            } else {
                resultValue += value;
            }
        }

        return resultValue;
    }

    /**
     * 13. 罗马数字转整数
     *
     * @see <a href="https://leetcode.cn/problems/roman-to-integer/"></a>
     * 2024/04/23
     * 自己写的
     */
    public static int romanToInt1(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char cOne = s.charAt(i);
            int second = i + 1;
            if (second < s.length()) {
                String findStr = "" + cOne + s.charAt(second);
                if (map.containsKey(findStr)) {
                    result = result + map.get(findStr);
                    i++;
                    continue;
                }
            }
            result = result + map.get(cOne + "");

        }

        return result;
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
