package hot100;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 1. 两数之和 —— 测试
 *
 * 为什么刷题仓库也要写测试:
 *   1. 面试前二刷时,不用重新想用例,跑一遍就知道实现还对不对
 *   2. 改成另一种解法(比如排序+双指针)时,能立刻验证没改坏
 *   3. 养成"代码要有验证手段"的习惯 —— 这正是简历项目里最缺的东西
 */
class T001_TwoSumTest {

    private final T001_TwoSum solution = new T001_TwoSum();

    @Test
    @DisplayName("示例 1:nums=[2,7,11,15], target=9 → [0,1]")
    void example1() {
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    @DisplayName("示例 2:nums=[3,2,4], target=6 → [1,2]")
    void example2() {
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(new int[]{3, 2, 4}, 6));
    }

    @Test
    @DisplayName("示例 3:两个相同元素 [3,3], target=6 → [0,1]")
    void example3() {
        assertArrayEquals(new int[]{0, 1}, solution.twoSum(new int[]{3, 3}, 6));
    }

    @Test
    @DisplayName("边界:不能把同一个元素用两次")
    void sameElementTwiceIsRejected() {
        // [3,3] target=6 必须返回 [0,1] 而不是 [0,0]
        int[] r = solution.twoSum(new int[]{3, 3}, 6);
        assertEquals(2, r.length);
        assertTrue(r[0] != r[1], "两个下标不能相同");
    }

    @Test
    @DisplayName("边界:答案在数组两端")
    void answerAtBothEnds() {
        // 这条用例专门打"先存后查"的写法:若先把当前元素存进表再查,
        // 当 target - nums[i] == nums[i](即 target = 2*nums[i])时会返回 [i,i]
        int[] nums = {5, 1, 2, 3, 5};
        int[] r = solution.twoSum(nums, 10);
        assertArrayEquals(new int[]{0, 4}, r);
    }

    @Test
    @DisplayName("边界:负数与目标值 0")
    void negatives() {
        int[] r = solution.twoSum(new int[]{-3, 4, 3, 90}, 0);
        assertArrayEquals(new int[]{0, 2}, r);
    }

    @Test
    @DisplayName("无解时抛异常")
    void noSolution() {
        assertThrows(IllegalArgumentException.class,
                () -> solution.twoSum(new int[]{1, 2, 3}, 100));
    }

    @Test
    @DisplayName("性能:10 万个元素不超时(O(n) 的意义)")
    void largeInput() {
        int n = 100_000;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        long start = System.nanoTime();
        int[] r = solution.twoSum(nums, (n - 1) + (n - 2));
        long costMs = (System.nanoTime() - start) / 1_000_000;

        assertArrayEquals(new int[]{n - 2, n - 1}, r);
        assertTrue(costMs < 500, "O(n) 解法不该超过 500ms,实际 " + costMs + "ms");
    }

    @Test
    @DisplayName("记录:暴力 O(n²) 的对照(仅供对比,不参与生产)")
    void bruteForceForComparison() {
        int[] nums = {2, 7, 11, 15};
        assertEquals("[0, 1]", Arrays.toString(bruteForce(nums, 9)));
    }

    private int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }
}
