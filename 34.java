//两个二分法的叠加，需要注意的是，第一个二分法完成之后，start指针的位置可以保留
//以供下一个二分过程使用
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int size = nums.length;
        if(size == 0){
            return res;
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
        if(nums[start] == target){
            res[0] = start;
        }
        else if(nums[end] == target){
            res[0] = end;
        }
        else{
            return res;
        }
        end = size - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(nums[end] == target){
            res[1] = end;
        }
        else{
            res[1] = start;
        }
        return res;
    }
}