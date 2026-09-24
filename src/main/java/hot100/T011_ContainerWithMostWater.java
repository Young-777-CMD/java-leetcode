package hot100;

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/
 *
 * 我的思路(自己写,别抄题解):
 *
 * 关键点(一句话说清"这题在考什么"):
 *
 * 复杂度:时间 O(?) / 空间 O(?)
 */
public class T011_ContainerWithMostWater {

    public int maxArea(int[] height) {
        // TODO 把力扣「提交记录」里那次通过的代码粘到这里
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
        // 注意三条:
        //   1. 类名保持 T011_ContainerWithMostWater(别改回 Solution)
        //   2. 力扣自动生成的带下划线的参数名,改成正常命名
        //   3. 删掉 main 方法和调试用的打印
    }
}