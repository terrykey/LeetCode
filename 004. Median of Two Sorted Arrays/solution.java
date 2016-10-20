public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0)
            System.exit(-1);
            
        return findMedian(nums1, 0, nums1.length, nums2, 0, nums2.length);
    }
    
    private static double findMedian(int[] nums1, int start1, int length1, int[] nums2, int start2, int length2) {
        if(length2 < length1)
            return findMedian(nums2, start2, length2, nums1, start1, length1);
        
        if(length2 < 6)
            return trivalAnswer(nums1, start1, length1, nums2, start2, length2);
            
        if(2 * length1 < length2)
            return findMedian(nums1, start1, length1, nums2, start2 + (length2 - length1 - 1) / 2, length1 + 2 - (length2 - length1) % 2);
            
        int mi1 = start1 + length1 / 2;
        int mi2a = start2 + (length1 - 1) / 2;
        int mi2b = start2 + length2 - 1 - length1 / 2;
        
        if(nums1[mi1] < nums2[mi2a])
            return findMedian(nums1, mi1, (length1 + 1) / 2, nums2, start2, length2 - length1 / 2);
        else if(nums2[mi2b] < nums1[mi1])
            return findMedian(nums1, start1, length1 / 2 + 1, nums2, mi2a, length2 - (length1 - 1) / 2);
        else
            return findMedian(nums1, start1, length1, nums2, mi2a, length2 - (length1 - 1) / 2 * 2);
    }
    
    private static double trivalAnswer(int[] nums1, int start1, int length1, int[] nums2, int start2, int length2) {
        int length = length1 + length2;
        int[] nums = new int[length / 2 + 1];
        int i = 0, j = 0, k = 0;
        while(k < length / 2 + 1) {
            if(length1 <= i)
                nums[k++] = nums2[start2 + (j++)];
            else if(length2 <= j) 
                nums[k++] = nums1[start1 + (i++)];
            else if(nums1[start1 + i] <= nums2[start2 + j])
                nums[k++] = nums1[start1 + (i++)];
            else
                nums[k++] = nums2[start2 + (j++)];
        }
        if(length % 2 == 0)
            return (nums[k - 1] + nums[k - 2]) / 2.0;
        else
            return nums[k - 1];
    }
}