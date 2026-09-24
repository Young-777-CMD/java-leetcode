package hot100;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/
 *
 * 我的思路(自己写,别抄题解):
 *
 * 关键点(一句话说清"这题在考什么"):
 *
 * 复杂度:时间 O(?) / 空间 O(?)
 */
public class T283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        int slow = 0; // slow 指向下一个非零元素应该放置的位置
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                // 交换 slow 和 fast 位置的元素
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
        // 注意三条:
        //   1. 类名保持 T283_MoveZeroes(别改回 Solution)
        //   2. 力扣自动生成的带下划线的参数名,改成正常命名
        //   3. 删掉 main 方法和调试用的打印
    }
}