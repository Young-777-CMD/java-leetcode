package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和 (Two Sum)
 *
 * 题目:给定整数数组 nums 和目标值 target,找出和为 target 的两个数的下标。
 *
 * 思路:哈希表,key = 数值,value = 下标。
 *      边遍历边查:先看 target - nums[i] 是否已经在表里,
 *      在 → 直接返回;不在 → 把当前数存进去,继续。
 *      先查后存,天然避免"同一个元素用两次"。
 *
 * 复杂度:时间 O(n) —— 只遍历一次,哈希查询 O(1)
 *        空间 O(n) —— 最坏情况下表里装 n 个元素
 *
 * 日期:2026-09-23(独立做出,W1 / 第 2 天)
 */
public class T001_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(nums.length * 2);

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            Integer j = seen.get(need);
            if (j != null) {
                return new int[]{j, i};
            }
            seen.put(nums[i], i);
        }

        // 题目保证有解,正常走不到这里
        throw new IllegalArgumentException("no two sum solution");
    }
}
