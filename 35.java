//寻找 first >= 的元素
class Solution {
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        if(size == 0){
            return 0;
        }
        int start = 0;
        int end = size - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        if(nums[start] >= target){
            return start;
        }
        else if(nums[end] >= target){
            return end;
        }
        else{
            return size;
        }
    }
}