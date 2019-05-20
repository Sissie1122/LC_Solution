//对冲型双指针，不断把短的那一边往里移动
class Solution {
    public int maxArea(int[] height) {
        int size = height.length;
        int start = 0;
        int end = size - 1;
        int ans = 0;
        while(start < end){
            ans = Math.max(Math.min(height[start], height[end]) * (end - start), ans);
            if(height[start] > height[end]){
                end--;
            }
            else{
                start++;
            }
        }
        return ans;
    }
}