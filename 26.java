//注意需要一个变量记住上一个访问过的元素的值
class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if(size == 0){
            return 0;
        }
        int index = 0;
        int lastVal = -1;
        for(int i = 0; i < size; i++){
            
            if(i == 0 || nums[i] != lastVal){
                lastVal = nums[i];
                swap(nums, index, i);
                index++;
            }
            
        }
        return index;
    }
    
    private void swap(int[] nums, int j, int i){
        if(i != j){
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }
}