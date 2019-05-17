//Merge Sort的变种，记得永远去除不可能存在第k个元素的序列
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if((len1 + len2) % 2 == 0){
            double a = findKthElement(nums1, 0, len1, nums2, 0, len2, (len1 + len2) / 2 + 1);
            double b = findKthElement(nums1, 0, len1, nums2, 0, len2, (len1 + len2) / 2);
            return (a + b) / 2;
        }
        else{
            return findKthElement(nums1, 0, len1, nums2, 0, len2, (len1 + len2) / 2 + 1);
        }
        
    }
    
    private int findKthElement(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k){
        if(s1 == e1){
            return nums2[s2 + k - 1];
        }
        if(s2 == e2){
            return nums1[s1 + k - 1];
        }
        if(k == 1){
            return Math.min(nums1[s1], nums2[s2]);
        }
        int x1 = (s1 + k / 2 - 1 < e1 ? nums1[s1 + k / 2 - 1] : Integer.MAX_VALUE);
        int x2 = (s2 + k / 2 - 1 < e2 ? nums2[s2 + k / 2 - 1] : Integer.MAX_VALUE);
        if(x1 < x2){
            s1 += (k / 2);
        }
        else{
            s2 += (k / 2);
        }
        return findKthElement(nums1, s1, e1, nums2, s2, e2, k - k / 2);
    }
}