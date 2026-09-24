package hot100;

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *
 * 我的思路(自己写,别抄题解):
 *
 * 关键点(一句话说清"这题在考什么"):
 *
 * 复杂度:时间 O(?) / 空间 O(?)
 */
public class T026_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        // TODO 把力扣「提交记录」里那次通过的代码粘到这里
        int k;

        int slow=0;
        int fast=1;
        while(fast<nums.length){
            if(nums[slow] == nums[fast]){
                fast++;
            }else{
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        k=slow+1;
        return k;

        // 注意三条:
        //   1. 类名保持 T026_RemoveDuplicatesFromSortedArray(别改回 Solution)
        //   2. 力扣自动生成的带下划线的参数名,改成正常命名
        //   3. 删掉 main 方法和调试用的打印
    }
}