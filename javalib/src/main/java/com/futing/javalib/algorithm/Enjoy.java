package com.futing.javalib.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by futing on 2024/8/29.
 */
public class Enjoy {


    public static void main(String[] args) {

    }


    // TODO: 2024/8/29
//    一数组

    /**
     * 1、如何在一个1到100的整数数组中找到丢失的数字？ .google,amazon,tencent
     * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/
     * : 2024/8/29 17min 看了题解
     */
    public int takeAttendance(int[] records) {
        int n = records.length;
        int l = 0, r = n - 1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            if (records[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    /**
     * 2.如何在给定的整数数组中找到重复的数字？小米
     * //未看题解5min ->但是超时啦啦
     */
    public int findRepeatDocument1(int[] documents) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < documents.length; i++) {
            if (integers.contains(documents[i])) {
                return documents[i];
            }
            integers.add(documents[i]);
        }
        return -1;
    }

    //题解1：要改成set才行
    public int findRepeatDocument2(int[] documents) {
        Set<Integer> hmap = new HashSet<>();
        for (int doc : documents) {
            if (hmap.contains(doc)) return doc;
            hmap.add(doc);
        }
        return -1;
    }

    //题解2：不需集合，
    public int findRepeatDocument(int[] documents) {
        int i = 0;
        while (i < documents.length) {
            if (documents[i] == i) {
                i++;
                continue;
            }
            int temp = documents[i];
            if (documents[temp] == temp) return temp;
            int document = documents[temp];
            documents[temp] = temp;
            documents[i] = document;

        }
        return -1;
    }

    /**
     * 3.
     * 给定一个存放整数的数组，重新排钢数组使得数组左边为奇数，右边为得数，更来空询夏快现q,8
     * 杂度为0(n),百度
     * https://blog.csdn.net/dahai_881222/article/details/7824958  这个没看
     * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/description/
     */
    // TODO: 2024/8/29
    //自己实现 8min
    // TODO: 2024/8/29 还可以再优化，在里面嵌套两个while如果l是偶数再停下来，r是奇数再停下来
    public int[] trainingPlan(int[] actions) {
        int l = 0, r = actions.length - 1;
        while (l < r) {
            int action = actions[l];

            if (action % 2 != 0) {
                l++;
                continue;
            }
            actions[l] = actions[r];
            actions[r] = action;
            r--;
        }

        return actions;
    }

    /**
     *6.,给定一个二进制数据位数，输出所有2进制数所对应的所有的自然数，要求时间复杂度优先，喜马拉雅
     *https://ask.csdn.net/questions/382489?sort=votes_count
     *不是乐扣的掠过吧
     */
    /**
     * 7.在va中如何从给定排序数组中删除重复项？小米
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
     * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/description/
     * 看着很简单那其实不知道要怎么做啊 55 min 看了题解
     */
    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }

        int slow = 1, fast = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;

    }

    //写了一些，看了题解
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int fast = 2, slow = 2;
        while (fast < n) {
            if (nums[fast] != nums[slow  - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
