//使用index记录有效位置
class Solution {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        if(size == 0){
            return 0;
        }
        int index = 0;
        for(int i = 0; i < size; i++){
            if(nums[i] != val){
                swap(nums, i, index);
                index++;
            }
        }
        return index;
    }
    
    private void swap(int[] nums, int i, int j){
        if(i != j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}