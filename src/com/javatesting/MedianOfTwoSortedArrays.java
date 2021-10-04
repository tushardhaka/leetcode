package com.javatesting;

public class MedianOfTwoSortedArrays {

    public static void main(String [] args){

        int[] nums1 = new int[]{2,2,4,4};
        int[] nums2 = new int[]{2,2,4,4};

        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int sizeNum1 = nums1.length;
        int sizeNum2 = nums2.length;
        int[] merged = new int[sizeNum1 + sizeNum2];

        int counter1=0;
        int counter2=0;
        for(int i=0; i<sizeNum1 + sizeNum2;i++){

            if(sizeNum1 - counter1>0 && sizeNum2 - counter2>0) {
                if (nums1[counter1] == nums2[counter2]) {
                    merged[i] = nums1[counter1];
                    i++;
                    counter1++;
                    if(i>=sizeNum1 + sizeNum2){
                        break;
                    }
                    merged[i] = nums2[counter2];
                    counter2++;
                }
                else if (nums1[counter1] > nums2[counter2]) {
                    merged[i] = nums2[counter2];
                    counter2++;
                }
                else if (nums2[counter2] > nums1[counter1]) {
                    merged[i] = nums1[counter1];
                    counter1++;
                }
            }
            else {
                if (sizeNum1 - counter1 == 0 && sizeNum2 - counter2 > 0) {
                    merged[i] = nums2[counter2];
                    counter2++;
                }
                if (sizeNum2 - counter2 == 0 && sizeNum1 - counter1 > 0) {
                    merged[i] = nums1[counter1];
                    counter1++;
                }
            }
        }
        if((sizeNum1 + sizeNum2)%2==0){
            double output = (merged[(sizeNum1 + sizeNum2)/2 -1] + merged[((sizeNum1 + sizeNum2)/2)])/2d;
            return output;
        }
        else{
            return merged[(sizeNum1 + sizeNum2)/2];
        }


    }
}
