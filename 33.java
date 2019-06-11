//二分查找的变形
class Solution {
    public int search(int[] nums, int target) {
        int size = nums.length;
        if(size == 0){
            return -1;
        }
        int start = 0;
        int end = size - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < nums[end]){
                if(target > nums[mid] && target <= nums[end]){
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
            else{
                if(target >= nums[start] && target < nums[mid]){
                    end = mid;
                }
                else{
                    start = mid;
                }
            }
        }
        if(nums[start] == target){
            return start;
        }
        else if(nums[end] == target){
            return end;
        }
        else{
            return -1;
        }
    }
}