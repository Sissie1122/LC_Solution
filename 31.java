//背熟找next permutation的公式即可：
//查找从后往前第一个nums[index1] < nums[index + 1];
//其次从后往前查找第一个nums[index2] > nums[index1];
//swap(nums, index1, index2)
//reverse(nums, index1 + 1, size - 1)
class Solution {
    public void nextPermutation(int[] nums) {
        int size = nums.length;
        if(size == 0){
            return;
        }
        int index1 = size;
        for(int i = size - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index1 = i;
                break;
            }
        }
        if(index1 == size){
            reverse(nums, 0, size - 1);
            return;
        }
        int index2 = size;
        for(int i = size - 1; i > index1; i--){
            if(nums[i] > nums[index1]){
                index2 = i;
                break;
            }
        }
        //System.out.format("num1 = %d; num2 = %d%n", nums[index1], nums[index2]);
        swap(nums, index1, index2);
        reverse(nums, index1 + 1, size - 1);
    }
    
    private void swap(int[] nums, int i, int j){
        if(i != j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
}